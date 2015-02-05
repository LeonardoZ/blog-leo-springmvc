package com.leonardoz.blog.entidade.dto;

public class DTO {
	
	private Integer id;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public boolean naoPersistido(){
		return id == null || id.equals(0);
	}

}