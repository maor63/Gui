package SignUp;

import App.Package;
import App.User;
import DB.SqliteDB;

import java.util.List;

public class Model {

    private final SqliteDB db;

    public Model() {
        this.db = new SqliteDB();
        db.connectToDB("myDB.db",false);
    }

    public void addUser(User user) {
        db.addUser(user);
    }

    public Boolean isUserExists(User u) {
        return db.isUserExists(u);
    }

    public void addPackage(Package aPackage) {
        db.addPackage(aPackage);
    }

    public List<Package> getUserPackages(String email) {
        return db.getPackageByOwnerEmail(email);
    }

    public User loadUser(User u) {
        return db.getUserByEmail(u.email);
    }
}
