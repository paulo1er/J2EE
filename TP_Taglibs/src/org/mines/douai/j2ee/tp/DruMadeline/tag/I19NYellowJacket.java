package org.mines.douai.j2ee.tp.DruMadeline.tag;

import java.io.IOException;

import java.util.HashMap;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class I19NYellowJacket extends SimpleTagSupport {

	private String lang;
	private String key;

	public I19NYellowJacket() {
	}

	public void setLang(String format) {
		this.lang = format;
	}

	public void setKey(String number) {
		this.key = number;
	}

	HashMap<String, String> dicLanguages = new HashMap<String, String>();
	{
		dicLanguages.put("France", "France");
		dicLanguages.put("Allemagne", "Germany");
		dicLanguages.put("Pologne", "Poland");
	}

	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("key is:" + key);
		System.out.println("lang is:" + lang);
		try {
			if ("English".equals(lang)) {
				getJspContext().getOut().write("<option value='" + key + "'>" + dicLanguages.get(key) + "</option>");
			} else {

				getJspContext().getOut().write("<option value='" + key + "'>" + key + "</option>");
			}
		} catch (Exception e) {
			e.printStackTrace();
			// stop page from loading further by throwing SkipPageException
			throw new SkipPageException("Exception : " + key + " and " + lang);
		}
	}

}