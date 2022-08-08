package com.example.service;

import com.example.entity.Kojin;
import com.example.entity.Kyushoku;

import java.util.List;
//20220806 wangyide:kyushokuListServiceクラスの作成
public interface kyushokuListService {

    //List
    List<Kyushoku> kyushokuList();

    //insert
    void addKyuShokuList(Kojin kojin, Kyushoku kyushoku);

    //根据id查询详细信息
    Kyushoku idByKyushoku(Integer id);

    //update
    void updateKyuShoku(Kyushoku kyushoku);

    Kojin idByKojin(Integer kojinId);

    //delete
    void deleteKyuShoku(Kyushoku kyushoku);
}
