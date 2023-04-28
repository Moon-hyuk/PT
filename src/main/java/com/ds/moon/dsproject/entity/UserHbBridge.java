package com.ds.moon.dsproject.entity;

import java.io.Serializable;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class UserHbBridge implements Serializable  {
    
    private String user;
    private String hb;

    
}
