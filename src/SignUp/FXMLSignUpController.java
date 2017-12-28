package SignUp;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;

import App.User;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author proxc
 */
public class FXMLSignUpController implements Initializable {

    @FXML
    private Label btn_exit;
    public JFXTextField first_name;
    public JFXPasswordField password;
    public JFXTextField last_name;
    public JFXTextField email;
    public JFXButton btn_add_user;

    private ViewModel viewModel;

    @FXML
    private void exitApp(MouseEvent event) {
      System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void handleAddUser(MouseEvent mouseEvent) {
        User u = new User(first_name.getText(),last_name.getText(), password.getText(), email.getText());
        viewModel.isUserExists(u);
        viewModel.addUser(u);
    }

    public void setViewModel(ViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public void goToSignIn(MouseEvent mouseEvent) {
        viewModel.goToSignIn();
    }
}
