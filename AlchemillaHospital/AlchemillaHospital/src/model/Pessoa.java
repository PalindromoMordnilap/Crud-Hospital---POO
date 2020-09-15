package model;

import java.io.Serializable;

public abstract class Pessoa implements Serializable{
	private String cpf, nome, endereco;
	
	public Pessoa(String nome, String endereco, String cpf) {
		setNome(nome);
		setEndereco(endereco);
		setCpf(cpf);
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		if(!cpf.isEmpty()) {
			this.cpf = cpf;
		}else {
			this.cpf = " ";
		}
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(!nome.isEmpty()) {
			this.nome = nome;
		}else {
			this.nome = " ";
		}
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		if(!endereco.isEmpty()) {
			this.endereco = endereco;
		}else {
			this.endereco = " ";
		}
	}
}
