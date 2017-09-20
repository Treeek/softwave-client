package br.net.softwave.client.controller;

import awesomeui.animation.FadeOutTransition;
import awesomeui.animation.ShakeTransition;
import br.net.softwave.client.domain.Credenciais;
import br.net.softwave.client.util.Screen;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
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
     * Esse método é responsável por validar o prontuário e senha através de uma
     * requesição http ao servidor, que retornará se os dados inseridos existem
     * ou não. Caso o usuário exista, o mesmo será redirecionado para a tela
     * principal, caso contrário, será exibida uma mensagem de informação
     * inválida na tela de login
     */
    @FXML
    private void entrarNaTelaPrincipal() {
        if ((campoProntuario.getText() != null && !campoProntuario.getText().isEmpty()) && (campoSenha.getText() != null && !campoSenha.getText().isEmpty())) {
            if (campoProntuario.getText().length() == 7) {
                Client cliente;
                WebResource webResource;
                ClientResponse resposta = null;
                Credenciais credenciais = new Credenciais(campoProntuario.getText(), campoSenha.getText());
                System.out.println(credenciais);

                try {
                    cliente = Client.create();
                    webResource = cliente.resource(br.net.softwave.client.Client.ENDERECO_LOGIN);
                    resposta = webResource
                            .type(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON)
                            .post(ClientResponse.class, credenciais);

                    if (resposta.getStatus() == ClientResponse.Status.OK.getStatusCode()) {
                        new FadeOutTransition(vBox)
                                .setDuration(Duration.seconds(1))
                                .setOnFinish((event) -> {
                                    try {
                                        Screen.mainScene((Stage) vBox.getScene().getWindow());
                                    } catch (IOException ex) {
                                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                })
                                .play();
                    } else if (resposta.getStatus() == ClientResponse.Status.NO_CONTENT.getStatusCode()) {
                        new ShakeTransition(vBox)
                                .setDuration(Duration.millis(500))
                                .setOnFinish((event) -> {
                                    rotuloErro.setText("Usuário ou senha incorretos");
                                })
                                .play();
                    } else {
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
