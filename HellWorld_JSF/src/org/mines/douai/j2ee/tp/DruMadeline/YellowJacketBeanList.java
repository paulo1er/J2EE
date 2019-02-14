package org.mines.douai.j2ee.tp.DruMadeline;

import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="yellowJacketBeanList")
public class YellowJacketBeanList {
	private List<YellowJacketBean> liste;

	public List<YellowJacketBean> getListe() {
		return liste;
	}

	public void setListe(List<YellowJacketBean> liste) {
		this.liste = liste;
	}

	public YellowJacketBeanList() {
		super();
	}
	
}
