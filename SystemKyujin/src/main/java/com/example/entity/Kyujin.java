package com.example.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Kyujin {
    private Integer KJId;
    private Integer KaishaId;
    private String YakuShokuName;
    private String KaishaName;
    private Integer Kyoyu;
    private String Jusho1;
    private String Jusho2;
    private String Jusho3;
    private String KinmuChi;
    private Integer Tele;
    private String Mail;
    private String Biko;
    private String KouShinSha;
    private Date KouShinHiDuke;
    private String SakuSeiSha;
    private Date SakuSeiHiDuke;
    private Integer DelFlag;
    private Integer Status;
}
