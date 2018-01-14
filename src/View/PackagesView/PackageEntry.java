package View.PackagesView;

import App.Package;

import java.util.List;

public class PackageEntry
{
    private String owner_email;
    private int total_price;
    private String description;
    private String cancellation_policy;
    private String attitude;

    public PackageEntry(Package p) {
        owner_email = p.getOwner_email();
        total_price = p.getTotal_price();
//        description = p.getDescription();
        cancellation_policy = p.getCancellation_policy();
//        attitude = p.getAttitude();

    }

    public String getOwner_email() {
        return owner_email;
    }

    public void setOwner_email(String address) {
        this.owner_email = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    public String getCancellation_policy() {
        return cancellation_policy;
    }

    public void setCancellation_policy(String cancellation_policy) {
        this.cancellation_policy = cancellation_policy;
    }

    public String getAttitude() {
        return attitude;
    }

    public void setAttitude(String attitude) {
        this.attitude = attitude;
    }
}
