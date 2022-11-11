package org.itique.indecy.core.flow;

import java.util.HashMap;
import java.util.Map;

public enum Defaults {

    ZERO(0.0),
    THREE_QUARTERS(3.0/4.0),
    ONE_QUARTER(1.0/4.0),
    HALF(0.5),
    ONE(1.0);

    private final Double value;

    Defaults(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return this.value;
    }

    public static Map<Object, Double> getMapDefaults() {
        Map<Object, Double> defaults = new HashMap<>();
        defaults.put(ZERO.name(), ZERO.getValue());
        defaults.put(THREE_QUARTERS.name(), THREE_QUARTERS.getValue());
        defaults.put(ONE_QUARTER.name(), ONE_QUARTER.getValue());
        defaults.put(HALF.name(), HALF.getValue());
        defaults.put(ONE.name(), ONE.getValue());
        return defaults;
    }

}
