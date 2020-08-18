package br.com.fiap.persistence.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe que representa a entidade Categoria no banco de dados
 * @author Carlos Eduardo Roque da Silva
 *
 */
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String descricao;
	
	public Categoria() {
		super();
	}

	public Categoria(long id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return this.id + " - " + this.descricao;
	}
}
