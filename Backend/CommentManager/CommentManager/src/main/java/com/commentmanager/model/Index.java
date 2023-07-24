package com.commentmanager.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("ManageIndex")
public class Index {
	@Id
	private String id;
	private int index;

	public Index() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Index(String id, int index) {
		super();
		this.id = id;
		this.index = index;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public String toString() {
		return "Index [id=" + id + ", index=" + index + "]";
	}
	
	
}
