package Model;

public class Order {
    private int order_id;
    private int customer_id;
    private int length;
    private int height;
    private int width;
    private int roof;
    private int shed;
    private int shedtype;
    private int order_status;
    private String date;

    public Order(int order_id, int customer_id, int length, int height, int width, int roof, int shed, int shedtype, int order_status, String date) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.length = length;
        this.height = height;
        this.width = width;
        this.roof = roof;
        this.shed = shed;
        this.shedtype = shedtype;
        this.order_status = order_status;
        this.date = date;
    }

    public Order(int customer_id, int length, int height, int width, int roof, int shed, int shedtype, int order_status, String date) {
        this.customer_id = customer_id;
        this.length = length;
        this.height = height;
        this.width = width;
        this.roof = roof;
        this.shed = shed;
        this.shedtype = shedtype;
        this.order_status = order_status;
        this.date = date;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getRoof() {
        return roof;
    }

    public int getShed() {
        return shed;
    }

    public int getShedtype() {
        return shedtype;
    }

    public int getOrder_status() {
        return order_status;
    }

    public String getDate() {
        return date;
    }
}
