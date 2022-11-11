package org.itique.indecy.corejava;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IndecyFlowTest {

    private static final double INITIAL_INDEX = 1.0;
    private static final String PERFORMANCE = "PERFORMANCE";
    private static final String PENALTIES = "PENALTIES";
    private static final String MAX_PENALTIES = "MAX_PENALTIES";
    private static final String PROGRESS = "PROGRESS";
    private static final String SCRIPT_PATH = "src/test/resources/";

    @Test
    public void testFlowPassedAndResultEqualsExactOne() {

        // given
        IndecyFlow.Runner runner = IndecyFlow.builder(INITIAL_INDEX)
                .create(new File(SCRIPT_PATH + "bonusesFlow.groovy"));

        // when
        IndecyFlow flow = runner.runFlow();

        // then
        assertEquals(Double.valueOf(2.3), flow.getResult());
    }

    @Test
    public void testFlowWithParametersPassedAndResultEqualsExactOne() {

        // given
        IndecyFlow.Runner runner = IndecyFlow.builder(INITIAL_INDEX)
                .addParam(PERFORMANCE, 0.3)
                .addParam(PENALTIES, 30.0)
                .addParam(MAX_PENALTIES, 200.0)
                .addParam(PROGRESS, 0.2)
                .create(new File(SCRIPT_PATH + "parametrizedBonusesFlow.groovy"));

        // when
        IndecyFlow flow = runner.runFlow();

        // then
        assertEquals(Double.valueOf(3.8), round(flow.getResult(), 1));
    }

    private Double round(Double input, int decimalPlaces) {
        double multiplicator = 1.0;
        for (int i = 0 ; i < decimalPlaces; i++) {
            multiplicator *= 10.0;
        }
        return (double) Math.round(input * multiplicator) / multiplicator;
    }
}
