package org.itique.indecy.core.dsl

class RegularBranch extends Branch {

    def targeting = { String targetCase ->
        this.targetCase = targetCase
    }

    def matches = { boolean condition ->
        this.condition = condition
    }

    def returns = { double adjustment ->
        this.adjustment = adjustment
    }

}
