package org.mines.douai.j2ee.tp.DruMadeline.tag;

import java.io.IOException;

import java.util.HashMap;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class I18NYellowJacket extends SimpleTagSupport {

	private String lang;
	private String key;

	public I18NYellowJacket() {
	}

	public void setLang(String format) {
		this.lang = format;
	}

	public void setKey(String number) {
		this.key = number;
	}

	HashMap<String, Integer> dic = new HashMap<String, Integer>();
	{
		dic.put("France", (int) (500 + Math.random() * 2500));
		dic.put("Allemagne", (int) (Math.random() * 800));
		dic.put("Pologne", (int) (10 + Math.random() * 100));
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
				getJspContext().getOut().write(dicLanguages.get(key) + " : " + dic.get(key));
			} else {
				getJspContext().getOut().write(key + " : " + dic.get(key));
			}
		} catch (Exception e) {
			e.printStackTrace();
			// stop page from loading further by throwing SkipPageException
			throw new SkipPageException("Exception : " + key + " and " + lang);
		}
	}

}