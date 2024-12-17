package programma.JunitTests;

import org.junit.jupiter.api.Test;
import programma.logic.Validatie;

import static org.junit.jupiter.api.Assertions.*;

public class DateTest {
    @Test
    public void testDateOutOfRangeFebInLeapYear(){
        //arrange
        Validatie validator= new Validatie();

        //act
       boolean valid = validator.validateDate(30, 2, 2020);

        //assert
        assertEquals(false, valid);
    }
    @Test
    public void testDateInRangeNov(){
        //arrange
        Validatie validator= new Validatie();

        //act
       boolean valid = validator.validateDate(23, 11, 2020);

        //assert
        assertEquals(true, valid);
    }
    @Test
    public void testDateInRangeFebInLeapYear(){
        //arrange
        Validatie validator= new Validatie();

        //act
       boolean valid = validator.validateDate(12, 2, 2020);

        //assert
        assertEquals(true, valid);
    }
    @Test
    public void testDateOutOfRangeApr(){
        //arrange
        Validatie validator= new Validatie();

        //act
       boolean valid = validator.validateDate(31, 4, 2002);

        //assert
        assertEquals(false, valid);
    }
}
