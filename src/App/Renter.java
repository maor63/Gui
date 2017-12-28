package App;

import java.util.List;

public class Renter extends User {

    private List<String> days;

    public Renter(int user_id, String first_name, String last_name, String password, String email, List<String> day) {
        super(first_name, last_name, password, email);
        this.days = days;
    }

    public List<String> getDays() {
        return days;
    }

    public void setDays(List<String> days) {
        this.days = days;
    }

    public void addDay(String day){
        if(!this.days.contains(day))
        {
            this.days.add(day);
        }
    }
}
