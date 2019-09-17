package pl.sda.printer;

import pl.sda.entity.Shop;

import java.time.LocalDate;

public class HeaderPrinter {
    private Printer printer;

    public HeaderPrinter(Printer printer) {
        this.printer = printer;
    }

    public void print(Shop shop){
        printer.printCenter(shop.getCompany().getName());
        //printCenter(company. getAddress() + " " + company.getPostCode() + " " + company.getCity());
        printer.printCenter(shop.getCompany().getFullAddress());
        printer.printCenter(shop.getName());
        printer.printCenter(shop.getAddress());
        printer.printCenter("Tel: " + shop.getPhone() + " " + shop.getMail());
        printer.printCenter("NIP " + shop.getNip());
        printer.printJustify(LocalDate.now().toString(), "1456");
        printer.separator();
    }
}
