package SignUp;

import App.User;

public class ViewModel {
    private Model model;

    public ViewModel() {

    }

    public void addUser(User user) {
        System.out.println("add user");
        model.addUser(user);
    }

    public void setModel(Model model) {
        this.model = model;
    }
}
