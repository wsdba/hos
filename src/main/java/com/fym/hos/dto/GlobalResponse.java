package com.fym.hos.dto;

import java.util.List;

public class GlobalResponse<T> {
	private T object;
	private List<T> data;
	private String msg;
	private Integer code;
	private PageDto<T> page;

	public GlobalResponse(PageDto<T> page) {
		super();
		this.page = page;
	}

	public GlobalResponse(T object) {
		super();
		this.object = object;
	}

	public GlobalResponse(Integer code, String msg) {
		super();
		this.msg = msg;
		this.code = code;
	}

	public GlobalResponse(List<T> data) {
		super();
		this.data = data;
	}

	public GlobalResponse(T object, Integer code) {
		super();
		this.object = object;
		this.code = code;
	}

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public PageDto<T> getPage() {
		return page;
	}

	public void setPage(PageDto<T> page) {
		this.page = page;
	}

}
