package App;

import java.util.Date;

public class Order {

    private int tenant_id;
    private int renter_id;
    private Date start_date;
    private Date end_date;
    private int total_price;
    private int package_id;
    private String status;

    public Order(int tenant_id, int renter_id, Date start_date, Date end_date, int total_price, int package_id, String status) {
        this.tenant_id = tenant_id;
        this.renter_id = renter_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.total_price = total_price;
        this.package_id = package_id;
        this.status = status;
    }

    public int getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(int tenant_id) {
        this.tenant_id = tenant_id;
    }

    public int getRenter_id() {
        return renter_id;
    }

    public void setRenter_id(int renter_id) {
        this.renter_id = renter_id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    public int getPackage_id() {
        return package_id;
    }

    public void setPackage_id(int package_id) {
        this.package_id = package_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
