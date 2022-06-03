package com.eb.datatables.server.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eb.datatables.server.mapper.ServerMapper;
import com.eb.datatables.vo.CompleteInfo;

@Service
public class ServerServiceImpl implements ServerService {

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

	@Transactional
	@Override
	public List<CompleteInfo> findAll(int start, int length) {
		int from = start + 1;
		int to = from + length - 1;
		List<CompleteInfo> list = sqlSession.getMapper(ServerMapper.class).list(from, to);
		return list;
	}
}
