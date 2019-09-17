package pl.sda.entity;

public class Shop {
    private String name;
    private String address;
    private String nip;
    private String mail;
    private String phone;
    private Company company;

    public Shop(String name, String address, String nip, String mail, String phone, Company company) {
        this.name = name;
        this.address = address;
        this.nip = nip;
        this.mail = mail;
        this.phone = phone;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getNip() {
        return nip;
    }

    public String getMail() {
        return mail;
    }

    public String getPhone() {
        return phone;
    }

    public Company getCompany() {
        return company;
    }
}
