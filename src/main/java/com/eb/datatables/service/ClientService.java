package com.eb.datatables.service;

import java.util.List;

import com.eb.datatables.vo.CompleteInfo;

public interface ClientService {

	int count();

	List<CompleteInfo> findAll();

}