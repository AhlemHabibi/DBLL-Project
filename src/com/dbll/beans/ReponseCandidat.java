package com.dbll.beans;

public class ReponseCandidat {

	private String ncin;
	private float score;
	
	public ReponseCandidat(String ncin, float score) {
		super();
		this.ncin = ncin;
		this.score = score;
	}
	
	public String getNcin() {
		return ncin;
	}
	public void setNcin(String ncin) {
		this.ncin = ncin;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
}
