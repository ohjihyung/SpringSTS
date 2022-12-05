package org.hdcd.mapper;

import java.util.List;

import org.hdcd.vo.Board;

public interface FreeBoardMapper {

	public void createfree(Board board) throws Exception;

	public List<Board> list() throws Exception;

	public Board read(int boardNo) throws Exception;

	public void delete(int boardNo) throws Exception;

	public void modify(Board board) throws Exception;

}
