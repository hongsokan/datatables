package com.eb.datatables.paging.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eb.datatables.paging.mapper.PagingMapper;
import com.eb.datatables.vo.CompleteInfo;
import com.eb.datatables.vo.DatatableDto;

@Service
public class PagingServiceImpl implements PagingService {
	private SqlSession sqlSession;

	public PagingServiceImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Transactional
	@Override
	public int count() {
		int count = sqlSession.getMapper(PagingMapper.class).count();
		return count;
	}

	@Transactional
	@Override
	public DatatableDto<CompleteInfo> find(PaginationInfo paginationInfo, Integer draw) {

		DatatableDto<CompleteInfo> dto = new DatatableDto<CompleteInfo>();

		int from = paginationInfo.getFirstRecordIndex();
		int to = paginationInfo.getLastRecordIndex();
		List<CompleteInfo> list = sqlSession.getMapper(PagingMapper.class).list(from, to);

		dto.setDraw(draw);
		dto.setData(list);

		return dto;
	}

	@Override
	public String render(PaginationInfo info, String url, String pageNo) {
		info.setCurrentPageNo(Integer.parseInt(pageNo));
		PaginationRenderer renderer = new PaginationRenderer();
		String render = renderer.renderPagination(info, url);
		return render;
	}
}
