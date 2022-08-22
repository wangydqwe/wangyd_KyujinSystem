package com.example.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
//20220806 wangyide:Kyujinクラスの作成
@Data
public class Kyujin {
    private Integer KJId;
    private Integer KaishaId;
    @NotBlank(message = "{MSG_A0011}")
    private String YakuShokuName;
    @NotBlank(message = "{MSG_A0010}")
    private String KaishaName;
    private String KiboShokuGyo;
    @NotNull(message = "{MSG_A0012}")
    private Integer Kyoyu;
    @NotBlank(message = "{MSG_A0013}")
    private String Jusho1;
    private String Jusho2;
    private String Jusho3;
    @NotNull(message = "{MSG_A0014}")
    private Integer Tele;
    @NotBlank(message = "{MSG_A0015}")
    private String Mail;
    private String Biko = "";
    private String KouShinSha;
    private Date KouShinHiDuke;
    private String SakuSeiSha;
    private Date SakuSeiHiDuke;
    private Integer DelFlag;
    private Integer Status;
}
