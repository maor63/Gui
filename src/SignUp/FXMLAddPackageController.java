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
    public TextField Price;
    public TextField Category;
    private ViewModel viewModel;
    private User user;
    private Package aPackage;

    public void addNewProduct(MouseEvent mouseEvent) {
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

    public void addProduct(MouseEvent mouseEvent) {
        if(aPackage == null)
            aPackage = new Package(user.email, 0);
        Product product = new Product(user.email, 0, 0, Integer.parseInt(Price.getText()), Category.getText());
        aPackage.addProduct(product);
    }

    public void addNewPackage(MouseEvent mouseEvent) {
        viewModel.addPackage(aPackage);
        aPackage = null;
    }
}
