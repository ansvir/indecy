package org.itique.indecy.core.annotation;

public @interface Parameter {

    ParameterType type() default ParameterType.NUMBER;

    enum ParameterType {
        NUMBER, BOOLEAN
    }
}
