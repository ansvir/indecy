package org.itique.indecy.core.dsl

class FlowDsl {

    String name
    Map<String, Double> params
    double initValue

    FlowDsl(Map<String, Double> params, Double initValue) {
        this.params = params
        this.initValue = initValue
    }

    static void openFlow(@DelegatesTo(value = FlowDsl.class, strategy = Closure.DELEGATE_ONLY) Closure closure) {
        closure.delegate = this
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        closure.call()
    }

    void name(String name) {
        this.name = name;
    }

    void cases(@DelegatesTo(value = CasesDsl.class, strategy = Closure.DELEGATE_ONLY) Closure closure) {
        CasesDsl casesDsl = new CasesDsl()
        closure.delegate = casesDsl
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        closure.call()
    }

}
