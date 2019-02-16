package org.mines.douai.j2ee.tp.DruMadeline;

import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "yellowJacketBeanList")
public class YellowJacketBeanList {
	private List<YellowJacketBean> liste;
	private String current;

	public List<YellowJacketBean> getListe() {
		return liste;
	}

	public void setListe(List<YellowJacketBean> liste) {
		this.liste = liste;
	}

	public YellowJacketBeanList() {
		super();
		this.liste = Arrays.asList(new YellowJacketBean("France"), new YellowJacketBean("Allemagne"), new YellowJacketBean("Pologne"));
		this.current = "France";
	}

	public int getYellowJacketNb(String pays) {
		for (int i = 0; i < liste.size(); i++) {
			if (this.liste.get(i).getPays().equals(pays)) {
				return this.liste.get(i).getDeployedNumber();
			}
		}
		return this.liste.get(0).getDeployedNumber();
	}

	public String getYellowJacketPays(String pays) {
		for (int i = 0; i < liste.size(); i++) {
			if (this.liste.get(i).getPays().equals(pays)) {
				return this.liste.get(i).getPays();
			}
		}
		return this.liste.get(0).getPays();
	}

	public String getCurrent() {
		return current;
	}

	public void setCurrent(String current) {
		this.current = current;
	}

	public void doRefresh() {
		for (int i = 0; i < liste.size(); i++) {
			this.liste.get(i).doRefresh();
		}
	}

}
