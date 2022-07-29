package com.example.service;

import com.example.dao.kyushokuListDao;
import com.example.entity.Kojin;
import com.example.entity.Kyushoku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
