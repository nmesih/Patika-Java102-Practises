package PolicyManagement.model;

import java.util.Date;

public class TravelInsurance extends Insurance {

    public TravelInsurance(String name, double fee, Date startDate, Date endDate) {
        super(name, fee, startDate, endDate);
    }

    @Override
    public double calculate() {
        // Implement calculate method for TravelInsurance
        return 0;
    }
}
