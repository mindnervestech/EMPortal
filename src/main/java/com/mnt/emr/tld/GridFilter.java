package com.mnt.emr.tld;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.codehaus.jackson.type.TypeReference;

import play.libs.Json;

public class GridFilter extends SimpleTagSupport implements DynamicAttributes {

	private StringWriter sw = new StringWriter();
	
	private String json;

	public void setJson(String json) {
		this.json = json;
	}


	public void setField(String field) {
		this.field = field;
	}

	private String field;
	private Map<String,Object> dynamicAttrs = new HashMap<String,Object>();
	
	public void doTag()
      throws JspException, IOException {
		
		int filterIndex = json.indexOf("\"filters\"");
		
		List<Fields> fields = Json.fromJson(Json.parse("{"+json.substring(filterIndex)).get("filters"),new TypeReference<List<Fields>>() {});
		StringBuilder sb = new StringBuilder();
		for (Fields _f : fields) {
			
			if(_f.name.equalsIgnoreCase(field)) {
				
				
				switch (_f.type) {
					case "text" :
						sb.append("<label>"+ _f.label +"</label>");
						sb.append("<input type=\"text\" ");
						for (String s: dynamicAttrs.keySet()) {
							sb.append(String.format("%s=\"%s\" ", s, dynamicAttrs.get(s)));
						}
						sb.append(" >");
						break;
					case "date" :	
						sb.append("<label>"+ _f.label +"</label>");
						sb.append("<input type='text' class='dropdown-toggle' data-toggle='dropdown' "); 
						for (String s: dynamicAttrs.keySet()) {
							if(!s.equalsIgnoreCase("data-ng-model"))
								sb.append(String.format("%s=\"%s\" ", s, dynamicAttrs.get(s)));
						}
						sb.append(" >\n");
						sb.append("<ul class='dropdown-menu' role='menu' aria-labelledby='dLabel'> \n"); 
						sb.append("<datetimepicker ");  
						sb.append("data-ng-model =\"" + dynamicAttrs.get("data-ng-model") +"\""); 
						sb.append("data-datetimepicker-config=\"{ dropdownSelector: '.dropdown-toggle',minView: 'day' }\"></datetimepicker>\n" +
						  		"</ul>");
						break;
					case "enum" :
						sb.append("<label>"+ _f.label +"</label>");
						sb.append("<select  ");
						for (String s: dynamicAttrs.keySet()) {
							sb.append(String.format("%s=\"%s\" ", s, dynamicAttrs.get(s)));
						}
						sb.append(" >/n");
					try {
						Class enumClass = Class.forName(_f.ds);
						if(enumClass.isEnum()) {
							for(Object e : enumClass.getEnumConstants()){
								String key = ((Enum)e).name();
								String value = enumClass.getField("displayValue").get(e).toString();
								sb.append("<option value=\"" + key + "\">");
								sb.append(value);
								sb.append("</option>\n");
							};
						}
					} catch (ClassNotFoundException | IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						sb.append("</select >");
						break;	
					case "java" :
						sb.append("<label>"+ _f.label +"</label>");
						sb.append("<select  ");
						for (String s: dynamicAttrs.keySet()) {
							sb.append(String.format("%s=\"%s\" ", s, dynamicAttrs.get(s)));
						}
						sb.append(" >/n");
						try {
							Method method = Class.forName("com.mnt.emr.SelectDataSourceFactory").getMethod(_f.ds);
							Map map = (Map) method.invoke(null);
							for(Object e : map.keySet()){
								String key = e.toString();
								String value = map.get(e).toString();
								sb.append("<option value=\"" + key + "\">");
								sb.append(value);
								sb.append("</option>\n");
							};
						} catch (IllegalAccessException | IllegalArgumentException
								| InvocationTargetException e) {
							e.printStackTrace();
						} catch (NoSuchMethodException e) {
							e.printStackTrace();
						} catch (SecurityException e) {
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
						sb.append("</select >");
						break;
						
				}
				break;	
				
			}
		}
		
		
		
		JspWriter out = getJspContext().getOut();
        out.println(sb.toString());
      
    }

	@Override
	public void setDynamicAttribute(String uri, String localName, Object value)
			throws JspException {
		dynamicAttrs.put(localName.toLowerCase(), value);
		
	}
	
	public static class Fields {
		public String name;
		public String type;
		public String label;
		public String ds;
	}
}
