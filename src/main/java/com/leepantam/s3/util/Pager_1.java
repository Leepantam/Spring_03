package com.leepantam.s3.util;

public class Pager_1 {
	
	private String kind; // 검색할 컬럼 명
	private String search;//검색어
	
	

	private long perPage; // DB에 조회할 갯수
	private long perBlock; // JSP에 출력할 번호의 갯수
	
	public Pager_1() {
		this.perPage=10;
		this.perBlock=5;
	}
	
	private long curPage; // 현재 페이지 번호
	
	private long startRow;
	private long lastRow;
	
	//rownum 계산하는 메서드
	public void makeRow() {
		this.lastRow = this.curPage*this.perPage;
		this.startRow = this.curPage*this.perPage-(this.perPage-1);
	}
	
	
	//===========================페이징 계산===========================
	
	private long totalPage;
	private long startNum;
	private long lastNum;
	private boolean pre;
	private boolean next;
	
	// 페이징 계산하는 메서드
	public void makeNum(long totalCount) {
		// 1. 전체 글의 갯수로 전체 페이지 갯수 구하기
		this.totalPage=totalCount/this.perPage;
		if(totalCount%this.perPage!=0) {
			totalPage++;
		}
		
		// 2. 전체 페이지로 전체 block수 구하기
		long totalBlock = totalPage/this.perBlock;
		if(totalPage%this.perBlock!=0) {
			totalBlock++;
		}
		
		//3. curPageㄹ르 이용해서 curBlock 구하기
		// curPage/curBlock
		// 1      /1
		// 2      /1
		// 5      /1
		// 6      /2
		long curBlock=this.curPage/this.perBlock;
		if(this.curPage%this.perBlock!=0) {
			curBlock++;
		}
		
		//4. curBlock으로 startNum, lastNum 구하기
		// curBlock/startNum/lastNum
		// 1       /1       /5
		// 2       /6       /10
		// 3       /11      /15
		this.lastNum=curBlock*this.perBlock;
		this.startNum=(curBlock*this.perBlock)-(this.perBlock-1);
		
		// 5. curBlock이 totalBlock과 같을 경우
		if(curBlock==totalBlock) {
			this.lastNum=totalPage;
		}
		
		// 6. 이전, 다음 유무
		if(curBlock != 1) {
			this.pre = true;
		}
		if(curBlock != totalBlock) {
			this.next = true;
		}
		
	}

	public long getPerPage() {
		return perPage;
	}

	public void setPerPage(long perPage) {
		this.perPage = perPage;
	}

	public long getPerBlock() {
		return perBlock;
	}

	public void setPerBlock(long perBlock) {
		this.perBlock = perBlock;
	}

	public long getCurPage() {
		return curPage;
	}

	public void setCurPage(long curPage) {
		this.curPage = curPage;
	}

	public long getStartRow() {
		return startRow;
	}

	public void setStartRow(long startRow) {
		this.startRow = startRow;
	}

	public long getLastRow() {
		return lastRow;
	}

	public void setLastRow(long lastRow) {
		this.lastRow = lastRow;
	}

	public long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}

	public long getStartNum() {
		return startNum;
	}

	public void setStartNum(long startNum) {
		this.startNum = startNum;
	}

	public long getLastNum() {
		return lastNum;
	}

	public void setLastNum(long lastNum) {
		this.lastNum = lastNum;
	}

	public boolean isPre() {
		return pre;
	}

	public void setPre(boolean pre) {
		this.pre = pre;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}
	
	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

}