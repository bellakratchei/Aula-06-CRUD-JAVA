package com.bellakratchei.models;

public class Usuario {
	private Integer id;
	private String nome;
	private String email;
	private String cargo;
	
	public Usuario(Integer id, String nome, String email, String cargo) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cargo = cargo;
	}
	
	public Usuario(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCargo() {
		return cargo;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
}
