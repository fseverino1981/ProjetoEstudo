package br.com.seanfla.webfenix.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity(name="pets")
public class PetModel implements Serializable{

	public static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long id;
	private String nome;
	private String raca;
	
	private long idcliente;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public long getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(long idcliente) {
		this.idcliente = idcliente;
	}
	
	
}
