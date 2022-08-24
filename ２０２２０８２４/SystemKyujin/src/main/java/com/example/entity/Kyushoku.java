package com.example.entity;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
//20220806 wangyide:Kyushokuクラスの作成
@Data
public class Kyushoku {
    private Integer KSId;
    private Integer KojinId;
    @NotBlank(message = "{MSG_A0016}")
    private String KojinName;
    @NotBlank(message = "{MSG_A0017}")
    private String YakuShokuName;
    private String KiboShokuGyo;
    @NotNull(message = "{MSG_A0018}")
    private Integer Kyoyu;
    @NotBlank(message = "{MSG_A0019}")
    private String Jusho1;
    @NotBlank(message = "{MSG_A0014}")
    private String Tele;
    @NotBlank(message = "{MSG_A0015}")
    @Email
    private String Mail;
    private String Biko = "";
    private String KouShinSha;
    private Date KouShinHiDuke;
    private String SakuSeiSha;
    private Date SakuSeiHiDuke;
    private Integer DelFlag;
}
