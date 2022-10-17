import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FreelancerRateTest {

    private final FreelancerRates freelancerRates = new FreelancerRates();

    @Test
    public void dailyRate() {
        assertEquals(400.0, freelancerRates.dailyRate(50), 0.0);
        assertEquals(480.0, freelancerRates.dailyRate(60), 0.0);
        assertEquals(440.8, freelancerRates.dailyRate(55.1), 0.0);
    }

    @Test
    public void applyDiscount() {
        assertEquals(126.0, freelancerRates.applyDiscount(140.0, 10), 0.0);
        assertEquals(90.0, freelancerRates.applyDiscount(100, 10), 0.0);
        assertEquals(96.11015, freelancerRates.applyDiscount(111.11, 13.5),  0.000001);
    }

    @Test
    public void monthlyRate() {
        assertEquals(10_912, freelancerRates.monthlyRate(62, 0.0), 0.0);
        assertEquals(12_320, freelancerRates.monthlyRate(70, 0.0), 0.0);
        assertEquals(11_053, freelancerRates.monthlyRate(62.8, 0.0),  0.0);
        assertEquals(11_476, freelancerRates.monthlyRate(65.2, 0.0),  0.0);
        assertEquals(10_377, freelancerRates.monthlyRate(67, 12.0),  0.0);
    }

    @Test
    public void daysInBudget() {
        assertEquals(4, freelancerRates.daysInBudget(1_600, 50, 0.0), 0.0);
        assertEquals(1, freelancerRates.daysInBudget(520, 65, 0.0), 0.0);
        assertEquals(10, freelancerRates.daysInBudget(4_410, 55, 0.0),  0.0);
        assertEquals(10.1, freelancerRates.daysInBudget(4_480, 55, 0.0),  0.0);
        assertEquals(1.2, freelancerRates.daysInBudget(480, 60, 20),  0.0);
    }
}
