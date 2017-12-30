package SignUp.ProductDescriptionView;

import SignUp.ProductEntry;
import SignUp.ViewModel;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ProductViewController
{
    public Label searchable_name;
    public Label category;
    public Label address;
    public TextArea description;
    public Label price;
    public Label owner_email;
    private ViewModel viewModel;
    private Stage window;
    private int productID;
    private int packageID;

    public void closeWindow(MouseEvent mouseEvent) {
        window.close();
    }

    public void setDataFromRow(ProductEntry clickedRow) {
        productID = clickedRow.getProductID();
        packageID = clickedRow.getPackageID();
        category.setText(clickedRow.getCategory());
        description.setText(clickedRow.getDescription());
        price.setText(Integer.toString(clickedRow.getPrice()));
        owner_email.setText(clickedRow.getOwnerEmail());
    }

    public void deleteProduct(MouseEvent mouseEvent) {
        viewModel.deleteProduct(owner_email.getText(), packageID, productID);
        closeWindow(mouseEvent);
    }

    public void setViewModel(ViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public void setWindow(Stage window) {
        this.window = window;
    }
}
