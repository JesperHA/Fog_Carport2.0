package Model;

public class Customer {

    private int customer_id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String adress;
    private String zipcode;
    private String city;
    private int role;

    private int id; // just used to demo retrieval of autogen keys in UserMapper

    public Customer(String name, String email, String password, String phone, String adress, String zipcode, String city, int role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.adress = adress;
        this.zipcode = zipcode;
        this.city = city;
        this.role = role;
    }

    public Customer(int customer_id, String name, String email, String password, String phone, String adress, String zipcode, String city, int role) {
        this.customer_id = customer_id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.adress = adress;
        this.zipcode = zipcode;
        this.city = city;
        this.role = role;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {return password;}

    public String getPhone() {
        return phone;
    }

    public String getAdress() {
        return adress;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCity() {
        return city;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public int getRole() {
        return role;
    }
}
