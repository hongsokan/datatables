package com.eb.datatables.service;

import java.text.MessageFormat;

import com.eb.datatables.vo.PaginationInfo;

public class PaginationRenderer {
	protected String previousPageLabel;
	protected String currentPageLabel;
	protected String otherPageLabel;
	protected String nextPageLabel;

	public PaginationRenderer() {
		this.previousPageLabel = "<a href=\"{0}{1}\" class=\"page-prev\"><img src=\"/assets/images/icon/ico_table_arrow_left.png\"></a>";
		// this.currentPageLabel = "<strong class=\"page-selected\"><span>{0}</span></strong>";
		this.currentPageLabel = "<a href=\"javascript:void(0);\" class=\"page-selected\"><span>{0}</span></a>";
		this.otherPageLabel = "<a href=\"{0}{1}\" class=\"page-num\"><span>{2}</span></a>";
		this.nextPageLabel = "<a href=\"{0}{1}\" class=\"page-next\"><img src=\"/assets/images/icon/ico_table_arrow_right.png\"></a>";
	}

	public String renderPagination(PaginationInfo paginationInfo, String url) {
		StringBuffer strBuff = new StringBuffer();
		int firstPageNoOnPageList = paginationInfo.getFirstPageNoOnPageList();
		int totalPageCount = paginationInfo.getTotalPageCount();
		int pageSize = paginationInfo.getPageSize();
		int lastPageNoOnPageList = paginationInfo.getLastPageNoOnPageList();
		int currentPageNo = paginationInfo.getCurrentPageNo();
		if (totalPageCount > pageSize) {
			if (firstPageNoOnPageList > pageSize) {
				strBuff.append(MessageFormat.format(this.previousPageLabel, url, Integer.toString(firstPageNoOnPageList - 1)));
			}
		}

		for (int i = firstPageNoOnPageList; i <= lastPageNoOnPageList; ++i) {
			if (i == currentPageNo) {
				strBuff.append(MessageFormat.format(this.currentPageLabel, Integer.toString(i)));
			} else {
				strBuff.append(MessageFormat.format(this.otherPageLabel, url, Integer.toString(i), Integer.toString(i)));
			}
		}

		if (totalPageCount > pageSize) {
			if (lastPageNoOnPageList < totalPageCount) {
				strBuff.append(MessageFormat.format(this.nextPageLabel, url, Integer.toString(firstPageNoOnPageList + pageSize)));
			}
		}

		return strBuff.toString();
	}
}
