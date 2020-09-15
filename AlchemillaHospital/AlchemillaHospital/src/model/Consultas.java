package model;

import java.io.Serializable;

public class Consultas implements Serializable {
	private String paciente;
	private String medico;
	private String dia, hora;
	
	public Consultas(String paciente, String medico, String dia, String hora) {
		setPaciente(paciente);
		setMedico(medico);
		setDia(dia);
		setHora(hora);
	}
	
	public String getPaciente() {
		return paciente;
	}
	
	//checar se paciente est� no array
	public void setPaciente(String paciente) {
		if(!paciente.isEmpty()) {
			this.paciente = paciente;
		}else {
			this.paciente = " ";
		}
	}
	
	//checar se medico est� no array
	public String getMedico() {
		return medico;
	}
	public void setMedico(String medico) {
		if(!medico.isEmpty()) {
			this.medico = medico;
		}else {
			this.medico = " ";
		}
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		if(!dia.isEmpty()) {
			this.dia = dia;
		}else {
			this.dia = "10";
		}
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		if (!hora.isEmpty()) {
			this.hora = hora;
		} else {
			this.hora = "10";
		}

	}

	@Override
	public String toString() {
		return "Consultas{" +
				"\npaciente: " + paciente + '\'' +
				"\nmedico: " + medico + '\'' +
				"\ndia: " + dia + '\'' +
				"\nhora: " + hora + '\'' +
				'}';
	}
}
