package com.example.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;
//20220806 wangyide:Kaishaクラスの作成
@Data
public class Kaisha {
    private Integer KaishaId;
    @NotBlank(message = "{MSG_A0004}")
    private String KaishaName;
    private Integer RirekiSu;
    private String KouShinSha;
    private Date KouShinHiDuke;
    private String SakuSeiSha;
    private Date SakuSeiHiDuke;
    private Integer DelFlag;
    private Integer Status;
}
