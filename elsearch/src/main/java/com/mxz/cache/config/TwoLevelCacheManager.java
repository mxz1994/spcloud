package com.mxz.cache.config;

import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;

/**
* <p>Title: TwoLevelCacheManage.java</p>  
* <p>Description: </p>  
* @author mxz
* @date 2018年11月23日  
*/
public class TwoLevelCacheManager extends RedisCacheManager{

	public TwoLevelCacheManager(RedisCacheWriter cacheWriter, RedisCacheConfiguration defaultCacheConfiguration) {
		super(cacheWriter, defaultCacheConfiguration);
	}

}
