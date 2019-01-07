package com.mxz.elsearch.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mxz.elsearch.model.PhoneVO;

/**
* <p>Title: PhoneDao.java</p>  
* <p>Description: </p>  
* @author mxz
* @date 2018年11月21日  
*/
public interface PhoneDao extends CrudRepository<PhoneVO, String>{
	
	public List<PhoneVO> getByName(String key);
}
