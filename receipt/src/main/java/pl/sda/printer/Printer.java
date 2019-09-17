package pl.sda.printer;

public abstract class Printer {
    private int printerLength;

    public Printer(int printerLength) {
        this.printerLength = printerLength;
    }

    protected abstract String prepareText(String string);

    public void printCenter(String string) {
        int stringLength = string.length();
        int spacesLeft = printerLength - stringLength;
        int spacesCount = spacesLeft / 2;
        printSpaces(spacesCount);
        System.out.println(prepareText(string));
    }

    public void printJustify(String string1, String string2) {
        int spacesLeft =
                printerLength - string1.length() - string2.length();
        System.out.print(prepareText(string1));
        printSpaces(spacesLeft);
        System.out.println(prepareText(string2));
    }

    private void printSpaces(int spacesCount) {
        for (int i = 0; i < spacesCount; i++) {
            System.out.print(" ");
        }
    }

    public void printRight(String string) {
        int stringLength = string.length();
        int spacesLeft = printerLength - stringLength;
        printSpaces(spacesLeft);
        System.out.println(prepareText(string));
    }

    public void printLeft(String string) {
        System.out.println(prepareText(trim(string, printerLength)));
    }

    public void separator() {
        for (int i = 0; i < printerLength; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public String trim(String string, int count) {
        if (string.length() > count) {
            return string.substring(0, count - 3) + "...";
        } else {
            return string;
        }
    }

}
