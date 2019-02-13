package romanconverter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertThrows;

class NumberConverterTest {

    private NumberConverter sut = new NumberConverter();

    @Test
    public void givenRandomRomanNumberInExpectedFormat_ThenReturnNumberInArabic() {
        String romanNumberFormatted = "L-C-D-M";
        String result = sut.romanToArabic(romanNumberFormatted);

        Assertions.assertEquals("501005001000",result);
    }

    @Test
    public void givenValidRomanCardNumber_ThenReturnNumberInArabic() {
        String romanCardNumber = "MMMMDCCXVI-MMCMXCI-MMMDCLXIV-MMMMMDXC";
        String result = sut.romanToArabic(romanCardNumber);

        Assertions.assertEquals("4716299136645590",result);
    }

    @Test
    public void givenRomanNumberInWrongFormat_ThenExceptionIsThrown(){
        String romanNumberInWrongFormat = "L-C-DM";
        Executable executableFunction = () -> sut.romanToArabic(romanNumberInWrongFormat);

        IllegalArgumentException expectedException = assertThrows(IllegalArgumentException.class, executableFunction);
        Assertions.assertEquals("L-C-DM has invalid format. 4 parts splitted with dash expected", expectedException.getMessage());
    }

    @Test
    public void givenInvalidPartOfRomanCard_ThenExceptionIsThrown() {
        String cardWithInvalidNumber = "IMMMDCCXVI-MMCMXCI-MMMDCLXIV-MMMMMDXC";
        Executable executableFunction = () -> sut.romanToArabic(cardWithInvalidNumber);

        IllegalArgumentException expectedException = assertThrows(IllegalArgumentException.class, executableFunction);
        Assertions.assertEquals("IMMMDCCXVI cannot be converted to a Number", expectedException.getMessage());
    }

}