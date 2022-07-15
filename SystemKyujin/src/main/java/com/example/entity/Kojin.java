package com.example.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Kojin {
    private Integer KojinId;
    private String ShimeKanji;
    private Integer RirekiSu;
    private String KouShinSha;
    private Date KouShinHiDuke;
    private String SakuSeiSha;
    private Date SakuSeiHiDuke;
    private Integer DelFlag;
    private Integer Status;
}
