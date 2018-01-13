package View.UserViewScreen;

import App.Product;

public class ProductEntry
{
    private String ownerEmail;
    private int productID;
    private int packageID;
    private int price;
    private String category;
    private String availability;
    private String description;
    private String address;

    public ProductEntry(Product p) {
        ownerEmail = p.ownerEmail;
        productID = p.productID;
        packageID = p.packageID;
        description = p.description;
        price = p.price;
        category = p.category;

    }

    public ProductEntry() {

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getPackageID() {
        return packageID;
    }

    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
