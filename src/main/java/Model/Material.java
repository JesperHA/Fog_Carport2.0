package Model;

public class Material {

    int product_id = 0;
    String product_name;
    String product_description;
    double price = 0;
    double unit = 0;
    int amount = 0;

    public void setPrice(double price) {
        this.price = price;
    }

    public Material(int product_id, String product_name, String product_description, double price, double unit, int amount) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_description = product_description;
        this.price = price;
        this.unit = unit;
        this.amount = amount;
    }

    public void setUnit(double unit) {
        this.unit = unit;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getProduct_id() {
        return product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getProduct_description() {
        return product_description;
    }

    public double getPrice() {
        return price;
    }

    public double getUnit() {
        return unit;
    }

    public int getAmount() {return amount;}
}
