package org.itique.indecy.core.flow;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;

import java.util.HashMap;
import java.util.Map;

public class Flow {

    private Double result;

    private Flow(Double result) {
        this.result = result;
    }

    public Double getResult() {
        return this.result;
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

        public Flow runFlow(String path) {
            Binding binding = new Binding();
            GroovyShell shell = new GroovyShell(binding);
            Double result = (Double) shell.evaluate(path);
            return new Flow(result);
        }

    }

}
