package com.site.walletwise.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "transacoes")
public class Transacoes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transacoes_seq")
    @SequenceGenerator(name = "transacoes_seq", sequenceName = "transacoes_seq", allocationSize = 1)
	@Column(name = "id_transacoes")
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	@NotNull
	private Float valor;
	
	@Column
	private Boolean tipo_transacao;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
	@JsonBackReference
    private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Boolean getTipo_transacao() {
		return tipo_transacao;
	}

	public void setTipo_transacao(Boolean tipo_transacao) {
		this.tipo_transacao = tipo_transacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transacoes other = (Transacoes) obj;
		return Objects.equals(id, other.id);
	}
		
}
