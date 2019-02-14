package org.mines.douai.j2ee.tp.DruMadeline;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="yellowJacketBean")
public class YellowJacketBean {
	private int deployedNumber;

	public int getDeployedNumber() {
		return deployedNumber;
	}

	public void setDeployedNumber(int deployedNumber) {
		this.deployedNumber = deployedNumber;
	}

	public YellowJacketBean() {
		super();
		this.deployedNumber = 0;
	}
	

}
