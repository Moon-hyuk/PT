package com.ds.moon.dsproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ds.moon.dsproject.dto.HbDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "hb_tb")
@ToString
public class Hb {

    @Id
    @Column(name = "hb_cd")
    private String hbCd;
    
    @Column(name = "hb_nm")
    private String hbNm;

    public static Hb createDept(HbDto hbDto) {
        Hb hb   = new Hb();
        hb.setHbCd(hbDto.getHbCd());
        hb.setHbNm(hbDto.getHbNm());

        return hb;
    }
}
