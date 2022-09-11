package org.itique.indecy.core.datatype;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Index {

    private final BigDecimal index;

    private Index(BigDecimal index) { this.index = index; }

    public static Index of(Double index) {
        return new Index(BigDecimal.valueOf(index));
    }

}
