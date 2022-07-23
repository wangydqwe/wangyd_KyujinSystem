package com.example.service;

import com.example.entity.Kojin;
import com.example.entity.Kyushoku;

import java.util.List;

public interface JohoListService {

    //List
    List<Kyushoku> kyushokuList();

    //insert
    void addKyuShokuList(Kojin kojin, Kyushoku kyushoku);

    //根据id查询详细信息
    Kyushoku idByKyushoku(Integer id);
}
