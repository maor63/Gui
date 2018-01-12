package View.PackageDescriptionView;

import App.Package;
import App.Product;
import Main.ViewModel;
import View.UserViewScreen.ProductEntry;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class PackageDescriptionView implements Initializable{
    public TreeTableView<ProductEntry> packageTable;
    public TreeTableColumn colPackageId;
    public TreeTableColumn colProductId;
    public TreeTableColumn colCategory;
    public TreeTableColumn colAvailability;
    public TreeTableColumn colDescription;
    private ViewModel viewModel;
//    private ObservableList<ProductEntry> productEntries;

    List<ProductEntry> productEntries = Arrays.<ProductEntry>asList(
            new ProductEntry(new Product("mail",2,4,45,"cat")),
            new ProductEntry(new Product("mail",2,4,45,"cat")),
            new ProductEntry(new Product("mail",2,4,45,"cat")),
            new ProductEntry(new Product("mail",2,4,45,"cat")),
            new ProductEntry(new Product("mail",2,4,45,"cat")),
            new ProductEntry(new Product("mail",2,4,45,"cat")));


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Package p = new Package("mail", 4);
        ObservableList<Package> objects = FXCollections.observableArrayList();
        objects.add(p);

        TreeItem<ProductEntry> root =
                new TreeItem<>(new ProductEntry(new Product("email",2,4,45,"cat")));
        root.setExpanded(true);
        productEntries.forEach((productEntry) -> root.getChildren().add(new TreeItem<>(productEntry)));
        packageTable.setRoot(root);

    }

    public void setViewModel(ViewModel viewModel) {
        this.viewModel = viewModel;

    }
}
