package org.itique.indecy.core.flow;

public class Main {
    public static void main(String[] args) {
        double index = 1.0;

        Flow flow = Flow.builder(index)
                .addParam("performance", 0.5)
                .addParam("penalties", 0.2)
                .addParam("progress", 1.0)
                .build();
        Double result = flow.getResult();
    }
}
