package com.ds.moon.dsproject.dto;

import javax.validation.constraints.*;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    
    @NotBlank(message = "ID를 입력해주세요")
    private String userId;
    
    @NotBlank(message = "이름을 입력해주세요")
    private String userNm;

    @NotBlank(message = "이메일을 입력해주세요")
    @Email(message = "이메일 형식으로 입력해주세요")
    private String userEmlAddr;

    private String userTelno;
    private String userAddr;
    private String userAprvYn = "N";

    private String deptCd;
    
    



}