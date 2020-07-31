package com.opentach.ws.common.rest.beans;

import java.io.Serializable;

public class Survey implements Serializable {

	protected String	id;

	protected String	name;

	protected Integer	correctQuestions;

	protected Integer	totalQuestions;

	protected boolean	done;

	public Survey() {}

	public Survey(String id, String name, Integer correctQuestions, Integer totalQuestions) {
		this.id = id;
		this.name = name;
		this.correctQuestions = correctQuestions;
		this.totalQuestions = totalQuestions;
		this.done = (correctQuestions != null);
	}

	public String getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public boolean isDone() {
		return this.done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCorrectQuestions() {
		return this.correctQuestions;
	}

	public void setCorrectQuestions(Integer correctQuestions) {
		this.correctQuestions = correctQuestions;
	}

	public Integer getTotalQuestions() {
		return this.totalQuestions;
	}

	public void setTotalQuestions(Integer totalQuestions) {
		this.totalQuestions = totalQuestions;
	}
}
