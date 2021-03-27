package com.example.demo;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.example.demo.enums.Currency;
import com.example.demo.param.ExchangeParam;
import com.example.demo.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author Leeyj
 * @date 2021/3/26 23:31
 */
@RestController
@RequestMapping("/exchange")
public class ExchangeContoller {

    private Snowflake snowflake = IdUtil.getSnowflake(1, 1);

    @Autowired
    private ExchangeService exchangeService;

    @GetMapping(value = "/execute")
    public String execute() {

        long exchangeId = snowflake.nextId();

        ExchangeParam initiatorUserParam = new ExchangeParam();

        // A账户
        initiatorUserParam.setCustomerId(1L);
        initiatorUserParam.setAmount(BigDecimal.valueOf(1));
        initiatorUserParam.setCurrency(Currency.USD);

        // B账户
        ExchangeParam targetUserParam = new ExchangeParam();
        targetUserParam.setCustomerId(2L);
        targetUserParam.setAmount(BigDecimal.valueOf(7));
        targetUserParam.setCurrency(Currency.CNY);

        // A账户1美元，兑换B账户7人民币
        exchangeService.exchange(exchangeId, initiatorUserParam, targetUserParam);

        //exchangeService.confirmExchange(exchangeId, initiatorUserParam, targetUserParam);
        return "success";
    }
}
