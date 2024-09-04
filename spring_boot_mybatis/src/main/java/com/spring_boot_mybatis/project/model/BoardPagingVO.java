package com.spring_boot_mybatis.project.model;

public class BoardPagingVO {
	private int pageNo; // 현재 페이지
	private int pageSize; // 한 화면에 보이는 글 수 : 10
	private int totalCount; // 전체 글 수
	
	private int startNo; // 현재 페이지 글 목록의 시작 번호
	private int endNo; // 현재 페이지 글 목록의 마지막 번호
	
	private int startPage; // 페이지 이동 버튼의 시작 번호
	private int endPage; // 페이지 이동 버튼의 마지막 번호
	private int totalPage; // 페이지 이동 버튼의 시작 번호
	
	// 생성자에서 초기화
	public BoardPagingVO(int pageNo, int pageSize, int totalCount) {
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		
		// 계산
		// 페이지 수
		totalPage = (totalCount - 1) / pageSize + 1;
		
		// pageNo는 현재 페이지가 잘못된 값이 전달되었을 때 : 1보다 작은 값 또는 totalPage 보다 큰 값
		this.pageNo = (pageNo < 1) ? 1 : pageNo;
		this.pageNo = (pageNo > totalPage) ? totalPage : pageNo;
		
		startNo = (this.pageNo - 1) * pageSize + 1;
		
		endNo = startNo + (pageSize - 1); // totalCount 이하의 값이어야 함		
		this.endNo = this.endNo > totalCount ? totalCount : this.endNo;
		
		startPage = (this.pageNo - 1) / 10 * 10 + 1; // pageNo가 11~20 일 때 startPage는 모두 11
		
		endPage = startPage + 9; // totalPage 이하의 값 이어야 함		
		this.endPage = this.endPage > totalPage ? totalPage : this.endPage;
		
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getStartNo() {
		return startNo;
	}

	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}

	public int getEndNo() {
		return endNo;
	}

	public void setEndNo(int endNo) {
		this.endNo = endNo;
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

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
}
