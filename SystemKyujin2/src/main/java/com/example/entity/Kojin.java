package com.example.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;
//20220806 wangyide:Kojinクラスの作成
@Data
public class Kojin {
    private Integer KojinId;
    @NotBlank(message = "{MSG_A0001}")
    private String ShimeKanji;
    private Integer RirekiSu;
    private String KouShinSha;
    private Date KouShinHiDuke;
    private String SakuSeiSha;
    private Date SakuSeiHiDuke;
    private Integer DelFlag;
    private Integer Status;
}
