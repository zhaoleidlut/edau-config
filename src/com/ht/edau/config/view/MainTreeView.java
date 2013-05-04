package com.ht.edau.config.view;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import com.ht.edau.config.model.ChannelModel;
import com.ht.edau.config.service.ChannelModelService;
import com.ht.edau.config.service.impl.ChannelModelServiceImpl;
import com.ht.edau.config.util.FirePropertyConstants;
import com.ht.edau.config.util.ViewPropertyChange;
import com.ht.edau.config.view.tree.MainTreeContentProvider;
import com.ht.edau.config.view.tree.MainTreeLabelProvider;
import com.ht.edau.config.view.tree.RootTreeModel;

public class MainTreeView extends ViewPart {
	
	
	public MainTreeView() {
	}

	public static final String ID = "com.ht.edau.config.view.MainTreeView";
	public static TreeViewer treeViewer;
	private ChannelModelService channelModelService = new ChannelModelServiceImpl();

	private MenuManager menuMng;

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {

		treeViewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.BORDER);
		treeViewer.setAutoExpandLevel(3);
		treeViewer.setContentProvider(new MainTreeContentProvider());
		treeViewer.setLabelProvider(new MainTreeLabelProvider());
		treeViewer.setInput(RootTreeModel.instanse);
		

		Tree tree = treeViewer.getTree();

		menuMng = new MenuManager();
		menuMng.setRemoveAllWhenShown(true);
		menuMng.addMenuListener(new MenuListener(treeViewer));
		tree.setMenu(menuMng.createContextMenu(tree)); // 添加菜单

		// 点击打开编辑页面
		tree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if (e.button == 1) {
					IStructuredSelection sel = ((IStructuredSelection) treeViewer
							.getSelection());
					if (!sel.isEmpty()) {
						final Object obj = ((IStructuredSelection) treeViewer
								.getSelection()).getFirstElement();
						Display.getDefault().timerExec(
								Display.getDefault().getDoubleClickTime(),
								new Runnable() {
									public void run() {
										 edit(obj);
									}
								});
					}

				}
			}

		});
	}

	private class MenuListener implements IMenuListener {
		private TreeViewer treeViewer;

		public MenuListener(TreeViewer treeViewer) {
			this.treeViewer = treeViewer;
		}

		@Override
		public void menuAboutToShow(IMenuManager manager) {
			IStructuredSelection selection = (IStructuredSelection) treeViewer
					.getSelection();
			if (!selection.isEmpty()) {
				createContextMenu(selection.getFirstElement());
			}
		}

		/**
		 * 右键菜单内容
		 * 
		 * @param selectedObject
		 */
		private void createContextMenu(final Object selectedObject) {
			if (selectedObject instanceof String) {
				final String str = (String) selectedObject;
				if(str.equals("采集通道配置")) {
					Action action = new Action() {
						public void run() {
							try {
								PlatformUI.getWorkbench()
										.getActiveWorkbenchWindow()
										.getActivePage()
										.showView(ChannelModelConfigView.ID);
							} catch (PartInitException e) {
								e.printStackTrace();
							}
							ViewPropertyChange.getInstance().firePropertyChangeListener(FirePropertyConstants.ACQUISITIONCHANNEL_ADD, selectedObject);
							
						}
					};
					action.setText("添加采集通道(&A)");
					menuMng.add(action);
				}

			} else if(selectedObject instanceof ChannelModel) {
				final ChannelModel channelModel = (ChannelModel)selectedObject;
				
				Action action = new Action() {
					public void run() {
						if (MessageDialog.openConfirm(treeViewer.getTree()
								.getShell(), "删除", "确认要删除吗？")) {
							channelModelService.removeChannelModelById(channelModel);
							
							treeViewer.remove(channelModel);
						}
					}
				};
				action.setText("删除采集通道(&D)");
				menuMng.add(action);
				
				menuMng.add(new Separator());
				
				action = new Action() {
					public void run() {
					}
				};
				action.setText("添加设备(&A)");
				menuMng.add(action);
			}
		}

	}
	
	/**
	 * 点击对象 进行编辑
	 * @param object
	 */
	private void edit(Object object) {
		if(object instanceof ChannelModel) {
			try {
				PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow()
						.getActivePage()
						.showView(ChannelModelConfigView.ID);
			} catch (PartInitException e) {
				e.printStackTrace();
			}
			ViewPropertyChange.getInstance().firePropertyChangeListener(FirePropertyConstants.ACQUISITIONCHANNEL_EDIT, object);
		}
		
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		treeViewer.getControl().setFocus();
	}
}