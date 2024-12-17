package programma.JunitTests;

import org.junit.jupiter.api.Test;
import programma.logic.Validatie;

import static org.junit.jupiter.api.Assertions.*;

public class SignatoryNameTest {
    
    @Test
    public void validateNameReturnsTrueSimpleName(){
        //arrange
        Validatie validator = new Validatie();
        String name = "Jan";
        //act
        Boolean result = Validatie.signatoryNameValidator(name);
        //assert
        assertEquals(true, result);
    }

    @Test
    public void validateNameReturnsFalseContainsNumber(){
        //arrange
        Validatie validator = new Validatie();
        String name = "Jan123";
        //act
        Boolean result = Validatie.signatoryNameValidator(name);
        //assert
        assertEquals(false, result);
    }

    @Test
    public void validateNameReturnsTrueContainsDash(){
        //arrange
        Validatie validator = new Validatie();
        String name = "Jan-peterse";
        //act
        Boolean result = validator.signatoryNameValidator(name);
        //assert
        assertEquals(true, result);
    }

    @Test
    public void validateNameReturnsTrueContainsComma(){
        //arrange
        Validatie validator = new Validatie();
        String name = "Martin Luther King, jr";
        //act
        Boolean result = validator.signatoryNameValidator(name);
        //assert
        assertEquals(true, result);
    }

    @Test
    public void validateNameReturnsTrueContainsApostrophe(){
        //arrange
        Validatie validator = new Validatie();
        String name = "Mathias D'ame";
        //act
        Boolean result = validator.signatoryNameValidator(name);
        //assert
        assertEquals(true, result);
    }
}
