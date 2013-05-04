package com.ht.edau.config.view;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

import com.ht.edau.config.model.ChannelModel;
import com.ht.edau.config.service.ChannelModelService;
import com.ht.edau.config.service.impl.ChannelModelServiceImpl;
import com.ht.edau.config.util.FirePropertyConstants;
import com.ht.edau.config.util.LayoutUtil;
import com.ht.edau.config.util.ViewPropertyChange;

public class ChannelModelConfigView extends ViewPart implements
		IPropertyChangeListener {

	public ChannelModelConfigView() {
	}
	
	private ChannelModel channelModel;
	private boolean isAdded = false;	//判断是否是新增操作
	private ChannelModelService channelModelService = new ChannelModelServiceImpl();

	public static final String ID = "com.ht.edau.config.view.ChannelModelConfigView";
	public static TreeViewer treeViewer;
	private Text textChannelName;
	private Combo comboProtocal;
	private Text textIdx;
	private Text textOffline;
	private Text textInterval;
	private Text textSchedule;
	private Text textPortInfo;
	private Text textFrames;
	private DateTime dateTimeUpdateTime;

	public void createPartControl(Composite parent) {
		GridLayout gl_parent = new GridLayout(1, false);
		gl_parent.verticalSpacing = 20;
		gl_parent.marginTop = 25;
		gl_parent.marginLeft = 40;
		parent.setLayout(gl_parent);

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		GridData gd_composite = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_composite.heightHint = 435;
		gd_composite.widthHint = 282;
		composite.setLayoutData(gd_composite);

		Group groupBasicInfo = new Group(composite, SWT.NONE);
		groupBasicInfo.setText("采集时间");
		groupBasicInfo.setLayout(new GridLayout(2, false));

		Label labelName = new Label(groupBasicInfo, SWT.NONE);
		labelName.setText("通道名称：");

		textChannelName = new Text(groupBasicInfo, SWT.BORDER);
		GridData gd_textChannelName = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_textChannelName.widthHint = 120;
		textChannelName.setLayoutData(gd_textChannelName);

		Label labelProtocal = new Label(groupBasicInfo, SWT.NONE);
		labelProtocal.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		labelProtocal.setText("通信规约：");

		comboProtocal = new Combo(groupBasicInfo, SWT.READ_ONLY);
		comboProtocal.setItems(new String[] { "IEC104", "ModbusTCP",
				"ModbusRTU", "DL645" });
		GridData gd_comboProtocal = new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1);
		gd_comboProtocal.widthHint = 120;
		comboProtocal.setLayoutData(gd_comboProtocal);
		comboProtocal.select(0);

		Label labelIdx = new Label(groupBasicInfo, SWT.NONE);
		labelIdx.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		labelIdx.setText("序      号：");

		textIdx = new Text(groupBasicInfo, SWT.BORDER);
		GridData gd_textIdx = new GridData(SWT.LEFT, SWT.CENTER, true, false,
				1, 1);
		gd_textIdx.widthHint = 120;
		textIdx.setLayoutData(gd_textIdx);

		Group groupCommuInfo = new Group(composite, SWT.NONE);
		groupCommuInfo.setText("通讯信息");
		groupCommuInfo.setLayout(new GridLayout(2, false));

		Label labelOffline = new Label(groupCommuInfo, SWT.NONE);
		labelOffline.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		labelOffline.setText("通讯离线：");

		textOffline = new Text(groupCommuInfo, SWT.BORDER);
		textOffline.setText("<dynamic>");
		GridData gd_textOffline = new GridData(SWT.LEFT, SWT.CENTER, true,
				false, 1, 1);
		gd_textOffline.widthHint = 120;
		textOffline.setLayoutData(gd_textOffline);

		Label labelInterval = new Label(groupCommuInfo, SWT.NONE);
		labelInterval.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		labelInterval.setText("采样间隔：");

		textInterval = new Text(groupCommuInfo, SWT.BORDER);
		textInterval.setText("<dynamic>");
		GridData gd_textInterval = new GridData(SWT.LEFT, SWT.CENTER, true,
				false, 1, 1);
		gd_textInterval.widthHint = 120;
		textInterval.setLayoutData(gd_textInterval);

		Label labelSchedule = new Label(groupCommuInfo, SWT.NONE);
		labelSchedule.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		labelSchedule.setText("任务调度：");

		textSchedule = new Text(groupCommuInfo, SWT.BORDER);
		textSchedule.setText("<dynamic>");
		GridData gd_textSchedule = new GridData(SWT.LEFT, SWT.CENTER, true,
				false, 1, 1);
		gd_textSchedule.widthHint = 120;
		textSchedule.setLayoutData(gd_textSchedule);

		Label labelPortInfo = new Label(groupCommuInfo, SWT.NONE);
		labelPortInfo.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		labelPortInfo.setText("端口信息：");

		textPortInfo = new Text(groupCommuInfo, SWT.BORDER);
		textPortInfo.setText("<dynamic>");
		GridData gd_textPortInfo = new GridData(SWT.LEFT, SWT.CENTER, true,
				false, 1, 1);
		gd_textPortInfo.widthHint = 120;
		textPortInfo.setLayoutData(gd_textPortInfo);

		Label labelFrames = new Label(groupCommuInfo, SWT.NONE);
		labelFrames.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		labelFrames.setText("通 讯 帧：");

		textFrames = new Text(groupCommuInfo, SWT.BORDER);
		textFrames.setText("<dynamic>");
		GridData gd_textFrames = new GridData(SWT.LEFT, SWT.CENTER, true,
				false, 1, 1);
		gd_textFrames.widthHint = 120;
		textFrames.setLayoutData(gd_textFrames);

		Label labelUpdateTime = new Label(groupCommuInfo, SWT.NONE);
		labelUpdateTime.setText("上次更新：");

		dateTimeUpdateTime = new DateTime(groupCommuInfo, SWT.BORDER);
		GridData gd_dateTimeUpdateTime = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_dateTimeUpdateTime.widthHint = 120;
		dateTimeUpdateTime.setLayoutData(gd_dateTimeUpdateTime);

		Composite composite_1 = new Composite(composite, SWT.NONE);
		composite_1.setLayout(null);

		Button btnSave = new Button(composite_1, SWT.NONE);
		btnSave.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (isAdded) {// 添加采集通道
					if ("".equals(textChannelName.getText().trim())) {
						MessageDialog.openError(getSite().getShell(), "错误",
								"通道名称不能为空！");
						return;
					}
					
					channelModel.setName(textChannelName.getText().trim());	//采集通道名
					channelModel.setId(textIdx.getText().trim());	//id
					//　TODO 更新其他属性
					
					channelModelService.addChannelModel(channelModel);
					
					MainTreeView.treeViewer.add(channelModel.getParentObject(), channelModel);
					MainTreeView.treeViewer.setExpandedState(channelModel.getParentObject(), true);
					
				} else {//编辑
					if ("".equals(textChannelName.getText().trim())) {
						MessageDialog.openError(getSite().getShell(), "错误",
								"通道名称不能为空！");
						return;
					}
					String oldId = channelModel.getId();
					if(oldId==null) {
						MessageDialog.openError(getSite().getShell(), "错误",
								"ID为空，不能保存");
						return;
					}
					
					channelModel.setName(textChannelName.getText().trim());
					channelModel.setId(textIdx.getText().trim());	//id
					//　TODO 更新其他属性
					
					channelModelService.updateChannelModelById(channelModel, oldId);
					MainTreeView.treeViewer.update(channelModel, null);
				}

				LayoutUtil.hideViewPart();
			}
		});
		btnSave.setBounds(40, 10, 61, 27);
		btnSave.setText("保存(S)");

		Button btnCancel = new Button(composite_1, SWT.NONE);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				LayoutUtil.hideViewPart();
			}
		});
	
		btnCancel.setText("取消(C)");
		btnCancel.setBounds(151, 10, 61, 27);

		ViewPropertyChange.getInstance()
				.addPropertyChangeListener("channel", this);
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if (event.getProperty().equals(
				FirePropertyConstants.ACQUISITIONCHANNEL_ADD)) {
			isAdded = true;
			channelModel = new ChannelModel();
			
			Object object = event.getNewValue();
			channelModel.setParentObject(object);
			
			 //============初始化控件值============
			textChannelName.setText("");
			textIdx.setText("");
			

		} 
			else if (event.getProperty().equals(
				FirePropertyConstants.ACQUISITIONCHANNEL_EDIT)) {
				isAdded = false;
				
				channelModel = (ChannelModel) event.getNewValue();
				

			// ============初始化控件值============
			textChannelName.setText(channelModel.getName());
			textIdx.setText(channelModel.getId() == null ?"":channelModel.getId());
//			comboProtocal.setText(acquisitionChannel.getProtocal().toString());
//			textIdx.setText(acquisitionChannel.getIdx().toString());
//			textOffline.setText(acquisitionChannel.getOffline() + "");
//			textInterval.setText(String.valueOf(acquisitionChannel
//					.getInterval()));
//			textSchedule.setText(acquisitionChannel.getSchedule());
//			textPortInfo.setText(acquisitionChannel.getPortInfo());
//			textFrames.setText(acquisitionChannel.getFrames());
//
//			Date updateTime = acquisitionChannel.getUpdateTime();
//			Calendar updateTimeCalendar = Utils.date2CalendarUtil(updateTime);
//			int year = updateTimeCalendar.get(Calendar.YEAR);
//			int month = updateTimeCalendar.get(Calendar.MONTH);
//			int day = updateTimeCalendar.get((Calendar.DAY_OF_MONTH));
//			dateTimeUpdateTime.setDate(year, month, day);
//			// ====================================
//
		}
	}

	@Override
	public void dispose() {
		ViewPropertyChange.getInstance().removePropertyChangeListener("channel");
		super.dispose();
	}
}
