package View.SearchView;

import View.AbstractController;
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
        LocalDate startDateValue = start_date.getValue();
        LocalDate endDateValue = end_date.getValue();
        viewModel.searchPackagesBy(startDateValue, endDateValue);
    }
}
