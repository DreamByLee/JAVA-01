package com.example.demo.param;

import com.example.demo.entity.Account;
import com.example.demo.enums.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Leeyj
 * @date 2021/3/26 23:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeParam {

    private long customerId;

    private Currency currency;

    private BigDecimal amount;
}
