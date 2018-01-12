package View.AddPackageView;

import App.User;
import App.Package;
import Main.ViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class AddPackageController
{
    public TextField cancellation_policy;
    public TextField address;
    @FXML
    private DatePicker start_date;
    @FXML
    private DatePicker end_date;


    @FXML
    ComboBox<String> package_cancelation_policiy;

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

        initCategories(viewModel);
    }

    private void initCategories(ViewModel viewModel) {
        ObservableList<String> packageCancelationPolicy = FXCollections.observableArrayList();
        List<String> allPolicies =  viewModel.getAllPackageCancelationPoliciy();
        packageCancelationPolicy.addAll(allPolicies);
        package_cancelation_policiy.setItems(packageCancelationPolicy);
        package_cancelation_policiy.getSelectionModel().selectFirst();
    }

    public void addNewPackage(MouseEvent mouseEvent) {
        viewModel.savePackage();
        viewModel.goToUserView();
    }
}
