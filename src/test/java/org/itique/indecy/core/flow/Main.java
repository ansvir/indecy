package org.itique.indecy.core.flow;

import org.springframework.core.io.ClassPathResource;

public class Main {
    public static void main(String[] args) {
        double index = 1.0;

        Flow flow = Flow.builder(index)
                .addParam("performance", 0.5)
                .addParam("penalties", 0.2)
                .addParam("progress", 1.0)
                .runFlow(new ClassPathResource("org/itique/indecy/core/script/exampleFlow.groovy").getPath());
        Double result = flow.getResult();
    }
}
