package View.SearchView;

import View.AbstractController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SearchViewController extends AbstractController {

    public DatePicker start_date;
    public DatePicker end_date;
    public TextField City;
    public ComboBox Categories;
    public TextField Neighborhood;
    public TextField Street;

    public void serachProducts(MouseEvent mouseEvent) {
        if(inValidInput())
        {
            showMessage("Invalid input");
            return;
        }

        Set setA = new HashSet();

        LocalDate startDateValue = start_date.getValue();
        LocalDate endDateValue = end_date.getValue();
        String category = Categories.getSelectionModel().getSelectedItem().toString();
//        viewModel.searchPackagesBy(startDateValue, endDateValue);
        viewModel.getPackagesByCategory(category);
    }

    private boolean inValidInput() {
        return start_date == null || end_date == null;
    }

    private void showMessage(String message)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText(message);

        alert.showAndWait();
    }

    public void showCategories(MouseEvent mouseEvent) {
        ObservableList<String> categoriesOptions = FXCollections.observableArrayList();
        List<String> allCategories =  viewModel.getAllCategories();
        categoriesOptions.addAll(allCategories);
        Categories.setItems(categoriesOptions);
        Categories.getSelectionModel().selectFirst();
    }

    public void goToLogIn(MouseEvent mouseEvent) {
        viewModel.goToSignIn();
    }
}
