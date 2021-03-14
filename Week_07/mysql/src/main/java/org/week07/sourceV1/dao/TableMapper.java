package org.week07.sourceV1.dao;

import org.springframework.stereotype.Repository;
import org.week07.sourceV1.entity.TableBean;

import java.util.List;

@Repository
public interface TableMapper {

    List<TableBean> selectAll();

    boolean insertInfo(TableBean tableBean);
}
