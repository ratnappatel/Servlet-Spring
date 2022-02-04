package com.gl.customtag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Message extends SimpleTagSupport {
	public void doTag()throws JspException,IOException
	{
		JspWriter out=getJspContext().getOut();
		out.println("I am a Simple Custom Tag with No body / No Attribute.");
	}
	

}
