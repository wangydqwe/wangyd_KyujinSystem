package com.example.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Kyushoku {
    private Integer KSId;
    private Integer KojinId;
    private String YakuShokuName;
    private String KojinName;
    private String KiboShokuGyo;
    private Integer Kyoyu;
    private String Jusho1;
    private String Jusho2;
    private String Jusho3;
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
