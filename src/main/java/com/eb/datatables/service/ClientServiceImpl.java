package com.eb.datatables.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eb.datatables.mapper.ClientMapper;
import com.eb.datatables.vo.CompleteInfo;

@Service
public class ClientServiceImpl implements ClientService {

	private SqlSession sqlSession;

	public ClientServiceImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Transactional
	@Override
	public int count() {
		int count = sqlSession.getMapper(ClientMapper.class).count();
		return count;
	}

	@Transactional
	@Override
	public List<CompleteInfo> findAll() {
		List<CompleteInfo> list = sqlSession.getMapper(ClientMapper.class).list();
		return list;
	}
}
