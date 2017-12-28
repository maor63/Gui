/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SignUp;

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
public class JavaFX_BasicDetails extends Application {

    //init xy offsets
    private double xOffset = 0;
    private double yOffset = 0;
    private Scene signInScene;
    private Scene signUpScene;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader signUpLoader = new FXMLLoader(getClass().getResource("FXMLSignUp.fxml"));
        Parent signUpRoot = (Parent) signUpLoader.load();

        FXMLLoader signInLoader = new FXMLLoader(getClass().getResource("FXMLSignIn.fxml"));
        Parent signInRoot = (Parent) signInLoader.load();

        stage.initStyle(StageStyle.UNDECORATED);

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
        ViewModel vm = new ViewModel();
        Model model = new Model();
        vm.setModel(model);
        FXMLSignUpController controller = signUpLoader.getController();
        controller.setViewModel(this);

        FXMLSignInController signInController = signInLoader.getController();
        signInController.setViewModel(this);

        stage.setScene(signInScene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
