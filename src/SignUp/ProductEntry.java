package SignUp;

import App.Product;

public class ProductEntry
{
    private String ownerEmail;
    private int productID;
    private int packageID;
    private int price;
    private String category;

    public ProductEntry(Product p) {
        ownerEmail = p.ownerEmail;
        productID = p.productID;
        packageID = p.packageID;

        price = p.price;
        category = p.category;
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
