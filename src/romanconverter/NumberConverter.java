package romanconverter;

import java.util.List;

public class NumberConverter {

    public String romanToArabic(String input) {
        String[] numberParts = input.split("-");
        if (numberParts.length != 4){
            throw new IllegalArgumentException(input + " has invalid format. 4 parts splitted with dash expected");
        }
        Integer ccNumberPart1 = convertToArabic(numberParts[0]);
        Integer ccNumberPart2 = convertToArabic(numberParts[1]);
        Integer ccNumberPart3 = convertToArabic(numberParts[2]);
        Integer ccNumberPart4 = convertToArabic(numberParts[3]);
        return ccNumberPart1.toString() + ccNumberPart2.toString() + ccNumberPart3.toString() + ccNumberPart4.toString();
    }

    private int convertToArabic(String input) {
        String romanNumeral = input.toUpperCase();
        int result = 0;

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;

        while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) {
            RomanNumeral symbol = romanNumerals.get(i);
            if (romanNumeral.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        if (romanNumeral.length() > 0) {
            throw new IllegalArgumentException(input + " cannot be converted to a Number");
        }

        return result;
    }
}
