package com.fym.hos.dto;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.util.List;


/**
 * 医生页面数据展示类，这个类得数据回在页面渲染显示。不是用实体，实体里面有些属性比较特殊，比如集合，这类数据我们不需要在页面显示。（目的）
 * @author fym
 * @since 2018-08-26
 */
public class TDoctorDto  {
	private String id;

	private String department;

	private String f1;

	private String f2;

	private String f3;

	private String f4;

	private String f5;

	private int theAge;

	private String theDesc;

	private String theName;

	private int theSex;

	private String theSexText;
	
	public TDoctorDto() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
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

	public String getTheSexText() {
		if(theSex==0)
			return "女";
		else
			return "男";
	}

	public void setTheSexText(String theSexText) {
		this.theSexText = theSexText;
	}

 
}