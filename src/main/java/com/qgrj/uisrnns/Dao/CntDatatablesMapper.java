package com.qgrj.uisrnns.Dao;



import com.qgrj.uisrnns.Pojo.CntDatatables;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface CntDatatablesMapper {
    int deleteByPrimaryKey(Integer uid);
    int insert(CntDatatables record);
    CntDatatables selectByPrimaryKey(Integer uid);
    List<CntDatatables> selectAll();
    int updateByPrimaryKey(CntDatatables record);


    // 昨天流量
    @Select("SELECT sum(PeopleNum) as num FROM cnt_datatables WHERE (TO_DAYS(NOW()) - TO_DAYS(cnt_datatables.Date)  )= 1")
    public Integer getYesterdayNum();

    // 今天流量
    @Select("SELECT sum(PeopleNum) FROM cnt_datatables WHERE TO_DAYS(cnt_datatables.Date) = TO_DAYS(NOW())")
    public Integer getTodayNum();

    // 最高流量纪录
    @Select("SELECT max(PeopleNum) as num FROM cnt_datatables")
    public Integer flowRecord();

    //近七天的数据
    @Select("SELECT * FROM cnt_datatables WHERE (TO_DAYS(NOW()) - TO_DAYS(cnt_datatables.Date)  )<= 7  order by Date ASC")
    public List<CntDatatables> getLastSevenDayInfo();

    //某楼七天数据
    @Select("SELECT * FROM cnt_datatables WHERE (TO_DAYS(NOW()) - TO_DAYS(cnt_datatables.Date)  )<= 7 and Location LIKE CONCAT(#{id},'%')  order by Date ASC")
    public List<CntDatatables> getLastSevenDayInfoById(@Param("id") String id);

    //某楼梯口数据
    @Select("SELECT * FROM cnt_datatables WHERE Location=#{id}  order by Date ASC")
    public List<CntDatatables> getLastSevenDayInfoByIder(@Param("id") String id); // 精确

    //某楼梯口数据
    @Select("select * from cnt_datatables WHERE PeopleNum =  (SELECT min(cnt_datatables.PeopleNum) FROM cnt_datatables WHERE cnt_datatables.Location LIKE CONCAT(#{id},'%')) and Location LIKE CONCAT(#{id},'%');")
    public List<CntDatatables> getLastSevenDayInfoByIdyou(@Param("id") String id); //  1 2 3


}