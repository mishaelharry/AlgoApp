import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LasagnaTest {

    //https://exercism.org/tracks/java/exercises/lasagna

    private Lasagna lasagna = new Lasagna();

    @Test
    public void expectedMinutesInOven() {
        assertEquals(40, lasagna.expectedMinutesInOven(), 0.0);
    }

    @Test
    public void remainingMinutesInOven() {
        assertEquals(10, lasagna.remainingMinutesInOven(30), 0.0);
    }

    @Test
    public void preparationTimeInMinutes() {
        assertEquals(4, lasagna.preparationTimeInMinutes(2), 0.0);
    }

    @Test
    public void totalTimeInMinutes() {
        assertEquals(26, lasagna.totalTimeInMinutes(3, 20), 0.0);
    }


}
