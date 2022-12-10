package org.hdcd.controller.file.item03.service;

import java.util.List;

import org.hdcd.vo.Item3;

public interface ItemService3 {

	void register(Item3 item) throws Exception;

	List<Item3> list() throws Exception;

	Item3 read(int itemId) throws Exception;

	List<String> getAttach(int itemId) throws Exception;

	void modify(Item3 item) throws Exception;

	void remove(int itemId) throws Exception; 

}
