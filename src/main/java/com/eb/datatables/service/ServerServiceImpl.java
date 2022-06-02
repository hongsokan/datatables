package com.eb.datatables.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eb.datatables.mapper.ServerMapper;
import com.eb.datatables.vo.CompleteInfo;
import com.eb.datatables.vo.DatatableDto;
import com.eb.datatables.vo.DatatableParam;
import com.eb.datatables.vo.PaginationInfo;

@Service
public class ServerServiceImpl implements ServerService {
	Logger logger = LoggerFactory.getLogger(ServerServiceImpl.class);

	private SqlSession sqlSession;

	public ServerServiceImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Transactional
	@Override
	public int count() {
		int count = sqlSession.getMapper(ServerMapper.class).count();
		return count;
	}

	/*
	@Transactional
	@Override
	public List<CompleteInfo> findAll(int start, int length) {
		int from = start + 1;
		int to = from + length - 1;
		List<CompleteInfo> list = sqlSession.getMapper(ServerMapper.class).list(from, to);
		return list;
	}
	*/

	@Transactional
	@Override
	public DatatableDto<CompleteInfo> findAll(DatatableParam param) {
		int from = param.getStart();
		int to = param.getLength();
		List<CompleteInfo> list = sqlSession.getMapper(ServerMapper.class).list(from, to);
		DatatableDto<CompleteInfo> dto = new DatatableDto<CompleteInfo>();
		dto.setData(list);
		return dto;
	}

	public PaginationInfo info(DatatableParam param) {
		int currentPage = 1;
		int total = this.count();
		int length = param.getLength();
		PaginationInfo paginationInfo = new PaginationInfo();
        paginationInfo.setCurrentPageNo(currentPage); //현재 페이지 번호
        paginationInfo.setRecordCountPerPage(length); //한 페이지에 게시되는 게시물 건수
        paginationInfo.setTotalRecordCount(total);
        paginationInfo.setPageSize(total / length); //페이징 리스트의 사이즈
        return paginationInfo;
	}
}
