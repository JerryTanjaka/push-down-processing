package hei.Entity;
import java.math.BigDecimal;

public class InvoiceTotal {

    private int invoiceId;
    private String customerName;
    private InvoiceStatus status;
    private BigDecimal total;

    public InvoiceTotal() {}

    public InvoiceTotal(int invoiceId, String customerName, InvoiceStatus status, BigDecimal total) {
        this.invoiceId = invoiceId;
        this.customerName = customerName;
        this.status = status;
        this.total = total;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public InvoiceStatus getStatus() {
        return status;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setStatus(InvoiceStatus status) {
        this.status = status;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
