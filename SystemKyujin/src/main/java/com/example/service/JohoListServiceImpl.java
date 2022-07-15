package com.example.service;

import com.example.dao.JohoListDao;
import com.example.entity.Kyushoku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class JohoListServiceImpl implements JohoListService {
    private final JohoListDao johoListDao;

    @Autowired
    public JohoListServiceImpl(JohoListDao johoListDao){
        this.johoListDao = johoListDao;
    }

    @Override
    public List<Kyushoku> kyushokuList() {
        List<Kyushoku> list = this.johoListDao.kyushokuList();
        return list;

    }

}
