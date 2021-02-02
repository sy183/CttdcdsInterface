package com.cttdcds.file;

import com.cttdcds.util.GsonUtil;
import org.dom4j.Attribute;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class XmlHandlerTest {
	@Test
	public void test() throws DocumentException, IOException {
		XmlHandler xmlHandler = new XmlHandler(new File("C:\\Users\\Administrator\\Desktop\\freeswitch.xml.fsxml"));
		Element dialplan = xmlHandler.getSection("dialplan");

		Object map = new Function<Element, Object>() {
			@Override
			public Object apply(Element element) {
				String text = element.getText().trim();
				List<Attribute> attributes = element.attributes();
				List<Element> elements = element.elements();
				if (attributes.size() == 0 && elements.size() == 0) {
					return text;
				}

				Map<String, Object> map = new LinkedHashMap<>();
				attributes.forEach(attribute -> map.put(attribute.getName(), attribute.getValue()));
				if (!"".equals(text)) {
					Object val = map.get("#text");
					if (val != null) {
						if (val instanceof List) {
							((List<Object>) val).add(text);
						} else {
							List<Object> list = new ArrayList<>();
							list.add(val);
							list.add(text);
							map.put("#text", list);
						}
					} else {
						map.put("#text", text);
					}
				}
				elements.forEach(ele -> {
					Object val = map.get(ele.getName());
					if (val != null) {
						if (val instanceof List) {
							((List<Object>) val).add(this.apply(ele));
						} else {
							List<Object> list = new ArrayList<>();
							list.add(val);
							list.add(this.apply(ele));
							map.put(ele.getName(), list);
						}
					} else {
						map.put(ele.getName(), this.apply(ele));
					}
				});
				if (!"".equals(text)) {
					map.put("#text", text);
				}
				return map;
			}
		}.apply(dialplan);

		System.out.println(GsonUtil.gson.toJson(map));

	}
}
