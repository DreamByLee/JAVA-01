package com.example.demo.service;

import com.example.demo.enums.Currency;
import org.dromara.hmily.annotation.Hmily;

import java.math.BigDecimal;

public interface CurrencyService {
    @Hmily
    void exchange(long exchangeId, long userId, Currency inCurrency, Currency outCurrency, BigDecimal inAmount, BigDecimal outAmount);
}
