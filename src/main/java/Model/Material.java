package Model;

public class Material {

    int product_id = 0;
    String product_name;
    String product_description;
    int price = 0;

    public Material(int product_id, String product_name, String product_description, int price) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_description = product_description;
        this.price = price;
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

    public int getPrice() {
        return price;
    }
}
