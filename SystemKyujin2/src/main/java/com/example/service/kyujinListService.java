package com.example.service;

import com.example.entity.Kaisha;
import com.example.entity.Kyujin;

import java.util.List;
//20220806 wangyide:kyujinListServiceクラスの作成
public interface kyujinListService {
    //List
    List<Kyujin> kyujinList();

    //根据id查询详细信息
    Kyujin idByKyushoku(Integer id);

    //insert
    void addKyujinList(Kaisha kaisha, Kyujin kyujin);

    //update
    void updateKyuJin(Kyujin kyujin);

    //delete
    void deleteKyuJin(Kyujin kyujin);

}
