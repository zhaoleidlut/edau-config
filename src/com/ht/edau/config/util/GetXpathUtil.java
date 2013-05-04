package com.ht.edau.config.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ht.edau.config.model.ChannelModel;
import com.ht.edau.config.model.DeviceModel;


/**
 * 获取xpath路径
 * 
 * @author 赵磊
 * 
 */
public class GetXpathUtil {
	private static final Logger log = LoggerFactory.getLogger(GetXpathUtil.class);
	
	/**
	 * 通过slave_id获得Device xpath
	 * 
	 * @param deviceModel
	 * @return
	 */
	public static String getDeviceXPathBySlaveId(DeviceModel deviceModel) {
		ChannelModel channelModel = (ChannelModel) deviceModel
				.getParentObject();

		String path = "/" + XMLDocumentFactory.ROOT_NODE + "/"
				+ XMLDocumentFactory.CHANNEL_NODE + "/"
				+ ChannelModel.NODE_NAME + "[@" + ChannelModel.ID_ATTR + "="
				+ channelModel.getId() + "]/" + DeviceModel.NODE_NAME + "[@"
				+ DeviceModel.SLAVEID_ATTR + "=" + deviceModel.getSlaveId()
				+ "]";
		return path;
	}

	/**
	 * 通过序号获得Channel xpath
	 * 
	 * @param channelModel
	 * @return
	 */
	public static String getChannelXPathById(ChannelModel channelModel) {
		String path = "/" + XMLDocumentFactory.ROOT_NODE + "/"
				+ XMLDocumentFactory.CHANNEL_NODE + "/"
				+ ChannelModel.NODE_NAME + "[@" + ChannelModel.ID_ATTR + "="
				+ channelModel.getId() + "]";
		return path;
	}

}
