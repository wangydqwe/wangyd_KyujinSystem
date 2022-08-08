package com.example.service;

import com.example.entity.Kaisha;
import com.example.entity.Kyujin;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
//20220806 wangyide:kyujinListServiceImplクラスの作成
public class kyujinListServiceImpl implements kyujinListService{
    private final com.example.dao.kyujinListDao kyujinListDao;

    @Autowired
    public kyujinListServiceImpl(com.example.dao.kyujinListDao kyujinListDao){
        this.kyujinListDao = kyujinListDao;
    }

    @Override
    public List<Kyujin> kyujinList() {
        //使用pagehelper实现分页
        List<Kyujin> list = this.kyujinListDao.kyujinList();
        return list;
    }

    @Override
    public Kyujin idByKyushoku(Integer id) {
        return kyujinListDao.idByKyujin(id);    }

    @Override
    public void addKyujinList(Kaisha kaisha, Kyujin kyujin) {
        kaisha.setKaishaName(kyujin.getKaishaName());

        kyujinListDao.addKaisha(kaisha);

        kyujin.setKaishaId(kaisha.getKaishaId());

        kyujinListDao.addKyujin(kyujin);
    }

    @Override
    public void updateKyuJin(Kyujin kyujin) {
        kyujinListDao.updateKyujin(kyujin);
    }

    @Override
    public void deleteKyuJin(Kyujin kyujin) {
        kyujinListDao.updateKyujindel(kyujin);
    }
}
