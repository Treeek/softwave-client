package br.net.softwave.client.controller;

import awesomeui.animation.ShakeTransition;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import javax.ws.rs.core.MediaType;

public class LoginController implements Initializable {

    @FXML
    private VBox vBox;
    @FXML
    private JFXTextField campoProntuario;
    @FXML
    private JFXPasswordField campoSenha;
    @FXML
    private Label rotuloErro;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO: implementar a máscara nos campos
    }
    
    /**
     * Valida usuário e entra na tela principal.
     * <p>
     * Esse método é responsável por validar o prontuário e senha
     * através de uma requesição http ao servidor, que retornará se
     * os dados inseridos existem ou não. Caso o usuário exista,
     * o mesmo será redirecionado para a tela principal, caso contrário,
     * será exibida uma mensagem de informação inválida na tela de login
     */
    
    @FXML
    private void entrarNaTelaPrincipal() {
        if ((campoProntuario.getText() != null && !campoProntuario.getText().isEmpty()) && (campoSenha.getText() != null && !campoSenha.getText().isEmpty())) {
            if (campoProntuario.getText().length() == 7) {
                Client cliente;
                WebResource webResource;
                ClientResponse resposta = null;
                
                try {
                    cliente = Client.create();
                    webResource = cliente.resource(br.net.softwave.client.Client.ENDERECO_API_TEST);
                    resposta = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

                    switch (resposta.getStatus()) {
                        case 200:
                            System.out.println(resposta.getEntity(String.class));
                            break;
                        case 204:
                            new ShakeTransition(vBox)
                                    .setDuration(Duration.millis(500))
                                    .setOnFinish((event) -> {
                                        rotuloErro.setText("Usuário ou senha incorretos");
                                    })
                                    .play();
                            break;
                        default:
                            new ShakeTransition(vBox)
                                    .setDuration(Duration.millis(500))
                                    .setOnFinish((event) -> {
                                        rotuloErro.setText("Ops! Estou tendo problemas internos");
                                    })
                                    .play();
                    }
                } catch (ClientHandlerException | UniformInterfaceException erro) {
                    System.out.println(String.format("[%s]: %s \nCausa: %s", "requesição de login", erro.getMessage(), erro.getCause()));
                    erro.printStackTrace();
                } finally {
                    if (resposta != null) {
                        resposta.close();
                    }
                }
            } else {
                new ShakeTransition(vBox)
                        .setDuration(Duration.millis(500))
                        .setOnFinish((event) -> {
                            rotuloErro.setText("O prontuário deve conter mais de 7 caracteres");
                        })
                        .play();
            }
        } else {
            new ShakeTransition(vBox)
                    .setDuration(Duration.millis(500))
                    .setOnFinish((event) -> {
                        rotuloErro.setText("Os campos necessitam serem preenchidos!");
                    })
                    .play();
        }
    }
    
}
