package View.AddPackageView;

import Main.ViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class AddPackageController
{
    public TextField address;
    @FXML
    private DatePicker start_date;
    @FXML
    private DatePicker end_date;


    @FXML
    ComboBox<String> package_cancelation_policiy;

    private ViewModel viewModel;

    public void addNewProduct(MouseEvent mouseEvent) {
        String cancellationPolicy = package_cancelation_policiy.getValue();
        viewModel.createNewPackage(address.getText(), cancellationPolicy);
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

        initCancellationPolicy(viewModel);
    }

    private void initCancellationPolicy(ViewModel viewModel) {
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
