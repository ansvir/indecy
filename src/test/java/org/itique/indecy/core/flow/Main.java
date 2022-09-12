package org.itique.indecy.core.flow;

import java.io.IOException;
import java.nio.file.Path;

public class Main {

    private static final String PERFORMANCE = "PERFORMANCE";
    private static final String PENALTIES = "PENALTIES";
    private static final String PROGRESS = "PROGRESS";

    public static void main(String[] args) throws IOException {

        double index = 1.0;

        IndecyFlow flow = IndecyFlow.builder(index)
                .addParam(PERFORMANCE, 0.5)
                .addParam(PENALTIES, 0.2)
                .addParam(PROGRESS, 1.0)
                .runFlow(Path.of("C:\\Users\\svireant\\IdeaProjects\\indecy\\src\\test\\groovy\\org\\itique\\indecy\\core\\groovy\\exampleFlow.groovy").toFile());
        System.out.println(flow.getResult().doubleValue());
    }
}
