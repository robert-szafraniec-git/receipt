package pl.sda;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Main {

    public static final int PRINTER_LENGTH = 40;

    public static void main(String[] args) {
        printCenter("Sda Shop spółka z o.o.");
        printCenter("Ul. Szkoleniowa 5/22 00-036 Warszawa");
        printCenter("Sklep SDA JavaLub");
        printCenter("Ul. Sklepowa 6/17 20-011 Lublin");
        printCenter("Tel: 560-234-234 javalub@sdashop.com");
        printCenter("NIP 523-645-31-53");
        printJustify(LocalDate.now().toString(), "1456");

        separator();
        printCenter("Paragon fiskalny");
        printJustify("Nazwa   ilość x cena", "wartość   PTU");
        separator();

        String[] productNames =
                {"Komputer osobisty",
                        "Montaż i transport i instalacja komputera osobistego",
                        "Szkolenie w zakresie obsługi komputera",
                        "Płyn chłodniczy do komputera"};
        double[] productPrices = {3999.99, 50, 1499.89, 14.99};
        String[] productUnits = {"szt", "usł", "usł", "kg"};
        double[] productQuantity = {3, 3, 1, 2.5};
        String[] productTax = {"A", "B", "B", "D"};

        DecimalFormat priceFormat = new DecimalFormat("#.00");
        DecimalFormat quantityFormat = new DecimalFormat("#.##");

        for (int i = 0; i < productNames.length; i++) {
            printLeft(productNames[i]);

            double quantity = productQuantity[i];
            String unit = productUnits[i];
            double price = productPrices[i];
            String tax = productTax[i];

            String firstPart = "   " + quantityFormat.format(quantity)
                    + " " + unit + " x " + priceFormat.format(price);
            double value = quantity * price;
            String secondPart = priceFormat.format(value) + " " + tax;
            printJustify(firstPart, secondPart);
        }
        separator();

        double sumTax = 0;
        sumTax += printTax(productPrices, productQuantity, productTax, priceFormat, "A", 0.23);
        sumTax += printTax(productPrices, productQuantity, productTax, priceFormat, "B", 0.08);
        sumTax += printTax(productPrices, productQuantity, productTax, priceFormat, "C", 0.00);
        sumTax += printTax(productPrices, productQuantity, productTax, priceFormat, "D", 0.05);
        printJustify("Suma PTU", priceFormat.format(sumTax));

        separator();

        double sumValue = 0;
        for (int i = 0; i < productPrices.length; i++) {
            sumValue += productPrices[i] * productQuantity[i];
        }
        printJustify("Suma PLN", priceFormat.format(sumValue));
        separator();


        String hour = LocalTime.now()
                .format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        printJustify("Godzina", hour);

        printCenter("Numer Kontrolny");
        printCenter("#" + UUID.randomUUID().toString() + "#");
        printCenter("BHH 12561232");

        printJustify("Gotówka", priceFormat.format(sumValue));

    }

    private static double printTax(double[] productPrices, double[] productQuantity, String[] productTax, DecimalFormat priceFormat, String taxCode, double taxPercent) {
        double sumValue = 0;
        for (int i = 0; i < productTax.length; i++) {
            if (productTax[i].equals(taxCode)) {
                sumValue += productPrices[i] * productQuantity[i];
            }
        }
        if (sumValue == 0) return 0;

        double tax = sumValue * taxPercent;
        String firstPart = "Sp. op. " + taxCode + "  " + priceFormat.format(sumValue)
                + " PTU " + (taxPercent * 100) + "%";
        String secondPart = priceFormat.format(tax);
        printJustify(firstPart, secondPart);
        return tax;
    }

    private static void printCenter(String string) {
        int stringLength = string.length();
        int spacesLeft = PRINTER_LENGTH - stringLength;
        int spacesCount = spacesLeft / 2;
        printSpaces(spacesCount);
        System.out.println(string.toUpperCase());
    }

    private static void printJustify(String string1, String string2) {
        int spacesLeft =
                PRINTER_LENGTH - string1.length() - string2.length();
        System.out.print(string1.toUpperCase());
        printSpaces(spacesLeft);
        System.out.println(string2.toUpperCase());
    }

    private static void printSpaces(int spacesCount) {
        for (int i = 0; i < spacesCount; i++) {
            System.out.print(" ");
        }
    }

    private static void separator() {
        for (int i = 0; i < PRINTER_LENGTH; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private static void printRight(String string) {
        int stringLength = string.length();
        int spacesLeft = PRINTER_LENGTH - stringLength;
        printSpaces(spacesLeft);
        System.out.println(string.toUpperCase());
    }

    private static void printLeft(String string) {
        System.out.println(trim(string));
    }

    private static String trim(String string) {
        if (string.length() > PRINTER_LENGTH) {
            String trimmedString = string.substring(0, PRINTER_LENGTH - 3) + "...";
            return trimmedString.toUpperCase();
        } else {
            return string.toUpperCase();
        }
    }

}
