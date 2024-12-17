package programma.JunitTests;

import org.junit.jupiter.api.Test;
import programma.logic.Validatie;

import static org.junit.jupiter.api.Assertions.*;


public class NumericRangeToolsTest {
    @Test
    public void testIsValidPercentageReturnsTrue(){
        //arrange
        Validatie validator = new Validatie();
        int percentage = 50;
        //act
        Boolean result = validator.percentageValidator(percentage);
        //assert
        assertEquals(true, result);
    }

    @Test
    public void testIsValidPercentageReturnsFalseBelowZero(){
        //arrange
        Validatie validator = new Validatie();
        int percentage = -1;
        //act
        Boolean result = validator.percentageValidator(percentage);
        //assert
        assertEquals(false, result);
    }

    @Test
    public void testIsValidPercentageReturnsFalseAboveOneHundred(){
        //arrange
        Validatie validator = new Validatie();
        int percentage = 101;
        //act
        Boolean result = validator.percentageValidator(percentage);
        //assert
        assertEquals(false, result);
    }

    @Test
    public void testIsValidGradeReturnsTrue(){
        //arrange
        Validatie validator = new Validatie();
        int grade = 5;
        //act
        Boolean result = validator.gradeValidator(grade);
        //assert
        assertEquals(true, result);
    }

    @Test
    public void testIsValidGradeReturnsFalseBelowZero(){
        //arrange
        Validatie validator = new Validatie();
        int grade = -1;
        //act
        Boolean result = validator.gradeValidator(grade);
        //assert
        assertEquals(false, result);
    }

    @Test
    public void testIsValidGradeReturnsFalseAboveTen(){
        //arrange
        Validatie validator = new Validatie();
        int grade = 11;
        //act
        Boolean result = validator.gradeValidator(grade);
        //assert
        assertEquals(false, result);
    }
}
