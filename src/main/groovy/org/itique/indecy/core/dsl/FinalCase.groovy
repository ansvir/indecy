package org.itique.indecy.core.dsl

import org.itique.indecy.core.dsl.constant.TargetStrategy

class FinalCase {

    String name
    FinalBranches branches
    FinalDefaultBranch defaultBranch
    private Closure closure

    FinalCase(Closure closure) {
        this.name = TargetStrategy.FINAL_CASE
        this.closure = closure
        this.branches = new FinalBranches()
        this.defaultBranch = new FinalDefaultBranch()
    }

    def branches(@DelegatesTo(value = FinalBranches.class, strategy = Closure.DELEGATE_ONLY) Closure closure) {
        closure.delegate = branches
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        closure.call()
    }

    def defaultBranch(@DelegatesTo(value = FinalDefaultBranch.class, strategy = Closure.DELEGATE_ONLY) Closure closure) {
        closure.delegate = defaultBranch
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        closure.call()
    }

}
