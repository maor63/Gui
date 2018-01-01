package View.ProductDescriptionView;

import App.Product;
import View.UserViewScreen.ProductEntry;
import Main.ViewModel;
import com.jfoenix.controls.JFXButton;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ProductViewController
{
    public TextField category;
    public TextField address;
    public TextArea  description;
    public TextField price;
    public Label owner_email;
    public JFXButton delete_btn;
    public JFXButton update_btn;
    public JFXButton save_changes_btn;
    public TextField availability;
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
        address.setText(clickedRow.getAddress());
        availability.setText(clickedRow.getAvailability());
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

    public void updateProduct(MouseEvent mouseEvent) {
        delete_btn.setDisable(true);
        save_changes_btn.setDisable(false);
        category.setEditable(true);
        address.setEditable(true);
        description.setEditable(true);
        price.setEditable(true);
    }

    public void saveChanges(MouseEvent mouseEvent) {
        Product prod = new Product(owner_email.getText(), productID, packageID,Integer.parseInt(price.getText()),category.getText());
        prod.description = description.getText();
        viewModel.updateProduct(prod, address.getText());
        delete_btn.setDisable(false);
        save_changes_btn.setDisable(true);
        category.setEditable(false);
        address.setEditable(false);
        description.setEditable(false);
        price.setEditable(false);
    }
}
