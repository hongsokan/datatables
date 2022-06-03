package com.eb.datatables.server.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.eb.datatables.vo.CompleteInfo;

@Mapper
public interface ServerMapper {
	int count();
	List<CompleteInfo> list(@Param("from") int from, @Param("to") int to);
}
