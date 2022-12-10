package org.hdcd.controller.file.item02.service;

import java.util.List;

import org.hdcd.vo.Item2;

public interface ItemService2 {

	public void register(Item2 item) throws Exception;

	public List<Item2> list() throws Exception;

	public Item2 read(int itemId) throws Exception;

	public void modify(Item2 item) throws Exception;

	public String getPicture(int itemId) throws Exception;
	public String getPicture2(int itemId) throws Exception;

	public void remove(int itemId) throws Exception;

}
