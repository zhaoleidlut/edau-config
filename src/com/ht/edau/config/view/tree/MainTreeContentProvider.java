package com.ht.edau.config.view.tree;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import com.ht.edau.config.dao.impl.ChannelModelDaoImpl;
import com.ht.edau.config.service.ChannelModelService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import com.ht.edau.config.service.impl.ChannelModelServiceImpl;


public class MainTreeContentProvider implements ITreeContentProvider {
//	private final Logger log = LoggerFactory.getLogger(MainTreeContentProvider.class);
	
	private ChannelModelService channelModelService = new ChannelModelServiceImpl();
	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void inputChanged(Viewer arg0, Object arg1, Object arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object[] getChildren(Object parentElement) {
		
		if (parentElement instanceof String) {
			String str = (String)parentElement;
			if(str.equals(RootTreeModel.instanse.channelConfig)) {
				return new String[]{"采集通道配置"};
			} else if(str.equals("采集通道配置")) {
				return channelModelService.getAllChannelModel().toArray();
			}
		}
		return null;
	}

	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof Enum) {
			return ((RootTreeModel) inputElement).getRoottree();
		}
		return null;
	}

	@Override
	public Object getParent(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildren(Object arg0) {
		Object[] children = this.getChildren(arg0);
		if (children == null) {
			return false;
		} else if (children.length > 0) {
			return true;
		} else {
			return false;
		}
	}

}
