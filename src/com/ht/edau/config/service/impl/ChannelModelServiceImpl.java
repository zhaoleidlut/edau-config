package com.ht.edau.config.service.impl;

import java.util.List;

import com.ht.edau.config.dao.ChannelModelDao;
import com.ht.edau.config.dao.impl.ChannelModelDaoImpl;
import com.ht.edau.config.model.ChannelModel;
import com.ht.edau.config.service.ChannelModelService;

public class ChannelModelServiceImpl implements ChannelModelService {
	
	private ChannelModelDao channelModelDao = new ChannelModelDaoImpl();

	@Override
	public List<ChannelModel> getAllChannelModel() {
		return channelModelDao.getAllChannelModel();
	}

	@Override
	public void addChannelModel(ChannelModel channelModel) {
		channelModelDao.create(channelModel);
	}

	@Override
	public void updateChannelModelById(ChannelModel channelModel, String oldId) {
		channelModelDao.updateChannelModelById(channelModel, oldId);
	}

	@Override
	public ChannelModel getChannelModelByName(String name) {
		return channelModelDao.getChannelModelByName(name);
	}

	@Override
	public ChannelModel getChannelModelById(String id) {
		return channelModelDao.getChannelModelById(id);
	}

	@Override
	public void removeChannelModelById(ChannelModel channelModel) {
		channelModelDao.removeChannelModelById(channelModel);
	}

}
