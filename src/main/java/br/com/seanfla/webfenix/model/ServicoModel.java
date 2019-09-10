package br.com.seanfla.webfenix.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "servicos")
public class ServicoModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6108984125587896516L;
	
	@Id
	@GeneratedValue
	private long id;
	private String ds_servico;
	private double valor;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDs_servico() {
		return ds_servico;
	}
	public void setDs_servico(String ds_servico) {
		this.ds_servico = ds_servico;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
		

}
