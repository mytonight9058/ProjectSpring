package com.khrd.domain;

public class Criteria {

	private int page;
	private int perPageNum;
	

	public Criteria(int page, int perPageNum) {
		super();
		this.page = page;
		this.perPageNum = perPageNum;
	}



	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
	}



	public int getPage() {
		return page;
	}



	public void setPage(int page) {
		this.page = page;
	}



	public int getPerPageNum() {
		return perPageNum;
	}



	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}

	public int getPageStart() {
		return (this.page -1) * this.perPageNum;
	}

	public Criteria() {

		page = 1;
		perPageNum = 10;
	}
	
	
	
	
	
}
