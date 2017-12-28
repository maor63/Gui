/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SignUp;

import App.Package;
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
    private Scene userViewScene;
    private Scene addPackageScene;
    private FXMLAddPackageController addPackageController;
    private FXMLUserViewController userViewController;
    private Scene addProductScene;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader signUpLoader = new FXMLLoader(getClass().getResource("FXMLSignUp.fxml"));
        Parent signUpRoot = (Parent) signUpLoader.load();

        FXMLLoader signInLoader = new FXMLLoader(getClass().getResource("FXMLSignIn.fxml"));
        Parent signInRoot = (Parent) signInLoader.load();

        FXMLLoader userViewLoader = new FXMLLoader(getClass().getResource("FXMLUserView.fxml"));
        Parent userViewRoot = (Parent) userViewLoader.load();

        FXMLLoader addPackageLoader = new FXMLLoader(getClass().getResource("FXMLAddPackage.fxml"));
        Parent addPackageRoot = (Parent) addPackageLoader.load();

        FXMLLoader addProductLoader = new FXMLLoader(getClass().getResource("FXMLAddProduct.fxml"));
        Parent addProductRoot = (Parent) addProductLoader.load();

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

        signUpScene = new Scene(signUpRoot);
        signInScene = new Scene(signInRoot);
        userViewScene = new Scene(userViewRoot);
        addPackageScene = new Scene(addPackageRoot);
        addProductScene = new Scene(addProductRoot);
        Model model = new Model();
        setModel(model);
        FXMLSignUpController controller = signUpLoader.getController();
        controller.setViewModel(this);

        FXMLSignInController signInController = signInLoader.getController();
        signInController.setViewModel(this);

        userViewController = userViewLoader.getController();
        userViewController.setViewModel(this);

        addPackageController = addPackageLoader.getController();
        addPackageController.setViewModel(this);

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

    public Boolean isUserExists(User u) {
        return model.isUserExists(u);
    }

    public void goToUserView(User user) {
        if(isUserExists(user)) {
            userViewController.setUser(user);
            stage.setScene(userViewScene);
        }

    }

    public void goToAddPackage(User user) {
        addPackageController.setUser(user);
        stage.setScene(addPackageScene);
    }

    public void goToAddProduct(User user) {
        addPackageController.setUser(user);
        stage.setScene(addProductScene);
    }

    public void addPackage(Package aPackage) {
        model.addPackage(aPackage);
    }
}
