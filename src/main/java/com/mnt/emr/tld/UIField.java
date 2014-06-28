package com.mnt.emr.tld;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class UIField extends SimpleTagSupport implements DynamicAttributes {

	private String ds;
	private String cType;
	public String getDs() {
		return ds;
	}

	public void setDs(String ds) {
		this.ds = ds;
	}

	public String getcType() {
		return cType;
	}

	public void setcType(String cType) {
		this.cType = cType;
	}



	private String label;
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}



	private String labelClass;
	
	private Map<String,Object> dynamicAttrs = new HashMap<String,Object>();
	
	public void doTag()
      throws JspException, IOException {
				StringBuilder sb = new StringBuilder();
				if(label != null)sb.append("<label class='"+ labelClass +"'>"+ label +"</label>");
				
				switch (cType) {
					case "text" :
						
						sb.append("<input type=\"text\" ");
						for (String s: dynamicAttrs.keySet()) {
							sb.append(String.format("%s=\"%s\" ", s, dynamicAttrs.get(s)));
						}
						sb.append(" >");
						break;
					case "date" :	
						if(dynamicAttrs.get("label") != null)sb.append("<label>"+ dynamicAttrs.get("label") +"</label>");
						
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
						sb.append("<select  ");
						for (String s: dynamicAttrs.keySet()) {
							sb.append(String.format("%s=\"%s\" ", s, dynamicAttrs.get(s)));
						}
						sb.append(" >/n");
						try {
							Class enumClass = Class.forName(ds);
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
					case "select" :
						sb.append("<select  ");
						for (String s: dynamicAttrs.keySet()) {
							sb.append(String.format("%s=\"%s\" ", s, dynamicAttrs.get(s)));
						}
						sb.append(" >/n");
						try {
							Method method = Class.forName("com.mnt.emr.SelectDataSourceFactory").getMethod(ds);
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
					case "bsradio" :
						
						try {
							Method method = Class.forName("com.mnt.emr.SelectDataSourceFactory").getMethod(ds);
							Map map = (Map) method.invoke(null);
							for(Object e : map.keySet()){
								sb.append("<label class='"+dynamicAttrs.get("bsradioclass")+"'>");
								
								String key = e.toString();
								String value = map.get(e).toString();
								sb.append("<input type='radio' name='options' id='"+key+"'" );
								for (String s: dynamicAttrs.keySet()) {
									if("bsradioclass".equalsIgnoreCase(s)) {continue;}
									sb.append(String.format("%s=\"%s\" ", s, dynamicAttrs.get(s)));
								}
								sb.append(">" + value);
								sb.append(" </label>/n");
								
								
								
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
						break;
					case "radio" :
						
						try {
							Method method = Class.forName("com.mnt.emr.SelectDataSourceFactory").getMethod(ds);
							Map map = (Map) method.invoke(null);
							for(Object e : map.keySet()){
								String key = e.toString();
								String value = map.get(e).toString();
								sb.append("<input type='radio' " );
								for (String s: dynamicAttrs.keySet()) {
									sb.append(String.format("%s=\"%s\" ", s, dynamicAttrs.get(s)));
								}
								sb.append("value='"+key+"'>" + value);
								
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
						break;
					case "checkbox" :
						
						try {
							Method method = Class.forName("com.mnt.emr.SelectDataSourceFactory").getMethod(ds);
							Map map = (Map) method.invoke(null);
							for(Object e : map.keySet()){
								String key = e.toString();
								String value = map.get(e).toString();
								sb.append("<input type='checkbox' " );
								for (String s: dynamicAttrs.keySet()) {
									if("ng-model".equalsIgnoreCase(s)) continue;
									if("data-ng-model".equalsIgnoreCase(s)) continue;
									sb.append(String.format("%s=\"%s\" ", s, dynamicAttrs.get(s)));
								}
								sb.append("data-ng-model='"+dynamicAttrs.get("data-ng-model")+"."+key+"'>" + value);
								
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
						break;	
				}
			
		
		
		
		
		JspWriter out = getJspContext().getOut();
        out.println(sb.toString());
      
    }

	@Override
	public void setDynamicAttribute(String uri, String localName, Object value)
			throws JspException {
		dynamicAttrs.put(localName.toLowerCase(), value);
		
	}

	public String getLabelClass() {
		return labelClass;
	}

	public void setLabelClass(String labelClass) {
		this.labelClass = labelClass;
	}
	


	
}
