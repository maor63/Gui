package SignUp;

import App.Product;
import App.User;
import App.Package;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class FXMLAddPackageController {
    public TextField cancellation_policy;
    public TextField address;

    private ViewModel viewModel;
    private User user;
    private Package aPackage;

    public void addNewProduct(MouseEvent mouseEvent) {
        viewModel.createNewPackage();
        viewModel.goToAddProduct(user);
    }

    public void quitOption(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void goToUserView(MouseEvent mouseEvent) {
        viewModel.goToUserView(user);
    }

    public void setViewModel(ViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addNewPackage(MouseEvent mouseEvent) {
        viewModel.savePackage();
        viewModel.goToUserView(user);
    }

}
