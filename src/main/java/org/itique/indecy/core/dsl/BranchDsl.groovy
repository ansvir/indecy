package org.itique.indecy.core.dsl

import jdk.internal.joptsimple.internal.Strings

class BranchDsl {

    String name
    String caseName
    boolean condition
    double adjustment

    def branch = { String name ->
        if (name || name == Strings.EMPTY) {
            throw new IllegalArgumentException("Branch name should not be null or empty!")
        }
        this.name = name
    }

    def targeting = { String caseName ->
        if (caseName || caseName == Strings.EMPTY) {
            throw new IllegalArgumentException("Target branch name should not be null or empty!")
        }
        this.caseName = caseName
    }

    def matches = { boolean condition ->
        this.condition = condition
    }

    def returns = { double adjustment ->
        this.adjustment = adjustment
    }

}
