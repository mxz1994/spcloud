package com.mxz.elsearch.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
* <p>Title: PhoneVO.java</p>  
* <p>Description: </p>  
* @author mxz
* @date 2018年11月21日  
*/
@Document(indexName="mxz", type="phone")
public class PhoneVO {
	private Integer id;
	private String name;
	private String price;
	
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
}
