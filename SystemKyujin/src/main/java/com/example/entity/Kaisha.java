package com.example.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Kaisha {
    private Integer KaishaId;
    private String KaishaName;
    private Integer RirekiSu;
    private String KouShinSha;
    private Date KouShinHiDuke;
    private String SakuSeiSha;
    private Date SakuSeiHiDuke;
    private Integer DelFlag;
    private Integer Status;
}
