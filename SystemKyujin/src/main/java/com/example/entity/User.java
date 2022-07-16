package com.example.entity;

import lombok.Data;

import java.util.Date;
@Data
public class User {
    private Integer UId;
    private String UName;
    private String UPassword;
    private String Mail;
    private String KouShinSha;
    private Date KouShinHiDuke;
    private String SakuSeiSha;
    private Date SakuSeiHiDuke;

}
