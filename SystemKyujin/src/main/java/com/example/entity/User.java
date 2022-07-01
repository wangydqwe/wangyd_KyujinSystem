package com.example.entity;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
@Data
public class User {
    private Integer UserId;
    @NotBlank(message = "MSG_A0004")
    @Size(min = 5,max = 20,message = "{MSG_A00010}")
    private String UName;
    @NotBlank(message = "MSG_A0004")
    @Size(min = 8,max = 20,message = "{MSG_A00011}")
    private String UPassword;
    @NotBlank(message = "MSG_A0004")
    @Email
    private String Mail;
    private String KouShinSha;
    private Date KouShinHiDuke;
    private String SakuSeiSha;
    private Date SakuSeiHiDuke;
    private Integer DelFlag;
    private Integer Status;
}
