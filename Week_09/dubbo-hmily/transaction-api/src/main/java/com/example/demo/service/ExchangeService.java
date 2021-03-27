package com.example.demo.service;

import com.example.demo.param.ExchangeParam;
import org.dromara.hmily.annotation.Hmily;

/**
 * @author Leeyj
 * @date 2021/3/26 23:25
 */
public interface ExchangeService {
    @Hmily
    void exchange(long exchangeId, ExchangeParam initiatorUserParam, ExchangeParam targetUserParam);
}
