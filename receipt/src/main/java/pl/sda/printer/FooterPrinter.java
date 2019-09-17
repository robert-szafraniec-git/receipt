package pl.sda.printer;

import pl.sda.entity.ReceiptPosition;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import static pl.sda.printer.DecimalFormats.PRICE;

public class FooterPrinter {
    private Printer printer;

    public FooterPrinter(Printer printer) {
        this.printer = printer;
    }

    public void print(ReceiptPosition[] positions){
        double sumValue = 0;

        for (ReceiptPosition position : positions) {
            sumValue += position.summarize();
        }
        printer.printJustify("Suma PLN", PRICE.format(sumValue));
        printer.separator();

        String hour = LocalTime.now()
                .format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        printer.printJustify("Godzina", hour);

        printer.printCenter("Numer Kontrolny");
        printer.printCenter("#" + UUID.randomUUID().toString() + "#");
        printer.printCenter("BHH 12561232");

        printer.printJustify("Gotówka", PRICE.format(sumValue));
    }
}
