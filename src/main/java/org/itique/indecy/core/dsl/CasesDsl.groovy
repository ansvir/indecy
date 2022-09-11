package org.itique.indecy.core.dsl

class CasesDsl {

    CaseDsl[] cases

    def caseDef(String name, @DelegatesTo(value = CaseDsl.class, strategy = Closure.DELEGATE_ONLY) Closure closure) {
        CaseDsl newCase = new CaseDsl(name, closure)
        cases << newCase
        closure.delegate = newCase
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        closure.call()
    }

}
