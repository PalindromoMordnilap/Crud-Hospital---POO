package model;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private Pessoa pessoa;
    public static ArrayList<Medico> medicos = new ArrayList<Medico>();
    public static ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
    public static ArrayList<Consultas> consultas = new ArrayList<Consultas>();

    public Hospital(){}

    public Hospital(Pessoa pessoa){
        setPessoa(pessoa);
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void addMedico(Medico med){
        medicos.add(med);
    }

    public Medico searchMedicoNome(String nome){
        for (int i = 0; i < medicos.size(); i++) {
            if (medicos.get(i).getNome().equals(nome))
                return medicos.get(i);
        }

        return null;
    }
    public Medico searchMedicoCodigo(String codigo){
        for (int i = 0; i < medicos.size(); i++) {
            if (medicos.get(i).getCodigo().equals(codigo))
                return medicos.get(i);
        }
        return null;
    }

    public void addPaciente(Paciente pac){
        pacientes.add(pac);
    }

    public Paciente searchPacienteNome(String nome){
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).getNome().equals(nome) || pacientes.get(i).getCpf().equals(nome))
                return pacientes.get(i);
        }
        return null;
    }

    public Paciente searchPacienteCpf(String nome){
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).getNome().equals(nome) || pacientes.get(i).getCpf().equals(nome))
                return pacientes.get(i);
        }
        return null;
    }

    public void addConsulta(Consultas con){
        consultas.add(con);
    }

    public void remover(Consultas con){
        consultas.remove(con);
    }

    public Consultas searchConsulta(String paciente) {
        for (int i = 0; i < consultas.size(); i++) {
            if (consultas.get(i).getPaciente().equals(paciente))
                return consultas.get(i);
        }
        return null;
    }
}
