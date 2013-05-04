package com.ht.edau.config.service.impl;

import com.ht.edau.config.dao.DeviceModelDao;
import com.ht.edau.config.dao.impl.DeviceModelDaoImpl;
import com.ht.edau.config.service.DeviceModelService;

public class DeviceModelServiceImpl implements DeviceModelService {
	private DeviceModelDao deviceModelDao = new DeviceModelDaoImpl();


}
