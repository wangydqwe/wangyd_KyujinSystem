package com.example.entity;

import lombok.Data;

import java.util.Date;
//20220703 wangyide:beanの追加

@Data
public class Role {
    private Integer Rid;
    private String Rname;
    private Integer Rtype;
    private String KouShinSha;
    private Date KouShinHiDuke;
    private String SakuSeiSha;
    private Date SakuSeiHiDuke;
    private Integer DelFlag;
    private Integer Status;
}
