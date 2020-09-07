package com.bestgroup.core;

public class Pagination {

	protected int pageNumber = 1;
	protected int pageSize = 20;

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "Pagination [pageNumber=" + pageNumber + ", pageSize=" + pageSize + "]";
	}

}
