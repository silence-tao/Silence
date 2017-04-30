package com.silencetao.view;

/**
 * 分页工具类
 * @author Silence
 *
 */
public class Pages {
	private long totalPage;//总页数
	private long currentPage;//当前页
	private long totalCount;//总条数
	private long pageSize = 10;//每页条数
	
	public Pages() {
		
	}

	public Pages(long totalPage, long currentPage, long totalCount, long pageSize) {
		this.totalPage = totalPage;
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
	}

	public Pages(long currentPage, long pageSize) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}

	public long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}

	public long getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(long currentPage) {
		this.currentPage = currentPage;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public long getPageSize() {
		return pageSize;
	}

	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "Pages [totalPage=" + totalPage + ", currentPage=" + currentPage + ", totalCount=" + totalCount
				+ ", pageSize=" + pageSize + "]";
	}
}
