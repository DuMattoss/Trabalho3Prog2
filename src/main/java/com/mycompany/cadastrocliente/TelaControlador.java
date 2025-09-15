package com.mycompany.cadastrocliente;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaControlador {
private ObservableList<Cliente> clientes = FXCollections.observableArrayList();
    private Buscador buscador;
   

    @FXML
    private TextField campoNome;
    @FXML
    private TextField campoCep;
    @FXML
    private TextField campoRua;
    @FXML
    private TextField campoCidade;
    @FXML
    private TextField campoTelefone;
    @FXML
    private TextField campoNumero;
    @FXML
    private TextField campoEstado;
 
    @FXML 
    private TableView<Cliente> tabelaClientes;

@FXML private TableColumn<Cliente, Integer> colunaCodigo;
@FXML private TableColumn<Cliente, String> colunaNome;
@FXML private TableColumn<Cliente, String> colunaCidade;
@FXML private TableColumn<Cliente, String> colunaEstado;
@FXML private TableColumn<Cliente, String> colunaTelefone;

@FXML

    private void initialize() {
        buscador = new Buscador();
         colunaCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
    colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    colunaCidade.setCellValueFactory(cellData ->
            new SimpleStringProperty(cellData.getValue().getEndereco().getCidade()));
    colunaEstado.setCellValueFactory(cellData ->
            new SimpleStringProperty(cellData.getValue().getEndereco().getEstado()));
    colunaTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
    tabelaClientes.setItems(clientes);
    }

    @FXML
    private void cadastrarCliente() {
        Cliente cliente = new Cliente();
        Endereco endereco = new Endereco();
        endereco.setCep(campoCep.getText());
        cliente.setNome(campoNome.getText());
        endereco.setRua(campoRua.getText());
        endereco.setCidade(campoCidade.getText());
        endereco.setEstado(campoEstado.getText());
        cliente.setEndereco(endereco);

        cliente.setTelefone(campoTelefone.getText());

        endereco.setNumero(campoNumero.getText());
        clientes.add(cliente);

        limparCampos();
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "cadastrado com sucesso");
        alert.show();
    }

    @FXML
    private void limparCampos() {
        campoNome.setText("");
        campoCep.setText("");
        campoRua.setText("");
        campoNumero.setText("");
        campoCidade.setText("");
        campoEstado.setText("");
        campoTelefone.setText("");
    }

    @FXML
    private void buscarCEP() throws IOException {
        System.out.println("Cliquei no botão Buscar");
        String cep = campoCep.getText();
        Buscador buscador = new Buscador();
        try {
            Endereco endereco = buscador.buscar(cep);
            campoRua.setText(endereco.getRua());
            campoCidade.setText(endereco.getCidade());
            campoEstado.setText(endereco.getEstado());
            campoNumero.setText(endereco.getNumero());
        } catch (IllegalArgumentException e) {
            System.out.println("formato cep invalido");
            Alert alert = new Alert(Alert.AlertType.ERROR, "Formato de CEP inválido!");
            alert.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
            alert.show();
        } finally {
            System.out.println("ex finally");
        }
    }
}