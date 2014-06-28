package com.mnt.emr.tld;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class FormHeaderUI extends SimpleTagSupport {

	private StringWriter sw = new StringWriter();
	private String cssclass = "box-header";
	
	
	public String getCssclass() {
		return cssclass;
	}
	public void setCssclass(String cssclass) {
		this.cssclass = cssclass;
	}
	private static String _html = "<h4 class='white' style='padding: 0px;'> " +
			 "<div style='font-size: 1px; background-color: rgb(232, 232, 221);'> " +
			 "<div style='margin: 0px 2px; height: 1px; overflow: hidden; background-color: rgb(181, 183, 176);'> " +
"<div style='margin: 0px 1px; height: 1px; overflow: hidden; background-color: rgb(103, 108, 107);'> " +
"<div style='margin: 0px 1px; height: 1px; overflow: hidden; background-color: rgb(67, 72, 75);'> " +
"<div style='margin: 0px 1px; height: 1px; overflow: hidden; background-color: rgb(58, 64, 67);'> " +
"</div></div></div></div> " +
"<div style='margin: 0px 1px; height: 1px; overflow: hidden; background-color: rgb(145, 148, 144);'> " +
"<div style='margin: 0px 1px; height: 1px; overflow: hidden; background-color: rgb(58, 64, 67);'> " +
"<div style='margin: 0px 1px; height: 1px; overflow: hidden; background-color: rgb(58, 64, 67);'> " +
"</div></div></div> " +
"<div style='margin: 0px; height: 1px; overflow: hidden; background-color: rgb(181, 183, 176);'> " +
"<div style='margin: 0px 1px; height: 1px; overflow: hidden; background-color: rgb(58, 64, 67);'> " +
"</div></div> " +
"<div style='margin: 0px; height: 1px; overflow: hidden; background-color: rgb(103, 108, 107);'> " +
"<div style='margin: 0px 1px; height: 1px; overflow: hidden; background-color: rgb(58, 64, 67);'> " +
"</div></div> " +
"<div style='margin: 0px; height: 1px; overflow: hidden; background-color: rgb(67, 72, 75);'> " +
"<div style='margin: 0px 1px; height: 1px; overflow: hidden; background-color: rgb(58, 64, 67);'> " +
"</div></div></div> " +
"<div class='{cssclass}'>{HEADER}</div> " +
"</h4>";
	public void doTag()
      throws JspException, IOException
    {
       getJspBody().invoke(sw);
       JspWriter out = getJspContext().getOut();
       String htmlOut = _html.replace("{cssclass}", cssclass).replace("{HEADER}",sw.toString());
       out.println(htmlOut);
      
    }
}
