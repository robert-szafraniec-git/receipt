package pl.sda;

import pl.sda.entity.*;
import pl.sda.printer.*;

public class Main2 {

    public static void main(String[] args) {
        Company company = new Company(
                "Sda Shop spółka z o.o.",
                "ul. Szkoleniowa 5/22",
                "Warszawa",
                "00-036");

        Shop shop = new Shop(
                "Sklep SDA JavaLub",
                "Ul. Sklepowa 6/17 20-011 Lublin",
                "523-645-31-53",
                "javalub@sdashop.com",
                "560-234-234",
                company
        );

        Product komputer_osobisty =
                new Product("Komputer osobisty", 3999.99, TaxCode.A, Unit.PIECE);
        Product montaż =
                new Product("Montaż i transport i instalacja komputera osobistego", 50,
                        TaxCode.B, Unit.SERVICE);
        Product szkolenie =
                new Product("Szkolenie w zakresie obsługi komputera", 1499.89,
                        TaxCode.B, Unit.SERVICE);
        Product płyn = new
                Product("Płyn chłodniczy do komputera", 14.99, TaxCode.D, Unit.KILOGRAM);

        ReceiptPosition[] positions = {
                new ReceiptPosition(komputer_osobisty, 3),
                new ReceiptPosition(montaż, 3),
                new ReceiptPosition(szkolenie, 1),
                new ReceiptPosition(płyn, 2.5)
        };


        ReceiptPrinters.create40lengthUpperCasePrinter(shop)
                .print(positions);

        Printer newPrinter = new NormalPrinter(60);
        ReceiptPrinter receiptPrinter2 = new ReceiptPrinter(
                new HeaderPrinter(newPrinter),
                new DoubleLineProductTablePrinter(newPrinter),
                new TaxPrinter(newPrinter),
                new FooterPrinter(newPrinter),
                shop
        );
        receiptPrinter2.print(positions);

        Printer newPrinter2 = new NormalPrinter(60);
        ReceiptPrinter receiptPrinter3 = new ReceiptPrinter(
                new HeaderPrinter(newPrinter2),
                new SingleLineProductTablePrinter(newPrinter2),
                new TaxPrinter(newPrinter2),
                new FooterPrinter(newPrinter2),
                shop
        );
        receiptPrinter3.print(positions);

    }

}
