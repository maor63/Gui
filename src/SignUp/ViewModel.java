/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SignUp;

import App.User;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author proxc
 */
public class ViewModel extends Application {

    //init xy offsets
    private double xOffset = 0;
    private double yOffset = 0;
    private Scene signInScene;
    private Scene signUpScene;
    private Model model;
    private Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader signUpLoader = new FXMLLoader(getClass().getResource("FXMLSignUp.fxml"));
        Parent signUpRoot = (Parent) signUpLoader.load();

        FXMLLoader signInLoader = new FXMLLoader(getClass().getResource("FXMLSignIn.fxml"));
        Parent signInRoot = (Parent) signInLoader.load();

        this.stage = stage;
        this.stage.initStyle(StageStyle.UNDECORATED);

        //set mouse pressed
        signUpRoot.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        //set mouse drag
        signUpRoot.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        });

        this.signUpScene = new Scene(signUpRoot);
        this.signInScene = new Scene(signInRoot);
        Model model = new Model();
        setModel(model);
        FXMLSignUpController controller = signUpLoader.getController();
        controller.setViewModel(this);

        FXMLSignInController signInController = signInLoader.getController();
        signInController.setViewModel(this);

        stage.setScene(signInScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void goToSignUp() {
        stage.setScene(signUpScene);
    }

    public void addUser(User u) {
        model.addUser(u);
        goToSignIn();
    }

    public void goToSignIn() {
        stage.setScene(signInScene);
    }
}
