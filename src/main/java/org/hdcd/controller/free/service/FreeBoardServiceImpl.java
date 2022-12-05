package org.hdcd.controller.free.service;

import java.util.List;

import javax.inject.Inject;

import org.hdcd.mapper.FreeBoardMapper;
import org.hdcd.vo.Board;
import org.springframework.stereotype.Service;


@Service
public class FreeBoardServiceImpl implements freeBoardService {

	@Inject
	private FreeBoardMapper mapper;
	
	@Override
	public void createfree(Board board) throws Exception {
		mapper.createfree(board);
		
	}

	@Override
	public List<Board> list() throws Exception {
		// TODO Auto-generated method stub
		return mapper.list();
	}

	@Override
	public Board read(int boardNo) throws Exception {
		
		return  mapper.read(boardNo);
	}

	@Override
	public void delete(int boardNo) throws Exception {
		mapper.delete(boardNo);
	}

	@Override
	public void modify(Board board) throws Exception {
		mapper.modify(board);
		
	}

}
