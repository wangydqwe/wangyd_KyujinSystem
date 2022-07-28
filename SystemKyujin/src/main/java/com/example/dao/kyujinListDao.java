package com.example.dao;

import com.example.entity.Kyujin;

import java.util.List;

public interface kyujinListDao {
    List<Kyujin> kyujinList();
    //根据id查询详细信息
    Kyujin idByKyujin(Integer id);
}
