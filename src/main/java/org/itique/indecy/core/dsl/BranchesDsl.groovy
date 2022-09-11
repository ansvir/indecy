package org.itique.indecy.core.dsl

class BranchesDsl {

    BranchDsl[] branches

    BranchesDsl() {
        this.branches = []
    }

    def branch = { String name ->
        BranchDsl branch = new BranchDsl()
        branch.branch name
        [targeting: { String caseName ->
            branch.targeting caseName
            [matches: { boolean condition ->
                branch.matches condition
                [returns: { double adjustment ->
                    branch.returns adjustment
                }]
            }]
        }]

        branches << branch
    }
}
