package View.PackageDescriptionView;

import App.Package;
import App.Product;
import Main.ViewModel;
import View.UserViewScreen.ProductEntry;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class PackageDescriptionView implements Initializable{
    public TreeTableView<ProductEntry> packageTable;
    public TreeTableColumn<ProductEntry, String> colPackageId;
    public TreeTableColumn<ProductEntry, String> colProductId;
    public TreeTableColumn<ProductEntry, String> colCategory;
    public TreeTableColumn<ProductEntry, String> colAvailability;
    public TreeTableColumn<ProductEntry, String> colDescription;
    public TreeTableColumn<ProductEntry, String> colPrice;
    private ViewModel viewModel;
    private TreeItem<ProductEntry> root;
    //    private ObservableList<ProductEntry> productEntries;

//    List<ProductEntry> productEntries = Arrays.<ProductEntry>asList(
//            new ProductEntry(new Product("mail",2,4,45,"cat")),
//            new ProductEntry(new Product("mail",2,4,45,"cat")),
//            new ProductEntry(new Product("mail",2,4,45,"cat")),
//            new ProductEntry(new Product("mail",2,4,45,"cat")),
//            new ProductEntry(new Product("mail",2,4,45,"cat")),
//            new ProductEntry(new Product("mail",2,4,45,"cat")));


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colPackageId.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<ProductEntry, String> param) ->
                        new ReadOnlyStringWrapper(Integer.toString(param.getValue().getValue().getPackageID()))
        );

        colProductId.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<ProductEntry, String> param) ->
                        new ReadOnlyStringWrapper(Integer.toString(param.getValue().getValue().getProductID()))
        );

        colPrice.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<ProductEntry, String> param) ->
                        new ReadOnlyStringWrapper(Integer.toString(param.getValue().getValue().getPrice()))
        );

        colCategory.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<ProductEntry, String> param) ->
                        new ReadOnlyStringWrapper(param.getValue().getValue().getCategory())
        );

        colDescription.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<ProductEntry, String> param) ->
                        new ReadOnlyStringWrapper(param.getValue().getValue().getDescription())
        );

        root = new TreeItem<>(new ProductEntry());
//        root.setExpanded(true);
//        productEntries.forEach((productEntry) -> root.getChildren().add(new TreeItem<>(productEntry)));
        packageTable.setRoot(root);
        packageTable.setShowRoot(false);

    }

    public void setViewModel(ViewModel viewModel) {
        this.viewModel = viewModel;

    }

    public void addPackagesToTable(List<Package> packages){
        for (Package p: packages) {
            root.getChildren().add(addPackageToTable(p));
        }
    }

    public void showUserPackages()
    {
        addPackagesToTable(viewModel.getPackagesOfUser());
    }

    private TreeItem<ProductEntry> addPackageToTable(Package pack) {
        ProductEntry packageRoot = new ProductEntry();
        packageRoot.setPackageID(pack.getPackage_id());
        packageRoot.setPrice(pack.getTotal_price());
        TreeItem<ProductEntry> root = new TreeItem<>(packageRoot);
        for (Product product : pack.getProducts()) {
            ProductEntry productEntry = new ProductEntry(product);
            productEntry.setAvailability("All week");
            productEntry.setAddress(pack.getAddress());
            root.getChildren().add(new TreeItem<>(productEntry));
        }
        return root;
    }
}
