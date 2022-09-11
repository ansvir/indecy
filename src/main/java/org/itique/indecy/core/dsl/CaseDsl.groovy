package org.itique.indecy.core.dsl

class CaseDsl {

    private String name
    private BranchesDsl branches
    private BranchDsl defaultBranch
    private Closure closure

    CaseDsl(String name, Closure closure) {
        this.name = name
        this.closure = closure
    }

    def branches(@DelegatesTo(value = BranchesDsl.class, strategy = Closure.DELEGATE_ONLY) Closure closure) {
        BranchesDsl branches = new BranchesDsl()
        closure.delegate = branches
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        closure.call()
    }

    def branches(BranchDsl branch) {
        if (!branch) {
            throw new IllegalArgumentException("Branch should not be null!")
        }
        branches << branch
    }

    def defaultBranch(@DelegatesTo(value = DefaultBranchDsl.class, strategy = Closure.DELEGATE_ONLY) Closure closure) {
        DefaultBranchDsl branch = new DefaultBranchDsl()
        closure.delegate = branch
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        closure.call()
    }

    def defaultBranch(BranchDsl branch) {
        if (!branch) {
            throw new IllegalArgumentException("Default branch should not be null!")
        }
        defaultBranch = branch
    }

}
