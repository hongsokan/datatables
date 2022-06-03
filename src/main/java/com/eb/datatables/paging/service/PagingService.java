package com.eb.datatables.paging.service;

import com.eb.datatables.vo.CompleteInfo;
import com.eb.datatables.vo.DatatableDto;

public interface PagingService {

	int count();

	DatatableDto<CompleteInfo> find(PaginationInfo paginationInfo, Integer draw);

	String render(PaginationInfo info, String url, String pageNo);

}