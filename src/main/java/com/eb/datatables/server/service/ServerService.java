package com.eb.datatables.server.service;

import java.util.List;

import com.eb.datatables.vo.CompleteInfo;

public interface ServerService {

	int count();

	List<CompleteInfo> findAll(int start, int length);
}