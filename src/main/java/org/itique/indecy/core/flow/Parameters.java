package org.itique.indecy.core.flow;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Parameters {

    private Map<Object, Double> params;

    public Parameters() {
        this.params = new ConcurrentHashMap<>();
    }

    public void put(Object key, Double value) {
        this.params.put(key, value);
    }

    public Double get(Object key) {
        return this.params.get(key);
    }

    public void setParams(Map<Object, Double> params) {
        if (params == null) {
            throw new IllegalArgumentException("params must not be null!");
        }
        this.params = params;
    }

    public Map<Object, Double> getParams() {
        return params;
    }

}
