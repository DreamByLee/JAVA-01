package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.example.demo.entity.Account;
import com.example.demo.entity.Freeze;
import com.example.demo.enums.Currency;
import com.example.demo.enums.FreezeState;
import com.example.demo.enums.FreezeType;
import com.example.demo.mapper.AccountMapper;
import com.example.demo.mapper.FreezyMapper;
import com.example.demo.service.IncomeService;
import lombok.extern.slf4j.Slf4j;
import org.dromara.hmily.common.exception.HmilyRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author Leeyj
 * @date 2021/3/27 12:47
 */
@Service
@Slf4j
public class IncomeServiceImpl implements IncomeService {
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private FreezyMapper freezyMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateBalance(long exchangeId, long customerId, Currency currency, BigDecimal amount, FreezeType type, FreezeState state) {
        // 1、更新余额
        int result = 0;

        // 2、查询余额
        Account queryAccount = accountMapper.selectOne(new LambdaQueryWrapper<Account>()
                .eq(Account::getCustomerId,customerId)
                .eq(Account::getCurrency,currency.name()));
        switch (type) {
            case IN:
                // 增加余额
                result = accountMapper.update(null,new LambdaUpdateWrapper<Account>()
                        .eq(Account::getCustomerId,customerId)
                        .eq(Account::getCurrency,currency.name())
                        .set(Account::getBalance,queryAccount.getBalance().add(amount)));
                break;
            case OUT:
                //减少余额
                result = accountMapper.update(null,new LambdaUpdateWrapper<Account>()
                        .eq(Account::getCustomerId,customerId)
                        .eq(Account::getCurrency,currency.name()).set(Account::getBalance,queryAccount.getBalance().subtract(amount)));
                break;
        }

        if (result <= 0) {
            log.info("更新余额失败（余额不足等情况）");
            throw new HmilyRuntimeException("更新余额失败");
        }
        queryAccount = accountMapper.selectOne(new LambdaQueryWrapper<Account>()
                .eq(Account::getCustomerId,customerId)
                .eq(Account::getCurrency,currency.name()));

        // 3、记录变更记录（后续确认、撤销的依据）
        Freeze freeze = new Freeze();
        freeze.setExchangeId(exchangeId);
        freeze.setCustomerId(customerId);
        freeze.setAccountId(queryAccount.getId());
        freeze.setAmount(amount);
        freeze.setType(type.getVal());
        freeze.setState(state.getVal());
        freezyMapper.insert(freeze);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void confirm(long exchangeId, long customerId, Currency currency, BigDecimal amount) {
        // 记录标记为确认
        int result = freezyMapper.update(null, new LambdaUpdateWrapper<Freeze>()
                .eq(Freeze::getCustomerId,customerId)
                .eq(Freeze::getExchangeId,exchangeId)
                .ne(Freeze::getState,FreezeState.CONFIRM.getVal()).set(Freeze::getState,FreezeState.CONFIRM.getVal()));
        // 保证幂等
        if (result <= 0) {
            return;
        }

        // 将兑换的货币金额转入账户
        updateBalance(exchangeId, customerId, currency, amount, FreezeType.IN, FreezeState.CONFIRM);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void cancel(long exchangeId, long customerId, Currency currency, BigDecimal amount) {

        // 记录标记为取消
        int result = freezyMapper.update(null, new LambdaUpdateWrapper<Freeze>()
                .eq(Freeze::getCustomerId,customerId)
                .eq(Freeze::getExchangeId,exchangeId)
                .ne(Freeze::getState,FreezeState.CANCEL.getVal())
                .set(Freeze::getState,FreezeState.CANCEL.getVal()));
        // 保证幂等
        if (result <= 0) {
            return;
        }

        // 冻结的金额返回到转出账户
        Account queryAccount = accountMapper.selectOne(new LambdaQueryWrapper<Account>()
                .eq(Account::getCustomerId,customerId)
                .eq(Account::getCurrency,currency.name()));

        accountMapper.update(null,new LambdaUpdateWrapper<Account>()
                .eq(Account::getCustomerId,customerId)
                .eq(Account::getCurrency,currency.name()).set(Account::getBalance,queryAccount.getBalance().add(amount)));
    }
}
