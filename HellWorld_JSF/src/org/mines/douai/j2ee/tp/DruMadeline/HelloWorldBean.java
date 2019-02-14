package org.mines.douai.j2ee.tp.DruMadeline;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="helloWorldBean")
public class HelloWorldBean {
	public HelloWorldBean() {
		this.name = "Paul";
		this.calculatedName = "Bonjour ";
	}

	private String name;
	private String calculatedName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCalculatedName() {
		return calculatedName;
	}

	public void setCalculatedName(String calculatedName) {
		this.calculatedName = calculatedName;
	}
	
	public String doRepeat() {
		for (int i = 0; i<3; i++) {
			calculatedName = calculatedName + name;
		}
		return "repeat";
	}
}
