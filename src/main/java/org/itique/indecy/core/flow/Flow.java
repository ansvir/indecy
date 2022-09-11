package org.itique.indecy.core.flow;

import java.util.HashMap;
import java.util.Map;

public class Flow {

    private Double result;

    private Flow(Map<String, Double> params, Double initValue) {
        process(params, initValue);
    }

    public Double getResult() {
        return this.result;
    }

    private void process(Map<String, Double> params, Double initValue) {
        this.result = 0.1;
    }

    public static Builder builder(Double initValue) {
        return new Builder(initValue);
    }

    public static class Builder {

        private final Map<String, Double> params;
        private final Double initValue;

        public Builder(Double initValue) {
            this.params = new HashMap<>();
            this.initValue = initValue;
        }

        public Builder addParam(String key, Double value) {
            this.params.put(key, value);
            return this;
        }

        public Flow build() {
            return new Flow(this.params, this.initValue);
        }

    }

}
