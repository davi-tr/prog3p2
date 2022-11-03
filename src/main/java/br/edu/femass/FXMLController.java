package br.edu.femass;

import java.net.URL;
import java.util.ResourceBundle;

import java.util.List;
import br.edu.femass.dao.Dao;
import br.edu.femass.dao.DaoCLiente;
import br.edu.femass.model.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class FXMLController implements Initializable {
    
    @FXML
    private TextField TxtNome;
    
    @FXML
    private TextField TxtEndereco;

    @FXML
    private ListView<Cliente> LstClientes;

    @FXML
    private Button BtnSalvar;

    @FXML
    private Button BtnIncluir;

    @FXML
    private Button BtnAlterar;
    
    @FXML
    private Button BtnExcluir;

    private DaoCLiente dao = new DaoCLiente();
    private Cliente cliente;
    private Boolean incluindo;

    @FXML
    private void Gravar_Click(ActionEvent event) {
        cliente.setNome(TxtNome.getText());
        cliente.setEndereco(TxtEndereco.getText());

        if(incluindo){
            dao.inserir(cliente);
        } else{
            dao.alterar(cliente);
        }

        preencherLista();
        editar(false);
    }
    
    @FXML
    private void altera_click(ActionEvent event) {
        editar(true);
        incluindo = true;
    }

    @FXML
    private void incluir_click(ActionEvent event) {
        editar(true);
        incluindo = true;
        cliente =  new Cliente();
        TxtEndereco.setText("");
        TxtNome.setText("");
        TxtNome.requestFocus();
    }

    @FXML
    private void excluir_click(ActionEvent event) {
        dao.apagar(cliente);
        preencherLista();
    }
    
    @FXML
    private void keyPressed_teclaSelecionada(KeyEvent event){
        exibirDados();
    }

    @FXML
    private void valor_Selecionado(MouseEvent event){
        exibirDados();
    }

    private void editar(boolean habilitar){
        LstClientes.setDisable(habilitar);
        TxtEndereco.setDisable(!habilitar);
        TxtNome.setDisable(!habilitar);
        BtnSalvar.setDisable(!habilitar);
        BtnAlterar.setDisable(habilitar);
        BtnIncluir.setDisable(habilitar);
        BtnExcluir.setDisable(habilitar);
    }
    
    private void exibirDados(){
        this.cliente =  LstClientes.getSelectionModel().getSelectedItem();
        if(cliente == null) return;

        TxtNome.setText(cliente.getNome());
        TxtEndereco.setText(cliente.getEndereco());
    }

    private void preencherLista(){
        List<Cliente> clientes = dao.buscarTodos();

        ObservableList<Cliente> data =  FXCollections.observableList(clientes);
        LstClientes.setItems(data);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        preencherLista();
    }    
}
