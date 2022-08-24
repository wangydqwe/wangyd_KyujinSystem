package com.example.dao;

import com.example.entity.Kaisha;
import com.example.entity.Kyujin;
import org.apache.ibatis.annotations.Param;

import java.util.List;
//20220806 wangyide:kyujinListDaoクラスの作成
public interface kyujinListDao {
    //查询求职详细信息
    List<Kyujin> kyujinList(@Param("mail")String mail, @Param("Rtype")Integer Rtype);
    //根据id查询详细信息
    Kyujin idByKyujin(Integer id);
    //insert
    void addKaisha(Kaisha kaisha);
    void addKyujin(Kyujin kyujin);

    void updateKyujin(Kyujin kyujin);

    void updateKyujindel(Kyujin kyujin);
}
