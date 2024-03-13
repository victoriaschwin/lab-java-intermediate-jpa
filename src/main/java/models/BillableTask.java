package models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Date;
import java.util.Objects;

@Entity
@DiscriminatorValue("BILLABLE")
public class BillableTask  extends Task{
    private double hourlyRate;

    public BillableTask() {}

    public BillableTask(String title, Date dueDate, boolean status, double hourlyRate) {
        super(title, dueDate, status);
        this.hourlyRate = hourlyRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BillableTask that = (BillableTask) o;
        return Double.compare(hourlyRate, that.hourlyRate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hourlyRate);
    }
}
