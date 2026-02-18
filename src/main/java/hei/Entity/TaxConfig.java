package hei.Entity;
import java.math.BigDecimal;

public class TaxConfig {

    private int id;
    private String label;
    private BigDecimal rate;

    public TaxConfig() {}

    public TaxConfig(int id, String label, BigDecimal rate) {
        this.id = id;
        this.label = label;
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}
