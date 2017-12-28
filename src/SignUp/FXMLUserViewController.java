package SignUp;

import App.User;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class FXMLUserViewController {
    public TableView tableAttendance;
    public TableColumn colEmpID;
    public TableColumn colNames;
    public TableColumn colJob;
    private ViewModel viewModel;
    private User user;

    public void addPackage(MouseEvent mouseEvent) {
        viewModel.goToAddPackage(user);
    }

    public void setViewModel(ViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
