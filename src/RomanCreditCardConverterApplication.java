import creditcardvalidator.CreditCardValidator;
import romanconverter.NumberConverter;

public class RomanCreditCardConverterApplication {

    public static void main(String[] args) {
//     Test data generated with help of https://www.rapidtables.com/convert/number/roman-numerals-converter.html
        NumberConverter numberConverter = new NumberConverter();

        String validRomanCardNumber = "MMMMDCCXVI-MMCMXCI-MMMDCLXIV-MMMMMDXC"; //4716 2991 3664 5590
        String validArabicCardNumber = numberConverter.romanToArabic(validRomanCardNumber);
        System.out.println("Processing number: " + validArabicCardNumber);
        CreditCardValidator creditCardValidator = new CreditCardValidator();
        boolean isValid = creditCardValidator.validate(validArabicCardNumber);
        System.out.println("Entered roman card number is " + getValidityText(isValid));


        String invalidRomanCardNumber = "MMCDXXXVII-MCCXXXIV-MMMMMDCLXXVIII-MMMMMMMMMCXIII"; //2437 1234 5678 9113
        String invalidArabicCardNumber = numberConverter.romanToArabic(invalidRomanCardNumber);
        System.out.println("Processing number: " + invalidArabicCardNumber);
        isValid = creditCardValidator.validate(invalidArabicCardNumber);
        System.out.println("Entered roman card number is " + getValidityText(isValid));

    }

    private static String getValidityText(boolean isValid) {
        if (!isValid) {
            return " invalid";
        }
        return " valid";
    }
}
