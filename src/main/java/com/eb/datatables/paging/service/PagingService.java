package com.eb.datatables.paging.service;

import java.util.List;

import com.eb.datatables.vo.CompleteInfo;

public interface PagingService {

	int count();

	List<CompleteInfo> find(PaginationInfo paginationInfo);

	String render(PaginationInfo info, String url, String pageNo);

}