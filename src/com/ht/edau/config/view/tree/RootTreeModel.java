package com.ht.edau.config.view.tree;

/**
 * 树根节点模型
 * 
 * @author 赵磊
 * 
 */
public enum RootTreeModel {
	instanse;

	public String labelIndexConfig = "标签索引配置";
	public String tagTypeConfig = "标签类型配置";
	public String channelConfig = "通道配置";
	public String otherConfig = "其他配置";

	public String[] getRoottree() {
		String ss[] = new String[4];
		ss[0] = labelIndexConfig;
		ss[1] = tagTypeConfig;
		ss[2] = channelConfig;
		ss[3] = otherConfig;

		return ss;
	}

}
