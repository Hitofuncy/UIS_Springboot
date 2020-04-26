package com.qgrj.uisrnns.Dao;



import com.qgrj.uisrnns.Pojo.CntBell;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface CntBellMapper {
    int deleteByPrimaryKey(Integer lh);

    int insert(CntBell record);

    CntBell selectByPrimaryKey(Integer lh);

    List<CntBell> selectAll();

    int updateByPrimaryKey(CntBell record);

    @Select("select Location from cnt_bell where RouterID=#{id}")
    String selectByidofplace(Integer id);
}