package org.hdcd.mapper;

import java.util.List;

import org.hdcd.vo.Item3;
import org.hdcd.vo.Item3Attach;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemMapper3 {

	void create(Item3 item) throws Exception;
	void addAttach(String fileName) throws Exception;
	List<Item3> list() throws Exception;
	Item3 read(int itemId) throws Exception;
	List<String> getAttach(int itemId) throws Exception;
	void update(Item3 item) throws Exception;
	void deleteAttach(int itemId) throws Exception;
	void replaceAttach(Item3Attach item3Attach) throws Exception;
	void remove(int itemId) throws Exception;

	
}
