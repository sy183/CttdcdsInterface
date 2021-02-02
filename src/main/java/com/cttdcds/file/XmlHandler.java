package com.cttdcds.file;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class XmlHandler extends TextFileHandler {
	private final SAXReader saxReader = new SAXReader();
	private Document dom;

	public XmlHandler(File textFile) throws DocumentException {
		super(textFile);
		dom = saxReader.read(textFile);
	}

	public void reloadXml() throws DocumentException {
		dom = saxReader.read(textFile);
	}

	public Element getSection(String section) {
		Element rootElement = dom.getRootElement();
		List<?> elements = rootElement.elements();
		for (Object element : elements) {
			if (element instanceof Element) {
				Element ele = (Element) element;
				if ("section".equals(ele.getName()) && section.equals(ele.attributeValue("name"))) {
					return ele;
				}
			}
		}
		return null;
	}
}
