package com.khrd.domain;

import java.util.List;

public class PageMaker {

	private int totalCount;  // 게시글 전체 갯수
	private int startPage;  // 페이지 시작 번호
	private int endPage;  // 페이지 마지막 번호
	private boolean prev;
	private boolean next; 
	
	private int displayPageNum = 10; // 페이지 갯수
	
	private Criteria cri;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		calcDate(); // pageMaker 값 구함
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	public PageMaker() {
		super();
		this.totalCount = totalCount;
		this.startPage = startPage;
		this.endPage = endPage;
		this.prev = prev;
		this.next = next;
		this.displayPageNum = displayPageNum;
		this.cri = cri;
	}


	@Override
	public String toString() {
		return "PageMaker [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage + ", prev="
				+ prev + ", next=" + next + ", displayPageNum=" + displayPageNum + ", cri=" + cri + "]";
	}
	
	public void calcDate() {
		
		// 현재 페이지 끝 번호 구함. start 번호를 구하기 위해 필요
		endPage = (int)(Math.ceil(cri.getPage()/(double)displayPageNum) * displayPageNum );
		
		// 현재 페이지 시작번호 구함
		startPage = (endPage - displayPageNum) +1;
		
		// cir.getPerPageNum(); 한 페이지에 보여질 게시글 갯수	
		// 전체 게시글이 153 이고 현재 선택 페이지가 15일때, 마지막 번혼느 (endPage)는 16으로 나타나야 함
		// Math.ceil(153/10) = 16
		int tempEndPage = (int)(Math.ceil(totalCount) / (double)cri.getPerPageNum());
		// 만약, 이전에 구한 끝 페이지 번호가 실제 끝 페이지 번호보다 크다면 변경해준다.
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		
		// 이전 페이지 여부(<<)
		if(startPage ==1) {
			prev = false;
		}else {
			prev = true;
		}
		// 이후 페이지 여부(>>)
		if(endPage * cri.getPerPageNum() >= totalCount) {
			next = false;
		}else {
			next = true;
		}
		
		
	}

	
	
	
}
