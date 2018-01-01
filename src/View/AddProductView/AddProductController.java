package View.AddProductView;

import App.User;
import Main.ViewModel;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AddProductController
{

    public TextField Price;
    public TextField Category;
    public TextField description;
    private ViewModel viewModel;
    private User user;

    public void setViewModel(ViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public void addProduct(MouseEvent mouseEvent) {
        viewModel.addProductToPackage(Integer.parseInt(Price.getText()), Category.getText(), description.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("New product add to package");
        alert.showAndWait();
        Price.setText("");
        Category.setText("");
        description.setText("");
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
