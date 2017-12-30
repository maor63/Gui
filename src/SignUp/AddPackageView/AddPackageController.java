package SignUp.AddPackageView;

import App.User;
import App.Package;
import SignUp.ViewModel;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AddPackageController
{
    public TextField cancellation_policy;
    public TextField address;

    private ViewModel viewModel;
    private User user;
    private Package aPackage;

    public void addNewProduct(MouseEvent mouseEvent) {
        viewModel.createNewPackage();
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

    public void setUser(User user) {
        this.user = user;
    }

    public void addNewPackage(MouseEvent mouseEvent) {
        viewModel.savePackage();
        viewModel.goToUserView();
    }

}
