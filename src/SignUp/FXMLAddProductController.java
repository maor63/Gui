package SignUp;

import App.User;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class FXMLAddProductController {

    public TextField Price;
    public TextField Category;
    private ViewModel viewModel;
    private User user;

    public void setViewModel(ViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public void addProduct(MouseEvent mouseEvent) {
        viewModel.addProductToPackage(Integer.parseInt(Price.getText()), Category.getText());
        System.out.println("product added");
        Price.setText("");
        Category.setText("");
    }


    public void goToPackageView(MouseEvent mouseEvent) {
        viewModel.goToAddPackage();
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void quitOption(ActionEvent actionEvent) {
        System.exit(0);
    }
}
