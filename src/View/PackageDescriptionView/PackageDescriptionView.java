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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;

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
    public TreeTableColumn<ProductEntry, String> colDescription;
    public TreeTableColumn<ProductEntry, String> colPrice;
    public TreeTableColumn<ProductEntry, String> colStartDate;
    public TreeTableColumn<ProductEntry, String> colEndDate;
    public TreeTableColumn<ProductEntry, String> colOwnerEmail;
    private ViewModel viewModel;
    private TreeItem<ProductEntry> root;


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

        colStartDate.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<ProductEntry, String> param) ->
                        new ReadOnlyStringWrapper(param.getValue().getValue().getStartDate())
        );

        colEndDate.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<ProductEntry, String> param) ->
                        new ReadOnlyStringWrapper(param.getValue().getValue().getEndDate())
        );

        colOwnerEmail.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<ProductEntry, String> param) ->
                        new ReadOnlyStringWrapper(param.getValue().getValue().getOwnerEmail())
        );

        packageTable.setRowFactory(tv -> {
            TreeTableRow<ProductEntry> row = new TreeTableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
                    System.out.println("double clicked");
//                    ProductEntry clickedRow = row.getItem();
//                    showProduct(clickedRow);
                }
                else if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) {
                    System.out.println("one clicked");
//                    ProductEntry clickedRow = row.getItem();
//                    showProduct(clickedRow);
                }

            });
            return row;
        });

        root = new TreeItem<>(new ProductEntry());
//        root.setExpanded(true);
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
        packageRoot.setOwnerEmail(pack.getOwner_email());
        packageRoot.setPackageID(pack.getPackage_id());
        packageRoot.setPrice(pack.getTotal_price());
        packageRoot.setStartDate(pack.getStartDateString());
        packageRoot.setEndDate(pack.getEndDateString());
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
