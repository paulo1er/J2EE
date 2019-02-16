package org.mines.douai.j2ee.tp.DruMadeline;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="yellowJacketBean")
public class YellowJacketBean {
	private int deployedNumber;
	private String pays;

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public int getDeployedNumber() {
		return deployedNumber;
	}

	public void setDeployedNumber(int deployedNumber) {
		this.deployedNumber = deployedNumber;
	}

	public YellowJacketBean() {
		super();
		this.pays = "France";
		this.deployedNumber = (int)(500 + Math.random()*2500);
	}

	public YellowJacketBean(String pays) {
		super();
		this.pays = pays;
		this.deployedNumber = (int)(500 + Math.random()*2500);
	}
	
	public void doRefresh() {
		this.deployedNumber = (int)(500 + Math.random()*2500);
	}
	

}
