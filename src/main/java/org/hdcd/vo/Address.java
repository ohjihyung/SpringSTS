package org.hdcd.vo;

import org.hibernate.validator.constraints.NotBlank;

public class Address {
	
	//문자열이 Null 이아니고 trim한 길이가 0보다 크다는 것 검사
	@NotBlank
	private String postCode;
	@NotBlank
	private String location;
	
	
	
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
