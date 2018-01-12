package App;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Package {

    private List<Product> products;
    private String owner_email;
    private int package_id;
    private int total_price;
    private String cancellation_policy;
    private String address;
    private LocalDate startDate;
    private LocalDate Date;

    public boolean equals(Package obj) {
        return owner_email.equals(obj.owner_email) && package_id == obj.package_id &&
                products.size() == obj.products.size() && total_price == obj.total_price;
    }

    public Package(String owner_email, int package_id) {
        this.products = new ArrayList<Product>();
        this.owner_email = owner_email;
        this.package_id = package_id;
        this.total_price = 0;
        this.cancellation_policy = "No Policy";
        address = "No Address";

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Product> getProducts() {
        return products;
    }


    public String getOwner_email() {
        return owner_email;
    }


    public int getPackage_id() {
        return package_id;
    }


    public int getTotal_price() {
        return total_price;
    }

    public String getCancellation_policy() {
        return cancellation_policy;
    }

    public void setCancellation_policy(String cancellation_policy) {
        this.cancellation_policy = cancellation_policy;
    }

    public void addProduct(Product product){
        total_price += product.price;
        this.products.add(product);
    }
}
