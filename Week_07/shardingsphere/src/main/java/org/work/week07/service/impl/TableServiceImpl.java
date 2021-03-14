package org.work.week07.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.work.week07.dao.TableMapper;
import org.work.week07.entity.TableBean;
import org.work.week07.service.TableService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

/**
 * @author Leeyj
 * @date 2021/3/12 21:57
 */
@Service
public class TableServiceImpl implements TableService {
    @Autowired
    private TableMapper tableMapper;

    @Override
    public List<TableBean> findAll() {
        return tableMapper.selectAll();
    }

    @Override
    public Integer addInfo(TableBean tableBean) {
        Random ra =new Random();
        tableBean.setId(ra.nextInt(100)+1);
        tableMapper.insertInfo(tableBean);
        return tableBean.getId();
    }
}
