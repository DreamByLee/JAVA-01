package com.example.demo.service.impl;

import com.example.demo.entity.Account;
import com.example.demo.enums.Currency;
import com.example.demo.enums.FreezeState;
import com.example.demo.enums.FreezeType;
import com.example.demo.service.CurrencyService;
import com.example.demo.service.IncomeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.dromara.hmily.annotation.HmilyTCC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author Leeyj
 * @date 2021/3/27 13:30
 */
@Slf4j
@DubboService(version = "1.0.0", tag = "currency", weight = 100)
public class CurrencyServiceImpl implements CurrencyService {
    @Autowired
    private IncomeService incomeService;

    @HmilyTCC(confirmMethod = "confirm", cancelMethod = "cancel")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void exchange(long exchangeId, long userId, Currency inCurrency, Currency outCurrency, BigDecimal inAmount, BigDecimal outAmount) {
        log.info("交易开始:{}, {}, {}", exchangeId, userId, outCurrency);

        // 转出账户
        incomeService.updateBalance(exchangeId, userId, outCurrency, outAmount, FreezeType.OUT, FreezeState.PRE);
    }


    public void confirm(long exchangeId, long userId, Currency inCurrency, BigDecimal inAmount) {

        log.info("确认交易:{}, {}, {}", exchangeId, userId, inCurrency);

        incomeService.confirm(exchangeId, userId, inCurrency, inAmount);

    }

    public void cancel(long exchangeId, long userId, Currency outCurrency, BigDecimal outAmount) {

        log.info("取消交易:{}, {}, {}", exchangeId, userId, outCurrency);

        incomeService.cancel(exchangeId, userId, outCurrency, outAmount);
    }


}
