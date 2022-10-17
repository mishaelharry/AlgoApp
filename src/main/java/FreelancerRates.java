import java.math.BigDecimal;
import java.math.RoundingMode;

public class FreelancerRates {

    private final static int ratePerHour = 8;

    private final static int billableDays = 22;

    public double dailyRate(double hourlyRate){
        return ratePerHour * hourlyRate;
    }

    public double applyDiscount(double price, double percentage){
        double discount = percentage * (price / 100);
        return price - discount;
    }

    public double monthlyRate(double hourlyRate, double discount) {
        double dailyRate = dailyRate(hourlyRate);
        double totalMonthlyRate = billableDays * dailyRate;
        double discountedMonthlyRate = applyDiscount(totalMonthlyRate, discount);
        return Math.ceil(discountedMonthlyRate);
    }

    public double daysInBudget(int budget, int hourlyRate, double discount) {
        double applyDiscount = applyDiscount(hourlyRate, discount);
        double dailyRate = dailyRate(applyDiscount);
        double daysInBudget = budget / dailyRate;
        return new BigDecimal(daysInBudget).setScale(1, RoundingMode.DOWN).doubleValue();
    }
}
