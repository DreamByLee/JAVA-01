package com.example.demo.service;

import com.example.demo.enums.Currency;
import com.example.demo.enums.FreezeState;
import com.example.demo.enums.FreezeType;

import java.math.BigDecimal;

/**
 * 进出账业务
 * @author Leeyj
 * @date 2021/3/27 12:44
 */
public interface IncomeService {
    void updateBalance(long exchangeId, long customerId, Currency currency, BigDecimal amount, FreezeType type, FreezeState state);

    /**
     * 进账确认
     * @param exchangeId
     * @param customerId
     * @param currency
     * @param amount
     */
    void confirm(long exchangeId, long customerId, Currency currency, BigDecimal amount);

    /**
     * 进账撤销
     * @param exchangeId
     * @param customerId
     * @param currency
     * @param amount
     */
    void cancel(long exchangeId, long customerId, Currency currency, BigDecimal amount);
}
