package com.example.service;

import com.example.entity.Kyujin;

import java.util.List;

public interface kyujinListService {
    //List
    List<Kyujin> kyujinList();

    //根据id查询详细信息
    Kyujin idByKyushoku(Integer id);
}
