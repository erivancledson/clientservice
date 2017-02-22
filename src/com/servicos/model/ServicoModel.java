package com.servicos.model;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@XmlRootElement
@Entity
@Table(name="servico")
public class ServicoModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id //indica a chave primária
	//gera codigo automatico no bd
	@GeneratedValue(strategy=GenerationType.IDENTITY) //gera codigo autimático
	//nomeda coluna automatica
	@Column(name="serv_codigo")
	Integer codigo;
	//tamanho 50 e não pode ser nulo
	@Column(name="serv_nome", length=50, nullable=false)
	String nome;
	
	@Column(name="serv_descricao", length=50, nullable=true)
	String descricao;
	
	@Column(name="serv_valor", length=15, nullable=false)
	String valor;
	
	public void SetClientesModel(List<ClientesModel> clientesModel){
		this.clientesModel = clientesModel;
	}
	
	@OneToMany(mappedBy="servicoModel")
	
	private List<ClientesModel> clientesModel;
	
	@XmlTransient
	public List<ClientesModel> getClientes(){
		return clientesModel;
	}

	public ServicoModel(){
		
	}
	
	
	public ServicoModel(Integer codigo, String nome, String descricao, String valor) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
	}


	
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
		ServicoModel other = (ServicoModel) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
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

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
}