package com.example.service;

import com.example.dao.kyushokuListDao;
import com.example.entity.Kojin;
import com.example.entity.Kyujin;
import com.example.entity.Kyushoku;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
//20220806 wangyide:kyushokuListServiceImplクラスの作成
@Service
@Transactional
public class kyushokuListServiceImpl implements kyushokuListService {
    private final kyushokuListDao kyushokuListDao;

    @Autowired
    public kyushokuListServiceImpl(kyushokuListDao kyushokuListDao){
        this.kyushokuListDao = kyushokuListDao;
    }

    @Override
    public List<Kyushoku> kyushokuList() {
        //使用pagehelper实现分页
        List<Kyushoku> list = this.kyushokuListDao.kyushokuList();
        return list;

    }
    @Override
    public void addKyuShokuList(Kojin kojin, Kyushoku kyushoku){

        kojin.setShimeKanji(kyushoku.getKojinName());

        kyushokuListDao.addKojin(kojin);

        kyushoku.setKojinId(kojin.getKojinId());

        kyushokuListDao.addKyuShoku(kyushoku);

    }

    @Override
    public Kyushoku idByKyushoku(Integer id) {
        return kyushokuListDao.idByKyushoku(id);
    }

    @Override
    public void updateKyuShoku(Kyushoku kyushoku) {
        kyushokuListDao.updateKyuShoku(kyushoku);
    }

    @Override
    public Kojin idByKojin(Integer kojinId) {
        return kyushokuListDao.idByKojin(kojinId);
    }

    @Override
    public void deleteKyuShoku(Kyushoku kyushoku) {

        kyushokuListDao.updateKyuShoku(kyushoku);
    }


}
