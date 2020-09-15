package controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import model.*;

import java.util.Optional;

import static model.Hospital.consultas;
import static model.Hospital.medicos;
import static model.Hospital.pacientes;

public class ControllerMain {

	public static LeituraEscrita<Medico> mRW;
	public static LeituraEscrita<Paciente> pRW;
	public static LeituraEscrita<Consultas> cRW;

	@FXML
	void initialize() {
	    this.lerArquivos();
	}
	
	//Panes
	@FXML
    private TabPane cadastrarPane;

	@FXML
    private Pane desmarcarConsultaPane;
	
	@FXML
    private Pane consultaPane;
	
	@FXML
    private TabPane buscarPessoaTab;
	
	//TextField Medico
    @FXML
    private TextField nomeMedico;

    @FXML
    private TextField cpfMedico;

    @FXML
    private TextField codigoMedico;

    @FXML
    private TextField enderecoMedico;

    //TextField Paciente
    @FXML
    private TextField nomePaciente;

    @FXML
    private TextField cpfPaciente;

    @FXML
    private TextField enderecoPaciente;

    @FXML
    private TextArea observacoesPaciente;

    //TextfField consulta
    @FXML
    private TextField consultaMedico;

    @FXML
    private TextField consultaPaciente;

    @FXML
    private TextField consultaDia;

    @FXML
    private TextField consultaHora;
    
    //TextField busca paciente
    @FXML
    private TextField buscaNomePaciente;

    @FXML
    private TextField buscaCpfPaciente;

    //TextField busca Medico
    @FXML
    private TextField buscaNomeMedico;

    @FXML
    private TextField buscaCodigoMedico;
    
    //TextField buscaConsulta
    @FXML
    private TextField buscaNomePacienteConsulta;
    
    @FXML
    void buscaPessoa(ActionEvent event) {
    	cadastrarPane.setVisible(false);
    	consultaPane.setVisible(false);
    	buscarPessoaTab.setVisible(true);
    	desmarcarConsultaPane.setVisible(false);
    	this.clearAll();
    }
    
    @FXML
    void cadastrarConsulta(ActionEvent event) {
    	cadastrarPane.setVisible(false);
    	consultaPane.setVisible(true);
    	buscarPessoaTab.setVisible(false);
    	desmarcarConsultaPane.setVisible(false);
        this.clearAll();
    }
    
    @FXML
    void cadastrarPessoa(ActionEvent event) {
    	cadastrarPane.setVisible(true);
    	consultaPane.setVisible(false);
    	buscarPessoaTab.setVisible(false);
    	desmarcarConsultaPane.setVisible(false);
        this.clearAll();
    }
    
    @FXML
    void desmarcarConsulta(ActionEvent event) {
    	cadastrarPane.setVisible(false);
    	consultaPane.setVisible(false);
    	buscarPessoaTab.setVisible(false);
    	desmarcarConsultaPane.setVisible(true);
        this.clearAll();
    }
    
    @FXML
    void buscaPaciente(ActionEvent event) {
    	String nome = buscaNomePaciente.getText().toString();
    	String cpf = buscaCpfPaciente.getText().toString();

    	Hospital hospital = new Hospital();
    	Prontuario pro = new Prontuario("");
    	pro.getObs();
    	Paciente paciente = new Paciente(nome, cpf, " ");

        if(nome.isEmpty()) {
            paciente = hospital.searchPacienteCpf(cpf);
            if(paciente != null) {
                this.alerta(paciente.toString());
            }else {
                this.alerta("Paciente não encontrado");
            }
        }else if(cpf.isEmpty()){
            paciente = hospital.searchPacienteNome(nome);
            if(paciente != null) {
                this.alerta(paciente.toString());
            }else{
                this.alerta("Paciente não encontrado");
            }

        }else if(nome.isEmpty() && cpf.isEmpty()){
            this.alerta("ERRO CAMPOS VAZIOS");
        }else if(!nome.isEmpty() && !cpf.isEmpty()) {
            paciente = hospital.searchPacienteNome(nome);
            if (paciente != null) {
                this.alerta(paciente.toString());
            } else {
                this.alerta("Paciente não encontrado");
            }
        }
        this.clearBuscarPaciente();
    }

    @FXML
    void buscarMedico(ActionEvent event) {
    	String nome = buscaNomeMedico.getText().toString();
    	String codigo = buscaCodigoMedico.getText().toString();

    	Hospital hospital = new Hospital();
    	Medico medico = new Medico(nome, "", "", codigo);
    	if(nome.isEmpty()) {
    		medico = hospital.searchMedicoCodigo(codigo);
            if(medico != null) {
                this.alerta(medico.toString());
            }else{
                this.alerta("Medico não encontrado");
            }
    	}else if(codigo.isEmpty()){
            medico = hospital.searchMedicoNome(nome);
            if(medico != null) {
                this.alerta(medico.toString());
            }else{
                this.alerta("Medico não encontrado");
            }

    	}else if(nome.isEmpty() && codigo.isEmpty()){
    	    this.alerta("ERRO CAMPOS VAZIOS");
		}else if(!nome.isEmpty() && !codigo.isEmpty()){
            medico = hospital.searchMedicoNome(nome);
            if(medico != null) {
                this.alerta(medico.toString());
            }else{
                this.alerta("Medico não encontrado");
            }
        }
        this.clearBuscarMedico();
    }

    @FXML
    void buscarConsulta(ActionEvent event) {
		String paciente = buscaNomePacienteConsulta.getText().toString();

		Hospital hospital = new Hospital();
		Consultas consulta = new Consultas(paciente, "", "", "");

    	if(paciente.isEmpty()){
            this.alerta("ERRO CAMPOS VAZIOS");
		}else{
            try{
                consulta = hospital.searchConsulta(paciente);

                if(consulta != null){
                    boolean result = false;
                    result = this.alertaConfirm(consulta.toString() + "\nTEM CERTEZA QUE DESEJA DELETAR ESSA CONSULTA");
                    if(result == true){
                        hospital.remover(consulta);
                        this.alerta("CONSULTA APAGADA");
                    }
                }

            } catch (java.lang.NullPointerException e){
                this.alerta("CONSULTA NÂO ENCONTRADA");
            }

		}
		this.clearBuscarConsulta();
	}

    @FXML
    void cadastrarMedico() {
    	String nome = nomeMedico.getText();
    	String endereco = enderecoMedico.getText();
    	String cpf = cpfMedico.getText();
    	String codigo = codigoMedico.getText();
    	
    	if(nome.isEmpty() || endereco.isEmpty() || cpf.isEmpty() || codigo.isEmpty()) {
            this.alerta("ERRO! CAMPOS VAZIOS");
    	}else {
    		Hospital hospital = new Hospital();
    		Medico medico = new Medico(nome, endereco, cpf, codigo);

			hospital.addMedico(medico);

        	this.alerta("Medico cadastrado com sucesso!");
    	}
    	this.clearMedico();
    }

    @FXML
    void cadastrarPaciente(ActionEvent event) {
    	String nome = nomePaciente.getText().toString();
    	String endereco = enderecoPaciente.getText().toString();
    	String cpf = cpfPaciente.getText().toString();
    	String obs = observacoesPaciente.getText().toString();

    	if(nome.isEmpty() || endereco.isEmpty() || cpf.isEmpty() || obs.isEmpty()) {
            this.alerta("ERRO! CAMPOS VAZIOS");
    	}else {
    		Prontuario pro = new Prontuario(obs);
        	pro.getObs();
        	Hospital hospital = new Hospital();
        	Paciente paciente = new Paciente(nome, endereco, cpf, pro);
        	hospital.addPaciente(paciente);

        	this.alerta("Paciente cadastrado com sucesso");
    	}
    	this.clearPaciente();
    }
    
    @FXML
    void criarConsulta(ActionEvent event) {
    	String medico = consultaMedico.getText().toString();
    	String paciente = consultaPaciente.getText().toString();
    	String dia = consultaDia.getText().toString();
    	String hora = consultaHora.getText().toString();
    	
    	if(medico.isEmpty() || paciente.isEmpty() || dia.isEmpty() || hora.isEmpty()) {
    		this.alerta("Campos Vazios");
      	}else {
            Hospital hospital = new Hospital();
            Consultas consulta = new Consultas(medico, paciente, dia, hora);
        	hospital.addConsulta(consulta);
        	
        	this.alerta("Consulta criada com sucesso");
      	}
      	this.clearConsulta();
    }

    private void clearAll(){
        this.clearBuscarConsulta();
        this.clearMedico();
        this.clearPaciente();
        this.clearConsulta();
        this.clearBuscarMedico();
        this.clearBuscarPaciente();
    }

    private void clearBuscarPaciente(){
        buscaNomePaciente.clear();
        buscaCpfPaciente.clear();
    }

    private void clearBuscarMedico(){
        buscaNomeMedico.clear();
        buscaCodigoMedico.clear();
    }

    private void clearBuscarConsulta(){
        buscaNomePacienteConsulta.clear();
    }

    private void clearMedico(){
        nomeMedico.clear();
        enderecoMedico.clear();
        cpfMedico.clear();
        codigoMedico.clear();
    }

    private void clearPaciente(){
        nomePaciente.clear();
        enderecoPaciente.clear();
        cpfPaciente.clear();
        observacoesPaciente.clear();
    }

    private void clearConsulta(){
        consultaMedico.clear();
        consultaPaciente.clear();
        consultaDia.clear();
        consultaHora.clear();
    }

    public static void lerArquivos (){
        mRW = new LeituraEscrita<Medico>("src/Medicos.bin");
        mRW.lerDados(medicos);

        pRW = new LeituraEscrita<Paciente>("src/Pacientes.bin");
        pRW.lerDados(pacientes);

        cRW = new LeituraEscrita<Consultas>("src/Consultas.bin");
        cRW.lerDados(consultas);
    }

    public static void escreverArquivos (){
        mRW.escreverDados(medicos);
        pRW.escreverDados(pacientes);
        cRW.escreverDados(consultas);
    }

    private void alerta(String texto){
    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
    	alert.setContentText(texto);
    	alert.show();
	}

	private boolean alertaConfirm(String texto){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(texto);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            return true;
        }else
            return false;
    }
}
