package org.hdcd.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Item2 {
	private int itemId;
	private String itemName;
	private int price;
	private String description;
	private List<MultipartFile> pictures;
	private String pictureUrl;
	private String pictureUrl2;
	
	
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public List<MultipartFile> getPictures() {
		return pictures;
	}
	public void setPictures(List<MultipartFile> pictures) {
		this.pictures = pictures;
	}
	public String getPictureUrl2() {
		return pictureUrl2;
	}
	public void setPictureUrl2(String pictureUrl2) {
		this.pictureUrl2 = pictureUrl2;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	
	
}
