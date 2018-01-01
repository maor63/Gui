/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import App.Package;
import App.Product;
import App.User;
import Model.Model;
import View.AddPackageView.AddPackageController;
import View.AddProductView.AddProductController;
import View.SignInScreenView.SignInController;
import View.SignUpScreenView.SignUpController;
import View.UserViewScreen.ProductEntry;
import View.UserViewScreen.UserViewController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author proxc
 */
public class ViewModel extends Application
{

    //init xy offsets
    private double xOffset = 0;
    private double yOffset = 0;
    private Scene signInScene;
    private Scene signUpScene;
    private Model model;
    private Stage stage;
    private Scene userViewScene;
    private Scene addPackageScene;
    private AddPackageController addPackageController;
    private UserViewController userViewController;
    private AddProductController addProductLoaderController;
    private Scene addProductScene;
    private User user;
    private Package aPackage;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader signUpLoader = new FXMLLoader(getClass().getResource("../View/SignUpScreenView/SignUpScreen.fxml"));
        Parent signUpRoot = (Parent) signUpLoader.load();

        FXMLLoader signInLoader = new FXMLLoader(getClass().getResource("../View/SignInScreenView/SignInScreen.fxml"));
        Parent signInRoot = (Parent) signInLoader.load();

        FXMLLoader userViewLoader = new FXMLLoader(getClass().getResource("../View/UserViewScreen/UserView.fxml"));
        Parent userViewRoot = (Parent) userViewLoader.load();

        FXMLLoader addPackageLoader = new FXMLLoader(getClass().getResource("../View/AddPackageView/AddPackage.fxml"));
        Parent addPackageRoot = (Parent) addPackageLoader.load();

        FXMLLoader addProductLoader = new FXMLLoader(getClass().getResource("../View/AddProductView/AddProduct.fxml"));
        Parent addProductRoot = (Parent) addProductLoader.load();

        this.stage = stage;
        this.stage.initStyle(StageStyle.UNDECORATED);

        //set mouse pressed
        setDraggable(stage, signUpRoot);
        setDraggable(stage, signInRoot);
        setDraggable(stage, userViewRoot);
        setDraggable(stage, addPackageRoot);
        setDraggable(stage, addProductRoot);

        signUpScene = new Scene(signUpRoot);
        signInScene = new Scene(signInRoot);
        userViewScene = new Scene(userViewRoot);
        addPackageScene = new Scene(addPackageRoot);
        addProductScene = new Scene(addProductRoot);
        Model model = new Model();
        setModel(model);
        SignUpController controller = signUpLoader.getController();
        controller.setViewModel(this);

        SignInController signInController = signInLoader.getController();
        signInController.setViewModel(this);

        userViewController = userViewLoader.getController();
        userViewController.setViewModel(this);

        addPackageController = addPackageLoader.getController();
        addPackageController.setViewModel(this);

        addProductLoaderController = addProductLoader.getController();
        addProductLoaderController.setViewModel(this);


        stage.setScene(signInScene);
        stage.show();
    }

    public void setDraggable(Stage stage, Parent parent) {
        parent.setOnMousePressed(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        //set mouse drag
        parent.setOnMouseDragged(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        });
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
    }

    public void goToSignIn() {
        stage.setScene(signInScene);
    }

    public Boolean isUserExists(User u) {
        return model.isUserExists(u);
    }

    public void goToUserView() {
        userViewController.loadUserData(user);
        userViewController.setUser(user);
        stage.setScene(userViewScene);
    }

    public void goToAddPackage() {
        stage.setScene(addPackageScene);
    }

    public void goToAddProduct() {
        stage.setScene(addProductScene);
    }

    public void addPackage(Package aPackage) {
        model.addPackage(aPackage);
    }

    public void createNewPackage(String address, String cancellation_policy) {
        aPackage = new Package(user.email, 0);
        aPackage.setAddress(address);
        aPackage.setCancellation_policy(cancellation_policy);
    }

    public void addProductToPackage(int price, String categoryText, String description) {
        Product product = new Product(user.email, 0, 0, price, categoryText);
        product.description = description;
        aPackage.addProduct(product);
    }

    public void savePackage() {
        if (aPackage != null && aPackage.getProducts().size() > 0) {
            model.addPackage(aPackage);
            userViewController.addToTable(aPackage);
        }
        aPackage = null;
    }

    public void loadUser(User u) {
        user = u;
    }

    public List<Package> getPackagesOfUser() {
        return model.getUserPackages(user.email);
    }

    public Boolean loadUser(String email, String pass) {
        User u = new User(email, pass);
        if (model.isUserExists(u)) {
            user = model.loadUser(u);
            return true;
        }
        return false;

    }

    public void discartPackage() {
        aPackage = null;
    }

    public void deleteProduct(String owner_emailText, int packageID, int productID) {
        if(aPackage != null) {
            List<Product> products = new ArrayList<>(aPackage.getProducts());
            for (int i = 0; i < products.size(); i++) {
                Product p = products.get(i);
                if (p.ownerEmail.equals(owner_emailText) && p.packageID == packageID && p.productID == productID) {
                    aPackage.getProducts().remove(i);
                    break;
                }
            }
        }
        model.deleteProduct(owner_emailText, packageID, productID);
        userViewController.deleteProductFromTable(owner_emailText, packageID, productID);
    }

    public void updateProduct(Product prod, String address) {
        Package pack = model.getPackage(prod.ownerEmail, prod.packageID);
        model.deletePackage(pack);
        pack.setAddress(address);
        for (Product p : pack.getProducts()) {
            if(p.productID == prod.productID)
            {
                p.price = prod.price;
                p.category = prod.category;
                p.description = prod.description;
            }
        }
        model.addPackage(pack);
        userViewController.deletePackageFromTable(pack);
        userViewController.addToTable(pack);
    }
}
