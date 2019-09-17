package pl.sda.printer;

import pl.sda.entity.ReceiptPosition;

import static pl.sda.printer.DecimalFormats.PRICE;
import static pl.sda.printer.DecimalFormats.QUANTITY;

public class DoubleLineProductTablePrinter implements ProductTablePrinter {
    private Printer printer;

    public DoubleLineProductTablePrinter(Printer printer) {
        this.printer = printer;
    }

    public void print(ReceiptPosition[] positions){

        printer.printCenter("Paragon fiskalny");
        printer.printJustify("Nazwa   ilość x cena", "wartość   PTU");
        printer.separator();

        for (ReceiptPosition position : positions) {
            printer.printLeft(position.getProduct().getName());

            double quantity = position.getQuantity();
            String unit = position.getProduct().getUnit().getSymbol();
            double price = position.getProduct().getPrice();
            String tax = position.getProduct().getTaxCode().name();

            String firstPart = "   " + QUANTITY.format(quantity)
                    + " " + unit + " x " + PRICE.format(price);
            double value = position.summarize();
            String secondPart = PRICE.format(value) + " " + tax;
            printer.printJustify(firstPart, secondPart);
        }
        printer.separator();
    }
}
