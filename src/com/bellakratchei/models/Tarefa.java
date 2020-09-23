package com.bellakratchei.models;

public class Tarefa extends Usuario{
	private Integer id;
	private Character status;
	private Integer id_usuario;
	private String titulo;
	private String descricao;
	
	public Tarefa(Integer id, Character status, Integer id_usuario, String titulo, String descricao) {
		super(id_usuario);
		this.id = id;
		this.status = status;
		this.titulo = titulo;
		this.descricao = descricao;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Character getStatus() {
		return status;
	}
	
	public void setStatus(char status) {
		this.status = status;
	}
	
	public Integer getId_usuario() {
		return id_usuario;
	}
	
	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
