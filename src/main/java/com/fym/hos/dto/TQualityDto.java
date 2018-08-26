package com.fym.hos.dto;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.util.List;

/**
 * 质控人员 数据展示类
 * 
 * @author fp
 * @date 2018-08-25
 */
public class TQualityDto {
	private static final long serialVersionUID = 1L;
	private String id;

	private String f1;

	private String f2;

	private String f3;

	private String f4;

	private String f5;

	/**
	 * 年龄
	 */
	private int theAge;

	private String theDesc;

	private String theName;

	private int theSex;

	public TQualityDto() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getF1() {
		return this.f1;
	}

	public void setF1(String f1) {
		this.f1 = f1;
	}

	public String getF2() {
		return this.f2;
	}

	public void setF2(String f2) {
		this.f2 = f2;
	}

	public String getF3() {
		return this.f3;
	}

	public void setF3(String f3) {
		this.f3 = f3;
	}

	public String getF4() {
		return this.f4;
	}

	public void setF4(String f4) {
		this.f4 = f4;
	}

	public String getF5() {
		return this.f5;
	}

	public void setF5(String f5) {
		this.f5 = f5;
	}

	public int getTheAge() {
		return this.theAge;
	}

	public void setTheAge(int theAge) {
		this.theAge = theAge;
	}

	public String getTheDesc() {
		return this.theDesc;
	}

	public void setTheDesc(String theDesc) {
		this.theDesc = theDesc;
	}

	public String getTheName() {
		return this.theName;
	}

	public void setTheName(String theName) {
		this.theName = theName;
	}

	public int getTheSex() {
		return this.theSex;
	}

	public void setTheSex(int theSex) {
		this.theSex = theSex;
	}

}