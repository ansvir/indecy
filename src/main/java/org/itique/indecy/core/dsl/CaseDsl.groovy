package org.itique.indecy.core.dsl

class CaseDsl {

    private String name
    private BranchDsl[] branches

    CaseDsl() {
        branches = []
    }

    void name(String name) {
        this.name = name
    }

    void branchDef(@DelegatesTo(value = BranchDsl.class, strategy = Closure.DELEGATE_ONLY) Closure closure) {
        BranchDsl branch = new BranchDsl()
        branches << branch
        closure.delegate = branch
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        closure.call()
    }

    void branchDef(BranchDsl branch) {
        branches << branch
    }

    void defaultBranch(@DelegatesTo(value = BranchDsl, strategy = Closure.DELEGATE_ONLY) Closure closure) {
        branchDef(closure)
    }

    void defaultBranch(BranchDsl branch) {
        branches << branch
    }

}
