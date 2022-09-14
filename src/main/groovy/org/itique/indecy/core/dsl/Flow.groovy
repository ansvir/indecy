package org.itique.indecy.core.dsl

class Flow {

    static Cases declare(@DelegatesTo(value = Cases.class, strategy = Closure.DELEGATE_ONLY) Closure closure) {
        Cases cases = new Cases()
        closure.delegate = cases
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        closure.call()
        return cases
    }

}
