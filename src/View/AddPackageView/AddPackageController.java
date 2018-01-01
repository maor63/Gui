package View.AddPackageView;

import App.User;
import App.Package;
import Main.ViewModel;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AddPackageController
{
    public TextField cancellation_policy;
    public TextField address;

    private ViewModel viewModel;

    public void addNewProduct(MouseEvent mouseEvent) {
        viewModel.createNewPackage(address.getText(), cancellation_policy.getText());
        viewModel.goToAddProduct();
        System.out.println("Adding new Package");
    }

    public void quitOption(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void goToUserView(MouseEvent mouseEvent) {
        viewModel.discartPackage();
        viewModel.goToUserView();
    }

    public void setViewModel(ViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public void addNewPackage(MouseEvent mouseEvent) {
        viewModel.savePackage();
        viewModel.goToUserView();
    }

}
