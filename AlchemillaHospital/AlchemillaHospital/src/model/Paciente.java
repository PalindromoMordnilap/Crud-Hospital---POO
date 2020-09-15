package model;

import java.io.Serializable;

public class Paciente extends Pessoa implements Serializable {
	private Prontuario pro;

	public Paciente(String nome, String endereco, String cpf){
		super(nome, endereco, cpf);
	}

	public Paciente(String nome, String endereco, String cpf, Prontuario prontuario){
		super(nome, endereco, cpf);
		setPro(prontuario);
	}

	public Prontuario getPro() {
		return pro;
	}

	public void setPro(Prontuario pro) {
		this.pro = pro;
	}

	@Override
	public String toString() {
		return "Paciente{" + "\nNome: " + super.getNome()+ "\nEndereco: " + super.getEndereco() + "\nCpf: " + super.getCpf() +
				"\npro: " + pro.getObs() + '}';
	}
}
