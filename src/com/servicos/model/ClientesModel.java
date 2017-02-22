package com.servicos.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
@Entity
@Table(name="cliente")
public class ClientesModel implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //gera codigo autimático
	@Column(name="cli_codigo")
	Integer codigo;
	@Column(name="cli_nome", length=50, nullable=false)
	String nome;
	@Column(name="cli_descricao", length=50, nullable=true)
	String descricao;
	

	@ManyToOne
	@JoinColumn(name="serv_codigo", referencedColumnName="serv_codigo")
	ServicoModel servicoModel;


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientesModel other = (ClientesModel) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	public ClientesModel(){
		
	}


	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public ServicoModel getServicoModel() {
		return servicoModel;
	}


	public void setServicoModel(ServicoModel servicoModel) {
		this.servicoModel = servicoModel;
	}
	
	
	
	
}
