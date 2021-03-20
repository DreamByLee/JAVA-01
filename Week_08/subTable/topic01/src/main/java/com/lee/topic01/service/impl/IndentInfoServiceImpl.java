package com.lee.topic01.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.topic01.entity.IndentInfo;
import com.lee.topic01.mapper.IndentMapper;
import com.lee.topic01.service.IndentInfoService;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Leeyj
 * @date 2021/3/17 15:36
 */
@Service
public class IndentInfoServiceImpl extends ServiceImpl<IndentMapper,IndentInfo> implements IndentInfoService {
    @Override
    public boolean saveIndent(IndentInfo indentInfo) {
        return baseMapper.insert(indentInfo) == 0 ? false : true;
    }

    @Override
    public boolean rmIndent(IndentInfo indentInfo) {
        Integer status =  baseMapper.delete(new LambdaQueryWrapper<IndentInfo>()
                .eq(IndentInfo::getIndentId, indentInfo.getIndentId())
                .eq(IndentInfo::getCustomerId,indentInfo.getCustomerId()));
        return status == 0 ? false : true;
    }

    @Override
    public boolean upIndent(IndentInfo indentInfo) {
        return baseMapper.updateById(indentInfo) == 0 ? false : true;
    }

    @Override
    public List<IndentInfo> queryIndent(IndentInfo indentInfo) {
        return baseMapper.selectList(new LambdaQueryWrapper<IndentInfo>()
                .eq(IndentInfo::getIndentId,indentInfo.getIndentId())
                .eq(IndentInfo::getCustomerId,indentInfo.getCustomerId())
        );
    }

    @Transactional
    @ShardingTransactionType(TransactionType.XA)
    @Override
    public void saveIndentXA(List<IndentInfo> indentInfos) {
        super.saveBatch(indentInfos);
    }

}
