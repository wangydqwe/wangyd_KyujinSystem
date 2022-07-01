package com.example.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserRole {
    private Integer URid;
    private Integer Uid;
    private Integer Rid;
    private String Uname;
    private String Rname;
    private String KouShinSha;
    private Date KouShinHiDuke;
    private String SakuSeiSha;
    private Date SakuSeiHiDuke;
    private Integer DelFlag;
    private Integer Status;
}
