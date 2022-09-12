package org.itique.indecy.core.dsl

class Branch {

    String caseName
    boolean condition
    Double adjustment

    def targeting = { String caseName ->
        this.caseName = caseName
    }

    def matches = { boolean condition ->
        this.condition = condition
    }

    def returns = { double adjustment ->
        this.adjustment = adjustment
    }

}
