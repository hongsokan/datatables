package com.eb.datatables.paging.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.eb.datatables.vo.CompleteInfo;

@Mapper
public interface PagingMapper {

	int count();

	List<CompleteInfo> list(int from, int to);

}
