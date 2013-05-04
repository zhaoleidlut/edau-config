package com.ht.edau.config.view.tree;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

import com.ht.edau.config.model.ChannelModel;

public class MainTreeLabelProvider implements ILabelProvider {
	
	
	@Override
	public void addListener(ILabelProviderListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isLabelProperty(Object arg0, String arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public Image getImage(Object object) {
		return null;
	}

	@Override
	public String getText(Object object) {
		if(object instanceof String) {
			return (String)object;
		} else if(object instanceof ChannelModel) {
			return ((ChannelModel)object).getName();
		}
		return null;
	}

}
