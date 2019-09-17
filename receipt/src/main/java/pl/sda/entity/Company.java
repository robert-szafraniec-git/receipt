package pl.sda.entity;

public class Company {
    private String name;
    private String address;
    private String city;
    private String postCode;

    public Company(String name, String address, String city, String postCode) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.postCode = postCode;
    }

    public String getFullAddress(){
        return address + " " + postCode + " " + city;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getPostCode() {
        return postCode;
    }
}
