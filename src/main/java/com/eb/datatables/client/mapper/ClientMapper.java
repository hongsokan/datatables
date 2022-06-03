package com.eb.datatables.client.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.eb.datatables.vo.CompleteInfo;

@Mapper
public interface ClientMapper {
	int count();
	List<CompleteInfo> list();
}
