package org.work.week07.dao;

import org.apache.ibatis.annotations.Mapper;
import org.work.week07.entity.TableBean;

import java.util.List;

@Mapper
public interface TableMapper {

    List<TableBean> selectAll();

    boolean insertInfo(TableBean tableBean);
}
