package com.ht.edau.config.service.impl;

import com.ht.edau.config.dao.TagModelDao;
import com.ht.edau.config.dao.impl.TagModelDaoImpl;
import com.ht.edau.config.service.TagModelService;

public class TagModelServiceImpl implements TagModelService {
	private TagModelDao tagModelDao = new TagModelDaoImpl();
	
	
}
