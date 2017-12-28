package SignUp;

import App.User;
import DB.SqliteDB;

public class Model {

    private final SqliteDB db;

    public Model() {
        this.db = new SqliteDB();
        db.connectToDB("myDB.db",false);
    }

    public void addUser(User user) {
        db.addUser(user);
    }
}
