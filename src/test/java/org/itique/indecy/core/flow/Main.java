package org.itique.indecy.core.flow;

import java.io.File;

public class Main {

    private static final String PERFORMANCE = "PERFORMANCE";
    private static final String PENALTIES = "PENALTIES";
    private static final String PROGRESS = "PROGRESS";

    public static void main(String[] args) {

        double index = 1.0;

        IndecyFlow flow = IndecyFlow.builder(index)
                .addParam(PERFORMANCE, 0.5)
                .addParam(PENALTIES, 0.2)
                .addParam(PROGRESS, 1.0)
                .create(new File("src/test/groovy/org/itique/indecy/core/groovy/bonusesFlow.groovy"))
                .runFlow();
        System.out.println(flow.getResult());
    }

}
