package com.example.demo;

import com.example.demo.entity.Account;
import com.example.demo.enums.Currency;
import com.example.demo.param.ExchangeParam;
import com.example.demo.service.CurrencyService;
import com.example.demo.service.ExchangeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.dromara.hmily.annotation.HmilyTCC;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author Leeyj
 * @date 2021/3/26 23:32
 */
@Slf4j
@Service
public class ExchangeServiceImpl implements ExchangeService {
    @DubboReference(version = "1.0.0")
    private CurrencyService accountService;

    @HmilyTCC(confirmMethod = "confirmExchange", cancelMethod = "cancelExchange")
    @Override
    public void exchange(long exchangeId, ExchangeParam initiatorUserParam, ExchangeParam targetUserParam) {
        Currency initiatorCurrency = initiatorUserParam.getCurrency();
        BigDecimal initiatorAmount = initiatorUserParam.getAmount();

        Currency targetCurrency = targetUserParam.getCurrency();
        BigDecimal targetAmount = targetUserParam.getAmount();

        // 发起账户A转出
        accountService.exchange(exchangeId, initiatorUserParam.getCustomerId(), targetCurrency, initiatorCurrency, targetAmount, initiatorAmount);

        // 目标用户B转出
        accountService.exchange(exchangeId, targetUserParam.getCustomerId(), initiatorCurrency, targetCurrency, initiatorAmount, targetAmount);
    }

    public void confirmExchange(long exchangeId, ExchangeParam initiatorUserParam, ExchangeParam targetUserParam) {
        log.info("确认");
    }

    public void cancelExchange(long exchangeId, ExchangeParam initiatorUserParam, ExchangeParam targetUserParam) {
        log.info("回滚");
    }
}
