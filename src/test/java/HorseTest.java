import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.mockStatic;

public class HorseTest {

    @Test
    public void nullNameException(){

    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Horse(null,1,1));

        assertEquals("Name cannot be null.",exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t\t", "\n\n\n\n"})
    public void blankNameException(String name){

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Horse(name,1,1));

        assertEquals("Name cannot be blank.",exception.getMessage());
    }

    @Test
    public void negativeSpeedException(){

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Horse("test name",-5,1));

        assertEquals("Speed cannot be negative.",exception.getMessage());
    }

    @Test
    public void negativeDistanceException(){

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Horse("test name",5,-5));

        assertEquals("Distance cannot be negative.",exception.getMessage());
    }

    @Test
    public void getName() throws NoSuchFieldException, IllegalAccessException {
        String horseName = "Flash";
        Horse horse = new Horse(horseName,10, 1);

        //Reflection

        Field name = Horse.class.getDeclaredField("name");

        name.setAccessible(true);
        String nameValue = (String) name.get(horse);

        assertEquals(horseName,nameValue);
    }

    @Test
    public void getDistance()  {
        double expectedDistance = 10;
        Horse horse = new Horse("Flash",expectedDistance, 1);

        assertEquals(expectedDistance,horse.getDistance());
    }

    @Test
    public void zeroDistanceByDefault()  {

        Horse horse = new Horse("Flash", 1);

        assertEquals(0,horse.getDistance());
    }

    @Test
    public void testGetRandomDoubleMethodCalledInMoveMethod(){
        try(MockedStatic<Horse> mockedStatic = mockStatic(Horse.class)){
            new Horse("Thunder",30,123).move();

            mockedStatic.verify(() ->Horse.getRandomDouble(anyDouble(),anyDouble()));

        }
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.1,0.2,0.5,0.9,1.0,999.999,0.0})
    public void move(double random){

        double speed = 31;
        double distance = 281;

        try(MockedStatic<Horse> mockedStatic = mockStatic(Horse.class)){
           Horse horse =  new Horse("Flash",speed,distance);

            mockedStatic.when(()->Horse.getRandomDouble(0.2,0.9)).thenReturn(random);

            horse.move();

            assertEquals(distance+speed*random,horse.getDistance());

        }


    }

}
