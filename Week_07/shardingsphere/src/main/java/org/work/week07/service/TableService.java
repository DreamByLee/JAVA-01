package org.work.week07.service;


import org.work.week07.entity.TableBean;

import java.util.List;

public interface TableService {
    List<TableBean> findAll();

    Integer addInfo(TableBean tableBean);
}
