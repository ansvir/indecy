package org.itique.indecy.core.dsl

class Cases {

    List<Case> cases

    Cases() {
        cases = new LinkedList<>()
    }

    def declareCase(String name, @DelegatesTo(value = RegularCase.class, strategy = Closure.DELEGATE_ONLY) Closure closure) {
        RegularCase newCase = new RegularCase(name, closure)
        cases.add(newCase)
        closure.delegate = newCase
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        closure.call()
    }

    def declareFinalCase(@DelegatesTo(value = FinalCase.class, strategy = Closure.DELEGATE_ONLY) Closure closure) {
        FinalCase finalCase = new FinalCase(closure)
        cases.add(finalCase)
        closure.delegate = finalCase
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        closure.call()
    }

}
