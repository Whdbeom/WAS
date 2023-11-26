package com.kh.app.board.page.vo;

public class PageVo {

	private int listCount; // 총 게시글 갯수
	private int currentPage; // 현재 페이지
	private int pageLimit; // 페이징바의 페이지 갯수 ( 몇개씩 배치할건지 ) 
	
	private int boardLimit; // 한 페이지에 보여줄 게시글 갯수
	
	private int maxPage; // 가장 마지막 페이지 (총 페이지 갯수)
	private int startPage; // 페이징 영역 시작 값 (현재 페이지 페이징바의 시작 수)
	private int endPage; // 페이징 영역 마지막 값 (현재 페이지 페이징바의 마지막 수)
	
	private int startRow; // 현재 페이지에 보여줄 첫번째 글 번호 (ROWNUM)
	private int lastRow; // 현재 페이지에 보여줄 마지막 글 번호 (ROWNUM)
	
	public PageVo(int listCount, int currentPage, int pageLimit, int boardLimit) {

		this.listCount = listCount;
		this.currentPage = currentPage;
		this.pageLimit = pageLimit;
		this.boardLimit = boardLimit;
		
		this.maxPage = (int) Math.ceil((double)listCount/boardLimit);
//		this.startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		this.startPage = currentPage+1;
		this.endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		this.startRow = (currentPage - 1) * boardLimit + 1;
		this.lastRow = startRow + boardLimit - 1;
	}

	public int getListCount() {
		return listCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getPageLimit() {
		return pageLimit;
	}

	public int getBoardLimit() {
		return boardLimit;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public int getStartRow() {
		return startRow;
	}

	public int getLastRow() {
		return lastRow;
	}
	
 	
	
	
	
}
