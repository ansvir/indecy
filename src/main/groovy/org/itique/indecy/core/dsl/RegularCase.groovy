package org.itique.indecy.core.dsl

class RegularCase extends Case {

    RegularCase(String name, Closure closure) {
        this.name = name
        this.closure = closure
        this.branches = new RegularBranches()
        this.defaultBranch = new RegularDefaultBranch()
        this.options = []
    }

    def branches(@DelegatesTo(value = RegularBranches.class, strategy = Closure.DELEGATE_ONLY) Closure closure) {
        closure.delegate = branches
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        closure.call()
    }

    def defaultBranch(@DelegatesTo(value = RegularDefaultBranch.class, strategy = Closure.DELEGATE_ONLY) Closure closure) {
        closure.delegate = defaultBranch
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        closure.call()
    }

    def options(CaseOption[] options) {
        this.options = options
    }

}
