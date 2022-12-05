package org.hdcd.controller.free.service;

import java.util.List;

import org.hdcd.vo.Board;

public interface freeBoardService {

	void createfree(Board board) throws Exception;

	List<Board> list() throws Exception;

	Board read(int boardNo) throws Exception;

	void delete(int boardNo) throws Exception;

	void modify(Board board) throws Exception;

}
