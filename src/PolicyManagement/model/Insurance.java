package PolicyManagement.model;

import java.util.Date;

public abstract class Insurance {
    private String name;
    private double fee;
    private Date startDate;
    private Date endDate;

    public Insurance(String name, double fee, Date startDate, Date endDate) {
        this.name = name;
        this.fee = fee;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public abstract double calculate();
}


