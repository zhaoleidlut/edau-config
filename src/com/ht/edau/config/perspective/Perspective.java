package com.ht.edau.config.perspective;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import com.ht.edau.config.view.ChannelModelConfigView;
import com.ht.edau.config.view.MainTreeView;

public class Perspective implements IPerspectiveFactory {
	public static final String ID = "com.ht.edau.config.perspective.Perspective";

	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(true);
		
		
		layout.addStandaloneView(MainTreeView.ID, true, IPageLayout.LEFT, 0.25f, editorArea);
		
		
		IFolderLayout folder = layout.createFolder("config", IPageLayout.LEFT, 1f, editorArea);
		folder.addPlaceholder(ChannelModelConfigView.ID);
		
//		folder.addView(ChannelModelConfigView.ID);
	}
}
