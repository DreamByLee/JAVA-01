package org.week07.sourceV1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.week07.sourceV1.dao.TableMapper;
import org.week07.sourceV1.entity.TableBean;

import java.util.List;

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
}
