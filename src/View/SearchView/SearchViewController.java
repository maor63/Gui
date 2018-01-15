package View.SearchView;

import View.AbstractController;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.time.LocalDate;

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

        LocalDate startDateValue = start_date.getValue();
        LocalDate endDateValue = end_date.getValue();
        viewModel.searchPackagesBy(startDateValue, endDateValue);
    }

    private boolean inValidInput() {
        return start_date == null || end_date == null || City.getText().isEmpty();
    }

    private void showMessage(String message)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText(message);

        alert.showAndWait();
    }
}
