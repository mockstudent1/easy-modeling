package xyz.v2my.easymodeling;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@AllArgsConstructor
public class Order {

    private String id;

    private BigDecimal unitPrice;

    private long amount;

    private Instant creationTime;

    public String getId() {
        return id;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public long getAmount() {
        return amount;
    }

    public Instant getCreationTime() {
        return creationTime;
    }
}
