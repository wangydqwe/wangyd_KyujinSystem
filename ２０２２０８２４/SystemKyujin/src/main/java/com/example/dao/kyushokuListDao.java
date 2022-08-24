package com.example.dao;

import com.example.entity.Kojin;
import com.example.entity.Kyushoku;
import org.apache.ibatis.annotations.Param;

import java.util.List;
//20220806 wangyide:kyushokuListDaoクラスの作成
public interface kyushokuListDao {
    //detail
    List<Kyushoku> kyushokuList(@Param("mail")String mail, @Param("Rtype")Integer Rtype);

    //insert
    void addKojin(Kojin kojin);
    void addKyuShoku(Kyushoku kyushoku);
    Kyushoku idByKyushoku(Integer id);
    //update
    void updateKyuShoku(Kyushoku kyushoku);
    void updateKojin(Kojin kojin);

    Kojin idByKojin(Integer kojinId);
}
