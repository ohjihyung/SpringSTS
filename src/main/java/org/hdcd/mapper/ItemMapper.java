package org.hdcd.mapper;

import java.util.List;

import org.hdcd.vo.Item;

public interface ItemMapper {

	public void create(Item item) throws Exception;

	public List<Item> list() throws Exception;

	public Item read(int itemId) throws Exception;

	public void update(Item item) throws Exception;

	public String getPicture(int itemId) throws Exception;

	public void remove(int itemId) throws Exception;

}
