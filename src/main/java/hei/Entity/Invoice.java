package hei.Entity;

import java.util.Objects;

public class Invoice {

    private int id;
    private String customerName;
    private InvoiceStatus status;

    public Invoice() {}

    public Invoice(int id, String customerName, InvoiceStatus status) {
        this.id = id;
        this.customerName = customerName;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public InvoiceStatus getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setStatus(InvoiceStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return id == invoice.id && Objects.equals(customerName, invoice.customerName) && status == invoice.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerName, status);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "customerName='" + customerName + '\'' +
                ", id=" + id +
                ", status=" + status +
                '}';
    }
}
