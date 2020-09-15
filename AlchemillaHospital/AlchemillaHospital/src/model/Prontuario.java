package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Prontuario implements Serializable {
	public final int MAXPRO = 50;
	private Date data;
	private String obs;
	ArrayList<Prontuario> prontuarios;
	
	public Prontuario(String obs) {
		data = new Date();
		setObs(obs);
		prontuarios = new ArrayList<Prontuario>(MAXPRO);
	}
	
	public Date getData() {
		return data;
	}
	
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		if(!obs.isEmpty()) {
			this.obs = obs;
		}else {
			this.obs = " ";
		}
	}
	
	public void addProntuario(String obs){
        Prontuario pron = new Prontuario(obs);
        prontuarios.add(pron); 
    }
	
	public void addProntuario(Prontuario pron){
	    prontuarios.add(pron); 
	}
}
