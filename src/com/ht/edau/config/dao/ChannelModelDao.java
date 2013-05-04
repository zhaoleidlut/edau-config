package com.ht.edau.config.dao;

import java.util.List;

import com.ht.edau.config.model.ChannelModel;

/**
 * 采集通道模型
 * @author 赵磊
 *
 */
public interface ChannelModelDao extends BaseDao<ChannelModel> {
	/**
	 * 获得所有采集通道
	 * @return
	 */
	List<ChannelModel> getAllChannelModel();
	
	/**
	 * 更新采集通道
	 * @param channelModel
	 */
	public void updateChannelModelById(ChannelModel channelModel, String oldId);
	
	/**
	 * 移除采集通道
	 * @param channelModel
	 */
	public void removeChannelModelById(ChannelModel channelModel);
	
	/**
	 * 通过名字查找通道
	 * @param name 名字
	 * @param butName 排除该名字
	 * @return
	 */
	public ChannelModel getChannelModelByName(String name);
	/**
	 * 通过序号获得通道
	 * @param id 序号
	 * @param butId 排除该序号
	 * @return
	 */
	public ChannelModel getChannelModelById(String id);
}
