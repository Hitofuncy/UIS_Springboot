package com.qgrj.uisrnns.Service;

import com.qgrj.uisrnns.Pojo.CntDatatables;

import java.util.List;

public interface CntDatatablesService {

    int deleteByPrimaryKey(Integer uid);

    int insert(CntDatatables record);

    CntDatatables selectByPrimaryKey(Integer uid);

    List<CntDatatables> selectAll();

    int updateByPrimaryKey(CntDatatables record);

}
