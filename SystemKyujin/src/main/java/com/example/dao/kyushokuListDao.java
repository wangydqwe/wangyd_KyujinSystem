package com.example.dao;

import com.example.entity.Kojin;
import com.example.entity.Kyushoku;

import java.util.List;

public interface kyushokuListDao {
    //查询求职详细信息
    List<Kyushoku> kyushokuList();

    //insert
    void addKojin(Kojin kojin);
    void addKyuShoku(Kyushoku kyushoku);
    //根据id查询详细信息
    Kyushoku idByKyushoku(Integer id);
    //update
    void updateKyuShoku(Kyushoku kyushoku);
    void updateKojin(Kojin kojin);

    Kojin idByKojin(Integer kojinId);
}
