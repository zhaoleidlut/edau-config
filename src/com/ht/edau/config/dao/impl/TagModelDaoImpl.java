package com.ht.edau.config.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ht.edau.config.dao.TagModelDao;
import com.ht.edau.config.model.TagModel;
import com.ht.edau.config.util.GetXpathUtil;
import com.ht.edau.config.util.XMLDocumentFactory;

public class TagModelDaoImpl implements TagModelDao {
	private final Logger log = LoggerFactory.getLogger(TagModelDaoImpl.class);

	@Override
	public void create(TagModel domain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TagModel read(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(TagModel domain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(TagModel domain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TagModel getTagByXpath(String xpath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addVariable(TagModel tagModel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TagModel> getTagsByMainIndex(String mainIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TagModel> getTagsBySecondIndex(String secondIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeTagModel(TagModel tagModel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTagModel(TagModel tagModel, String oldname) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TagModel> getSubTagModel(String parentTagXpath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addSubTagModel(String parentTagXpath, TagModel tagModel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSubTagModel(String parentTagXpath, TagModel tagModel,
			String oldName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeSubTagModel(String parentTagXpath, TagModel tagModel) {
		// TODO Auto-generated method stub
		
	}
	
	

}
