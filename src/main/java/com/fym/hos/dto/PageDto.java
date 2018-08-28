package com.fym.hos.dto;

import static org.mockito.Matchers.intThat;

import java.util.List;

public class PageDto<T> {
	private int currentPage;
	private int totalPage;
	private int pageSize;
	private List<T> data;

	
	
	public PageDto(int currentPage, int totalPage, int pageSize, List<T> data) {
		super();
		this.currentPage = currentPage;
		this.totalPage = totalPage;
		this.pageSize = pageSize;
		this.data = data;
		
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

}
