package hei.Entity;

public class InvoiceTaxSummary {
    private int invoiceId;
    private Double HT;
    private Double TVA;
    private Double TTC;

    public InvoiceTaxSummary( int invoiceId,Double HT, Double TTC, Double TVA) {
        this.invoiceId = invoiceId;
        this.HT = HT;
        this.TTC = TTC;
        this.TVA = TVA;
    }

    public InvoiceTaxSummary() {

    }

    public Double getHT() {
        return HT;
    }

    public void setHT(Double HT) {
        this.HT = HT;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Double getTTC() {
        return TTC;
    }

    public void setTTC(Double TTC) {
        this.TTC = TTC;
    }

    public Double getTVA() {
        return TVA;
    }

    public void setTVA(Double TVA) {
        this.TVA = TVA;
    }
}
