package com.fym.hos.dto;

import java.util.List;

import com.fym.hos.entity.TQuality;

public class Show<T> {
	public int code;
	
	public int count;
	
	public String msg ;
	
	public List<T> data ;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
	
	
	
}
