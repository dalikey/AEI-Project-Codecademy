package programma.JunitTests;

import org.junit.jupiter.api.Test;
import programma.logic.Validatie;

import static org.junit.jupiter.api.Assertions.*;

public class PostalCodeTest {
    @Test
    public void nullPointerExceptionPostalCode (){
         //arrange
         Validatie validator = new Validatie();

         //act
        String valid = Validatie.formatPostalCode(null);
 
         //assert
         assertEquals("NullPointerException", valid);
    }
    @Test
    public void notEnoughNumbers (){
        //arrange
        Validatie validator = new Validatie();

        //act
       String valid = Validatie.formatPostalCode("123AB");

        //assert
        assertEquals("IllegalArgumentException", valid);
   }
   @Test
   public void good (){
     //arrange
     Validatie validator = new Validatie();

     //act
    String valid = Validatie.formatPostalCode("1234ab");

     //assert
     assertEquals("1234 AB", valid);
}
@Test
public void differentInput (){
     //arrange
     Validatie validator = new Validatie();

     //act
    String valid = Validatie.formatPostalCode("Kaas");

     //assert
     assertEquals("IllegalArgumentException", valid);
}

}
