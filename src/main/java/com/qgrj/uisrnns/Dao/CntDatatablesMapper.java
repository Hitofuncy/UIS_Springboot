package com.qgrj.uisrnns.Dao;



import com.qgrj.uisrnns.Pojo.CntDatatables;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CntDatatablesMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(CntDatatables record);

    CntDatatables selectByPrimaryKey(Integer uid);

    List<CntDatatables> selectAll();

    int updateByPrimaryKey(CntDatatables record);
}