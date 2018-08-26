package com.fym.hos.dto;

public class PageQueryDto<T> {
	private int currentPage;
	private int totalPage;
	private int pageSize;
	private T search  ;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public T getSearch() {
		return search;
	}

	public void setSearch(T search) {
		this.search = search;
	}

}
