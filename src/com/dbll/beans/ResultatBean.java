package com.dbll.beans;

public class ResultatBean {

	private int question_id;
	private int reponse_id;
		
	
	public ResultatBean(int question_id, int reponse_id) {
		super();
		this.question_id = question_id;
		this.reponse_id = reponse_id;
	}
	
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public int getReponse_id() {
		return reponse_id;
	}
	public void setReponse_id(int reponse_id) {
		this.reponse_id = reponse_id;
	}
	
}
