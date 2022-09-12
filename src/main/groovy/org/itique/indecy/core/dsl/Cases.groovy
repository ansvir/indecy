package org.itique.indecy.core.dsl

class Cases {

    List<Case> cases
    FinalCase finalCase

    Cases() {
        cases = new LinkedList<>()
    }

    def declareCase(String name, @DelegatesTo(value = Case.class, strategy = Closure.DELEGATE_ONLY) Closure closure) {
        Case newCase = new Case(name, closure)
        cases.add(newCase)
        closure.delegate = newCase
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        closure.call()
    }

    def declareFinalCase(@DelegatesTo(value = FinalCase.class, strategy = Closure.DELEGATE_ONLY) Closure closure) {
        this.finalCase = new FinalCase(closure)
        closure.delegate = this.finalCase
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        closure.call()
    }

}
