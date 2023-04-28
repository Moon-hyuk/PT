package com.ds.moon.dsproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ds.moon.dsproject.dto.DeptDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Table(name = "dept_tb")
@ToString
public class Dept {

    @Id
    @Column(name = "dept_cd")
    private String deptCd;

    @Column(name = "dept_nm")
    private String deptNm;

    public static Dept createDept(DeptDto deptDto) {
        Dept dept = new Dept();
        dept.setDeptCd(deptDto.getDeptCd());
        dept.setDeptNm(deptDto.getDeptNm());

        return dept;
    }

}
