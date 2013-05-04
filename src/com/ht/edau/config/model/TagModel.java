package com.ht.edau.config.model;

import org.dom4j.Element;
/**
 * 标签模型
 * @author 赵磊
 *
 */
public class TagModel{
	
	public static final String NODE_NAME = "tag";

	public static final String VAR_NAME_ATTR = "var-name";
	public static final String NAME_ATTR = "name";
	public static final String TYPE_ATTR = "type";
	public static final String VALUE_ATTR = "value";
	
	public static final String ENERGY_INDEX_ATTR = "energy-index";
	public static final String NORMAL_INDEX_ATTR = "normal-index";
	
	public static final String RATED_POWER = "rated-power";
	


	private String varName;//变量名字  A00101B20_YM002
	private String name;
	private String type;	//标签类型
	private String value;	//值
	private String normalIndex;	//常规分类索引
	private String energyIndex;	//能耗分项索引
	
	private String ratedPower;	//额定功率
	


	private Element element;

	public TagModel(Element element) {
		this.element = element;
		
		varName = element.attributeValue(VAR_NAME_ATTR);
		name = element.attributeValue(NAME_ATTR);
		type = element.attributeValue(TYPE_ATTR);
		value = element.attributeValue(VALUE_ATTR);
		normalIndex = element.attributeValue(NORMAL_INDEX_ATTR);
		energyIndex = element.attributeValue(ENERGY_INDEX_ATTR);
		ratedPower = element.attributeValue(RATED_POWER);
	}
	
	public TagModel() {
		
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	public String getNormalIndex() {
		return normalIndex;
	}

	public void setNormalIndex(String normalIndex) {
		this.normalIndex = normalIndex;
	}

	



	public String getEnergyIndex() {
		return energyIndex;
	}

	public void setEnergyIndex(String energyIndex) {
		this.energyIndex = energyIndex;
	}

	public String getRatedPower() {
		return ratedPower;
	}

	public void setRatedPower(String ratedPower) {
		this.ratedPower = ratedPower;
	}

	public String getVarName() {
		return varName;
	}

	public void setVarName(String varName) {
		this.varName = varName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	
	
}
