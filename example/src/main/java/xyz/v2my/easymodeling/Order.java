package xyz.v2my.easymodeling;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class Order {

    private String id;

    private BigDecimal unitPrice;

    private long amount;
}
