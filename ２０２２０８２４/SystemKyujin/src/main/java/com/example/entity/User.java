package com.example.entity;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
//20220806 wangyide:Userクラスの作成
@Data
public class User {
    private Integer UserId;
    @NotBlank(message = "{MSG_A0001}")
    private String UName;
    @NotBlank(message = "{MSG_A0004}")
    @Size(min = 8,max = 20,message = "{MSG_A0004}")
    private String UPassword;
    @NotBlank(message = "{MSG_A0002}")
    @Email
    private String Mail;
    private String KouShinSha;
    private Date KouShinHiDuke;
    private String SakuSeiSha;
    private Date SakuSeiHiDuke;
    private Integer DelFlag;
}
