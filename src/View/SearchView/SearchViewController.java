package View.SearchView;

import App.Package;
import View.AbstractController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.time.LocalDate;
import java.util.*;

public class SearchViewController extends AbstractController {

    public DatePicker start_date;
    public DatePicker end_date;
    public TextField City;
    public ComboBox Categories;
    public TextField Neighborhood;
    public TextField Street;

    public void serachProducts(MouseEvent mouseEvent) {
        if (inValidInput()) {
            showMessage("Invalid input");
            return;
        }

        List<Package> listAddress = new ArrayList<>();
        List<Package> listDate = new ArrayList<>();
        List<Package> listCategories = new ArrayList<>();
        List<Package> packages = new ArrayList<>();

        if (City != null && Neighborhood != null && Street != null) {
            String city = City.getText();
            String neighborhood = Neighborhood.getText();
            String street = Street.getText();

            listAddress = viewModel.getPackagesByAddress(city, neighborhood, street);

            packages = listAddress;
        }

        if (start_date != null && end_date != null) {
            LocalDate startDateValue = start_date.getValue();
            LocalDate endDateValue = end_date.getValue();

            listDate = viewModel.searchPackagesByDate(startDateValue, endDateValue);

            packages = listDate;

        }

        if (Categories != null) {
            String category = Categories.getSelectionModel().getSelectedItem().toString();

            listCategories = viewModel.getPackagesByCategory(category);

            packages = listCategories;

        }

        if (listAddress.size() > 0)
            packages = intersect(packages, listAddress);
        if (listDate.size() > 0)
            packages = intersect(packages, listDate);
        if (listCategories.size() > 0)
            packages = intersect(packages, listCategories);

        viewModel.searchPackagesBy(packages);

//        viewModel.searchPackagesByDate(startDateValue, endDateValue);
//        viewModel.getPackagesByCategory(category);
//        viewModel.getPackagesByAddress(city, neighborhood, street);
    }

    private List<Package> intersect(List<Package> A, List<Package> B) {
        List<Package> rtnList = new LinkedList<>();
        for(Package a : A) {
            for(Package b : B) {
                if (a.getPackage_id() == b.getPackage_id())
                {
                    rtnList.add(b);
                    break;
                }
            }
        }
        return rtnList;
    }

    private boolean inValidInput() {
        return start_date == null || end_date == null;
    }

    private void showMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText(message);

        alert.showAndWait();
    }

    public void showCategories(MouseEvent mouseEvent) {
        ObservableList<String> categoriesOptions = FXCollections.observableArrayList();
        List<String> allCategories = viewModel.getAllCategories();
        categoriesOptions.addAll(allCategories);
        Categories.setItems(categoriesOptions);
        Categories.getSelectionModel().selectFirst();
    }

    public void goToLogIn(MouseEvent mouseEvent) {
        viewModel.goToSignIn();
    }
}
