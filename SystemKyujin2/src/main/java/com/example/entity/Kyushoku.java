package com.example.entity;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;
//20220806 wangyide:Kyushokuクラスの作成
@Data
public class Kyushoku {
    private Integer KSId;
    private Integer KojinId;
    @NotBlank(message = "{MSG_A0004}")
    private String KojinName;
    @NotBlank(message = "{MSG_A0004}")
    private String YakuShokuName;
    @NotBlank(message = "{MSG_A0004}")
    private String KiboShokuGyo;
    @NotBlank(message = "{MSG_A0004}")
    private Integer Kyoyu;
    @NotBlank(message = "{MSG_A0004}")
    private String Jusho1;
    private String Jusho2;
    private String Jusho3;
    @NotBlank(message = "{MSG_A0004}")
    private Integer Tele;
    @NotBlank(message = "{MSG_A0004}")
    @Email
    private String Mail;
    private String Biko;
    private String KouShinSha;
    private Date KouShinHiDuke;
    private String SakuSeiSha;
    private Date SakuSeiHiDuke;
    private Integer DelFlag;
    private Integer Status;
}
