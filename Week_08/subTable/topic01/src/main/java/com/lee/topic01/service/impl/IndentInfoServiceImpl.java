package com.lee.topic01.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.topic01.entity.IndentInfo;
import com.lee.topic01.mapper.IndentMapper;
import com.lee.topic01.service.IndentInfoService;
import org.springframework.stereotype.Service;

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
    public boolean rmIndent(Integer indentId) {
        return baseMapper.deleteById(indentId) == 0 ? false : true;
    }

    @Override
    public boolean upIndent(IndentInfo indentInfo) {
        return baseMapper.updateById(indentInfo) == 0 ? false : true;
    }

    @Override
    public List<IndentInfo> queryIndent() {
        return baseMapper.selectList(Wrappers.<IndentInfo>lambdaQuery());
    }

}
