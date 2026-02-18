package hei.Entity;

import java.util.Objects;

public class InvoiceStatusTotals {
    private Double total_paid ;
    private Double total_confirmed;
    private Double Total_draft;

    public InvoiceStatusTotals(Double total_confirmed, Double total_draft, Double total_paid) {
        this.total_confirmed = total_confirmed;
        Total_draft = total_draft;
        this.total_paid = total_paid;
    }

    public InvoiceStatusTotals() {

    }

    public Double getTotal_confirmed() {
        return total_confirmed;
    }

    public void setTotal_confirmed(Double total_confirmed) {
        this.total_confirmed = total_confirmed;
    }

    public Double getTotal_draft() {
        return Total_draft;
    }

    public void setTotal_draft(Double total_draft) {
        Total_draft = total_draft;
    }

    public Double getTotal_paid() {
        return total_paid;
    }

    public void setTotal_paid(Double total_paid) {
        this.total_paid = total_paid;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceStatusTotals that = (InvoiceStatusTotals) o;
        return Objects.equals(total_paid, that.total_paid) && Objects.equals(total_confirmed, that.total_confirmed) && Objects.equals(Total_draft, that.Total_draft);
    }

    @Override
    public int hashCode() {
        return Objects.hash(total_paid, total_confirmed, Total_draft);
    }

    @Override
    public String toString() {
        return "InvoiceStatusTotals{" +
                "total_confirmed=" + total_confirmed +
                ", total_paid=" + total_paid +
                ", Total_draft=" + Total_draft +
                '}';
    }

}
