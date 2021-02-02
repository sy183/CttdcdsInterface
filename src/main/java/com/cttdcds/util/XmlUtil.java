package com.cttdcds.util;

import org.dom4j.Attribute;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class XmlUtil {
	public static final SAXReader saxReader = new SAXReader();

	@SuppressWarnings("all")
	private static void mapMergePut(Map<String, Object> map, String key, Object value) {
		Object val = map.get(key);
		if (val != null) {
			if (val instanceof List) {
				((List<Object>) val).add(value);
			} else {
				List<Object> list = new ArrayList<>();
				list.add(val);
				list.add(value);
				map.put(key, list);
			}
		} else {
			map.put(key, value);
		}
	}

	private static Object xmlToObject(Element element) {
		String text = element.getText().trim();
		List<Attribute> attributes = element.attributes();
		List<Element> elements = element.elements();
		if (attributes.size() == 0 && elements.size() == 0) {
			return text;
		}

		Map<String, Object> map = new LinkedHashMap<>();
		attributes.forEach(attribute -> map.put(attribute.getName(), attribute.getValue()));
		if (!"".equals(text)) mapMergePut(map, "#text", text);
		elements.forEach(ele -> mapMergePut(map, ele.getName(), xmlToObject(ele)));
		if (!"".equals(text)) map.put("#text", text);

		return map;
	}

	public static Map<String, Object> xmlToMap(Element element) {

		Map<String, Object> map = new LinkedHashMap<>();
		String key = element.getName();
		Object value = xmlToObject(element);
		map.put(key, value);
		return map;

	}
}
