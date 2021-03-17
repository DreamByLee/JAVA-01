package com.lee.topic01.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lee.topic01.entity.IndentInfo;

import java.util.List;

public interface IndentInfoService extends IService<IndentInfo> {

    /**
     * 保存订单信息
     * @param indentInfo
     * @return
     */
    boolean saveIndent(IndentInfo indentInfo);

    /**
     * 删除订单
     * @param indentId
     * @return
     */
    boolean rmIndent(Integer indentId);

    /**
     * 修改订单
     * @param indentInfo
     * @return
     */
    boolean upIndent(IndentInfo indentInfo);

    /**
     * 查询订单
     * @return
     */
    List<IndentInfo> queryIndent();
}
