package veroslaves.upcoming_events_back;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class pruebaTests {
    @Test
    void testGetX() {
        
       prueba num = new prueba(0);
       num.Sumar1();
       int currentnum = num.getX();
        assertEquals(1, currentnum);

    }


}
