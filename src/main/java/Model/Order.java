package Model;

public class Order {
    private int order_id;
    private int customer_id;
    private int size;
    private int length;
    private int width;
    private int height;
    private int roof_type;
    private int roof_sort;
    private int shed;
    private int shedtype;
    private int shed_length;
    private int shed_width;
    private int order_status;
    private String date;

    public Order(int order_id, int customer_id, int size, int length, int width, int height, int roof_type, int roof_sort, int shed, int shedtype, int shed_length, int shed_width, int order_status, String date) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.size = size;
        this.length = length;
        this.height = height;
        this.width = width;
        this.roof_type = roof_type;
        this.roof_sort = roof_sort;
        this.shed = shed;
        this.shedtype = shedtype;
        this.shed_length = shed_length;
        this.shed_width = shed_width;
        this.order_status = order_status;
        this.date = date;
    }

    public Order(int customer_id, int size, int length, int width, int height, int roof_type, int roof_sort, int shed, int shedtype, int shed_length, int shed_width, int order_status, String date) {
        this.customer_id = customer_id;
        this.size = size;
        this.length = length;
        this.height = height;
        this.width = width;
        this.roof_type = roof_type;
        this.roof_sort = roof_sort;
        this.shed = shed;
        this.shedtype = shedtype;
        this.shed_length = shed_length;
        this.shed_width = shed_width;
        this.order_status = order_status;
        this.date = date;
    }

    public Order(int size, int length, int width, int height, int roof_type, int roof_sort, int shed, int shedtype, int shed_length, int shed_width, int order_status, String date) {
        this.size = size;
        this.length = length;
        this.height = height;
        this.width = width;
        this.roof_type = roof_type;
        this.roof_sort = roof_sort;
        this.shed = shed;
        this.shedtype = shedtype;
        this.shed_length = shed_length;
        this.shed_width = shed_width;
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

    public int getSize() {
        return size;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getRoof_type() {
        return roof_type;
    }

    public int getRoof_sort() {
        return roof_sort;
    }

    public int getShed() {
        return shed;
    }

    public int getShedtype() {
        return shedtype;
    }

    public int getShed_length() {
        return shed_length;
    }

    public int getShed_width() {
        return shed_width;
    }

    public int getOrder_status() {
        return order_status;
    }

    public String getDate() {
        return date;
    }
}
