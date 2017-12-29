package SignUp;

import App.Product;
import App.User;
import App.Package;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class FXMLUserViewController implements Initializable
{
    public TableView<ProductEntry> product_table;
    public TableColumn<ProductEntry, Integer> colPrice;
    public TableColumn<ProductEntry, Integer> colPackageId;
    public TableColumn<ProductEntry, Integer> colProductId;
    public TableColumn<ProductEntry, Integer> colCategory;
    public TableColumn<ProductEntry, Integer> colAvailability;
    public TableColumn<ProductEntry, Integer> colDescription;
    private ViewModel viewModel;
    private ObservableList<ProductEntry> productEntries;
    private User user;

    public void addPackage(MouseEvent mouseEvent) {
        viewModel.goToAddPackage();
    }

    public void setViewModel(ViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        colProductId.setCellValueFactory(new PropertyValueFactory<>("productID"));
        colPackageId.setCellValueFactory(new PropertyValueFactory<>("packageID"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));

        productEntries = FXCollections.observableArrayList();

        product_table.setRowFactory(tv -> {
            TableRow<ProductEntry> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {

                    ProductEntry clickedRow = row.getItem();
                    System.out.println("double click");
                }
            });
            return row;
        });
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void loadUserData(User user) {
        product_table.setItems(FXCollections.observableArrayList());
        productEntries = FXCollections.observableArrayList();
        List<Package> packageList = viewModel.getPackagesOfUser();
        for (Package pack : packageList) {
            addPackageToTable(pack);
        }
        product_table.setItems(productEntries);
    }


    private void addPackageToTable(Package pack) {
        for (Product product : pack.getProducts()) {
            ProductEntry productEntry = new ProductEntry(product);
            productEntries.add(productEntry);
        }
    }

    public void addToTable(Package aPackage) {
        System.out.println("add to table");
        addPackageToTable(aPackage);
    }

    public void signOut(MouseEvent mouseEvent) {
        this.user = null;
        productEntries = FXCollections.observableArrayList();
        product_table.setItems(productEntries);
        viewModel.goToSignIn();
    }
}
