package com.ht.edau.config.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.jaxen.JaxenException;
import org.jaxen.XPath;
import org.jaxen.dom4j.Dom4jXPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ht.edau.config.dao.ChannelModelDao;
import com.ht.edau.config.model.ChannelModel;
import com.ht.edau.config.util.GetXpathUtil;
import com.ht.edau.config.util.XMLDocumentFactory;

public class ChannelModelDaoImpl implements ChannelModelDao {

	private static final Logger log = LoggerFactory
			.getLogger(ChannelModelDaoImpl.class);

	@Override
	public void create(ChannelModel domain) {
		Document document = XMLDocumentFactory.instance.getMainDocument();
		String path = "/" + XMLDocumentFactory.ROOT_NODE + "/"
				+ XMLDocumentFactory.CHANNEL_NODE;
		Element e = (Element) document.selectSingleNode(path);

		if (e != null) {
			Element addedElement = e.addElement(ChannelModel.NODE_NAME);

			addedElement.addAttribute(ChannelModel.NAME_ATTR,
					domain.getName());
			addedElement.addAttribute(ChannelModel.ID_ATTR,
					domain.getId());
			addedElement.addAttribute(ChannelModel.INSTALL_POSITION_ATTR, domain.getFixPositon());
			addedElement.addAttribute(ChannelModel.PROTOCAL_ATTR,
					domain.getProtocal());
			addedElement.addAttribute(ChannelModel.INTERVAL_ATTR,
					domain.getInterval());
			addedElement.addAttribute(ChannelModel.OFFLINE_ATTR,
					domain.getOffline());
			addedElement.addAttribute(ChannelModel.LOOP_INTERVAL_ATTR, domain.getLoopInterval());

			addedElement.addAttribute(ChannelModel.COMPORT_ATTR,
					domain.getComPort());
			addedElement.addAttribute(ChannelModel.BAUD_ATTR,
					domain.getBaud());
			addedElement.addAttribute(ChannelModel.CHECK_ATTR,
					domain.getCheck());
			addedElement.addAttribute(ChannelModel.STOPBIT_ATTR,
					domain.getStopBit());
			addedElement.addAttribute(ChannelModel.DATABIT_ATTR,
					domain.getDataBit());

			addedElement.addAttribute(ChannelModel.IP_ATTR,
					domain.getIp());
			addedElement.addAttribute(ChannelModel.TCPPORT_ATTR,
					domain.getTcpPort());

			addedElement.addAttribute(ChannelModel.DTU_ID_ATTR,domain.getDtuId());
			addedElement.addAttribute(ChannelModel.HEART_BEAT_ATTR,domain.getHeartBeat());
			addedElement.addAttribute(ChannelModel.DTU_PORT_ATTR,domain.getDtuPort());
			
			domain.setElement(addedElement);

			XMLDocumentFactory.instance.saveMainDocument(document);
		}
		
	}

	@Override
	public ChannelModel read(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(ChannelModel domain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ChannelModel domain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ChannelModel> getAllChannelModel() {
		List<ChannelModel> channelModelList = new ArrayList<ChannelModel>();

		List<?> results = null;
		try {
			XPath xpath = new Dom4jXPath("/" + XMLDocumentFactory.ROOT_NODE
					+ "/" + XMLDocumentFactory.CHANNEL_NODE + "/"
					+ ChannelModel.NODE_NAME);
			results = xpath.selectNodes(XMLDocumentFactory.instance
					.getMainDocument());
		} catch (JaxenException e1) {
			e1.printStackTrace();
		}

		Iterator<?> i = results.iterator();
		while (i.hasNext()) {
			Object o = i.next();
			if (o instanceof Element) {
				Element n = (Element) o;
				ChannelModel im = new ChannelModel(n);
				channelModelList.add(im);
			}
		}

		return channelModelList;
	}

	@Override
	public void updateChannelModelById(ChannelModel channelModel, String oldId) {
		Document document = XMLDocumentFactory.instance.getMainDocument();

		String path = "/" + XMLDocumentFactory.ROOT_NODE + "/"
				+ XMLDocumentFactory.CHANNEL_NODE + "/"
				+ ChannelModel.NODE_NAME + "[@" + ChannelModel.ID_ATTR + "='"
				+ oldId + "']";
		log.debug(path);
		Element e = (Element) document.selectSingleNode(path);

		if (e != null) {
			e.addAttribute(ChannelModel.NAME_ATTR, channelModel.getName());
			e.addAttribute(ChannelModel.ID_ATTR, channelModel.getId());
			e.addAttribute(ChannelModel.INSTALL_POSITION_ATTR, channelModel.getFixPositon());
			e.addAttribute(ChannelModel.PROTOCAL_ATTR,
					channelModel.getProtocal());
			e.addAttribute(ChannelModel.INTERVAL_ATTR,
					channelModel.getInterval());
			e.addAttribute(ChannelModel.OFFLINE_ATTR, channelModel.getOffline());
			e.addAttribute(ChannelModel.LOOP_INTERVAL_ATTR, channelModel.getLoopInterval());

			e.addAttribute(ChannelModel.COMPORT_ATTR, channelModel.getComPort());
			e.addAttribute(ChannelModel.BAUD_ATTR, channelModel.getBaud());
			e.addAttribute(ChannelModel.CHECK_ATTR, channelModel.getCheck());
			e.addAttribute(ChannelModel.STOPBIT_ATTR, channelModel.getStopBit());
			e.addAttribute(ChannelModel.DATABIT_ATTR, channelModel.getDataBit());

			e.addAttribute(ChannelModel.IP_ATTR, channelModel.getIp());
			e.addAttribute(ChannelModel.TCPPORT_ATTR, channelModel.getTcpPort());
			
			e.addAttribute(ChannelModel.DTU_ID_ATTR,channelModel.getDtuId());
			e.addAttribute(ChannelModel.HEART_BEAT_ATTR,channelModel.getHeartBeat());
			e.addAttribute(ChannelModel.DTU_PORT_ATTR,channelModel.getDtuPort());

			channelModel.setElement(e);

			XMLDocumentFactory.instance.saveMainDocument(document);
		}
		
	}

	@Override
	public void removeChannelModelById(ChannelModel channelModel) {
		Document document = XMLDocumentFactory.instance.getMainDocument();
		String path = GetXpathUtil.getChannelXPathById(channelModel);
		String parentPath = "/" + XMLDocumentFactory.ROOT_NODE + "/"
				+ XMLDocumentFactory.CHANNEL_NODE;

		if (document.selectSingleNode(path) != null) {
			Element e = (Element) document.selectSingleNode(path);
			Element parentElement = (Element) document
					.selectSingleNode(parentPath);
			parentElement.remove(e);

			XMLDocumentFactory.instance.saveMainDocument(document);
		}
	}

	@Override
	public ChannelModel getChannelModelByName(String name) {
		String path = "/" + XMLDocumentFactory.ROOT_NODE + "/"
					+ XMLDocumentFactory.CHANNEL_NODE + "/"
					+ ChannelModel.NODE_NAME + "[@" + ChannelModel.NAME_ATTR
					+ "='" + name + "']";
		log.debug(path);
		if (XMLDocumentFactory.instance.getMainDocument()
				.selectSingleNode(path) != null) {
			Element e = (Element) XMLDocumentFactory.instance.getMainDocument()
					.selectSingleNode(path);
			return new ChannelModel(e);
		}

		return null;
	}

	@Override
	public ChannelModel getChannelModelById(String id) {
		Document document = XMLDocumentFactory.instance.getMainDocument();
		String path = "/" + XMLDocumentFactory.ROOT_NODE + "/"
					+ XMLDocumentFactory.CHANNEL_NODE + "/"
					+ ChannelModel.NODE_NAME + "[@" + ChannelModel.ID_ATTR
					+ "='" + id + "']";
		log.debug(path);
		Element e = (Element) document.selectSingleNode(path);
		if (e != null) {
			return new ChannelModel(e);
		}

		return null;
	}

}
