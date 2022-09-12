package org.itique.indecy.core.dsl

class Case {

    String name
    Branches branches
    DefaultBranch defaultBranch
    private Closure closure

    Case(String name, Closure closure) {
        this.name = name
        this.closure = closure
        this.branches = new Branches()
        this.defaultBranch = new DefaultBranch()
    }

    def branches(@DelegatesTo(value = Branches.class, strategy = Closure.DELEGATE_ONLY) Closure closure) {
        closure.delegate = branches
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        closure.call()
    }

    def defaultBranch(@DelegatesTo(value = DefaultBranch.class, strategy = Closure.DELEGATE_ONLY) Closure closure) {
        closure.delegate = defaultBranch
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        closure.call()
    }

}
