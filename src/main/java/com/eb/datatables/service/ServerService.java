package com.eb.datatables.service;

import com.eb.datatables.vo.CompleteInfo;
import com.eb.datatables.vo.DatatableDto;
import com.eb.datatables.vo.DatatableParam;

public interface ServerService {

	int count();

	//List<CompleteInfo> findAll(int start, int length);

	DatatableDto<CompleteInfo> findAll(DatatableParam param);

}