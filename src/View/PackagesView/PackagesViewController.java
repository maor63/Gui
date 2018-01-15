package View.PackagesView;

import App.User;
import Main.ViewModel;
import View.PackagesView.PackageEntry;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class PackagesViewController extends View.AbstractController implements Initializable
{
    public TableView<PackageEntry> packages_table;
    public TableColumn<PackageEntry, Integer> colTotalPrice;
    public TableColumn<PackageEntry, Integer> colOwnerEmail;
    public TableColumn<PackageEntry, Integer> colAttitude;
    public TableColumn<PackageEntry, Integer> colAvailability;
    public TableColumn<PackageEntry, Integer> colDescription;
    private ObservableList<PackageEntry> packageEntries;
    private User user;
    private Stage window;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        colTotalPrice.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
        colOwnerEmail.setCellValueFactory(new PropertyValueFactory<>("ownerEmail"));
        colAttitude.setCellValueFactory(new PropertyValueFactory<>("attitude"));
        colAvailability.setCellValueFactory(new PropertyValueFactory<>("availability"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));

        packageEntries = FXCollections.observableArrayList();


    }

    public void setWindow(Stage window) {
        this.window = window;
    }

    public void closeWindow(MouseEvent mouseEvent) {
        window.close();
    }

    public void lendPackage(){

    }

    public void switchPackage(){

    }

}
