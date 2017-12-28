package App;

public class Tenant extends User {


    public Tenant(int user_id, String first_name, String last_name, String password, String email) {
        super(first_name, last_name, password, email);
    }
}
