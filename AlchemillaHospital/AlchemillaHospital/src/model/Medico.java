package model;

import java.io.Serializable;

public class Medico extends Pessoa implements Serializable {

    private String codigo;

    public Medico(String nome, String endereco, String cpf, String codigo) {
        super(nome, endereco, cpf);
        setCodigo(codigo);

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Medico{" + "\nNome: "+ super.getNome() + "\nEndereco: " + super.getEndereco() + "\nCpf: " + super.getCpf() + "\n" +
                "codigo: " + codigo + '}';
    }
}
