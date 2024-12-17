package programma.JunitTests;

import org.junit.jupiter.api.Test;
import programma.logic.Validatie;

import static org.junit.jupiter.api.Assertions.*;

public class MailToolsTest {
    
    @Test
    public void validateMailAddressReturnsFalseNoAt(){
        //arrange
        Validatie validator = new Validatie();
        String mailAddress = "mailmail.com";
        //act
        Boolean result = Validatie.validatieEmail(mailAddress);
        //assert
        assertEquals(false, result);
    }

    @Test
    public void validateMailAddressReturnsFalseNoMailbox(){
        //arrange
        Validatie validator = new Validatie();
        String mailAddress = "@mail.com";
        //act
        Boolean result = Validatie.validatieEmail(mailAddress);
        //assert
        assertEquals(false, result);
    }

    @Test
    public void validateMailAddressReturnsTrueNoSubdomainTLDDelimiter(){
        //arrange
        Validatie validator = new Validatie();
        String mailAddress = "mail@mail.k.com";
        //act
        Boolean result = Validatie.validatieEmail(mailAddress);
        //assert
        assertEquals(true, result);
    }

    @Test
    public void validateMailAddressReturnsFalseNoSubdomain(){
        //arrange
        Validatie validator = new Validatie();
        String mailAddress = "mail@.com";
        //act
        Boolean result = Validatie.validatieEmail(mailAddress);
        //assert
        assertEquals(false, result);
    }

    @Test
    public void validateMailAddressReturnsFalseNoTLD(){
        //arrange
        Validatie validator = new Validatie();
        String mailAddress = "mail@mail.";
        //act
        Boolean result = Validatie.validatieEmail(mailAddress);
        //assert
        assertEquals(false, result);
    }

    @Test
    public void validateMailAddressReturnsTrue(){
        //arrange
        Validatie validator = new Validatie();
        String mailAddress = "mail@mail.com";
        //act
        Boolean result = Validatie.validatieEmail(mailAddress);
        //assert
        assertEquals(true, result);
    }

}
