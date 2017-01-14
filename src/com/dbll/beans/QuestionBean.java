package com.dbll.beans;

import java.util.List;

public class QuestionBean {

	private int id;
	private String contenu;
	private List<ReponseBean> reponsesBean;
		
	public QuestionBean(int id, String contenu, List<ReponseBean> reponsesBean) {
		super();
		this.id = id;
		this.contenu = contenu;
		this.reponsesBean = reponsesBean;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public List<ReponseBean> getReponsesBean() {
		return reponsesBean;
	}
	public void setReponsesBean(List<ReponseBean> reponsesBean) {
		this.reponsesBean = reponsesBean;
	}
}
