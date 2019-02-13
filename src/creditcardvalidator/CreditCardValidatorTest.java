package creditcardvalidator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CreditCardValidatorTest {

    private CreditCardValidator sut = new CreditCardValidator();

    @Test
    public void isAmexCardValid() {
        boolean isValid = sut.isValidCard("378282246310005");
        Assertions.assertTrue(isValid);
    }

    @Test
    public void isInvalidAmexCard() {
        boolean isValid = sut.isValidCard("378282346310005");
        Assertions.assertFalse(isValid);
    }

    @Test
    public void isOtherAmexCardValid() {
        boolean isValid = sut.isValidCard("371847579533915");
        Assertions.assertTrue(isValid);
    }

    @Test
    public void isVisaCardValid() {
        boolean isValid = sut.isValidCard("4417123456789113");
        Assertions.assertTrue(isValid);
    }

    @Test
    public void isMasterCardValid() {
        boolean isValid = sut.isValidCard("5114266492307268");
        Assertions.assertTrue(isValid);
    }

    @ParameterizedTest
    @CsvSource({
            "378282246310005, true",
            "378282346310005, false",
            "371847579533915, true",
            "5114266492307268, true",
            "4417123456789113, true",
            "2437123456789113, false" //this is not a credit card number, but current implementation treats it like that
    })
    void testWithCsvSource(String cardNumber, boolean expectedValidity) {
        boolean actualValidity = sut.isValidCard(cardNumber);
        Assertions.assertEquals(expectedValidity, actualValidity);
    }


}