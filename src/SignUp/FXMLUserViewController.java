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
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
        productEntries = FXCollections.observableArrayList();
        ObservableList<ProductEntry> userList = productEntries;
//        List<Package> packageList = viewModel.getPackagesOfUser();
//        for (Package pack : packageList) {
//            for (Product product : pack.getProducts()) {
//                ProductEntry productEntry = new ProductEntry(product);
//                userList.add(productEntry);
//            }
//        }
        product_table.setItems(userList);
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void loadUserData(User user) {
        if(this.user == null || (this.user != null && !this.user.email.equals(user.email))) {
            List<Package> packageList = viewModel.getPackagesOfUser();
            for (Package pack : packageList) {
                for (Product product : pack.getProducts()) {
                    ProductEntry productEntry = new ProductEntry(product);
                    productEntries.add(productEntry);
                }
            }
        }
    }
}
