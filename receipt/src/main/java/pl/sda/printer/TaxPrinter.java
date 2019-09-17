package pl.sda.printer;

import pl.sda.entity.ReceiptPosition;
import pl.sda.entity.TaxCode;

import static pl.sda.printer.DecimalFormats.PRICE;

/*
 * Zadanie 18
 */
public class TaxPrinter {
    private Printer printer;

    public TaxPrinter(Printer printer) {
        this.printer = printer;
    }

    public void print(ReceiptPosition[] positions){
        double sumTax = 0;
        sumTax += printTax(positions, TaxCode.A, printer);
        sumTax += printTax(positions, TaxCode.B, printer);
        sumTax += printTax(positions, TaxCode.C, printer);
        sumTax += printTax(positions, TaxCode.D, printer);
        printer.printJustify("Suma PTU", PRICE.format(sumTax));

        printer.separator();
    }

    private double printTax(ReceiptPosition[] positions,
                                   TaxCode taxCode,
                                   Printer printer) {
        double sumValue = 0;
        for (ReceiptPosition position : positions) {
            if (position.getProduct().getTaxCode().equals(taxCode)) {
                sumValue += position.summarize();
            }
        }
        if (sumValue == 0) return 0;

        double tax = taxCode.calculateTax(sumValue);
        String firstPart = "Sp. op. " + taxCode + "  " + PRICE.format(sumValue)
                + " PTU " + taxCode.getPercentText();
        String secondPart = PRICE.format(tax);
        printer.printJustify(firstPart, secondPart);
        return tax;
    }
}
