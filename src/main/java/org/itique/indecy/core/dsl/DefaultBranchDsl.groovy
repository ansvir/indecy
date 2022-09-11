package org.itique.indecy.core.dsl

class DefaultBranchDsl {

    BranchDsl defaultBranch

    def branch = { String name ->
        BranchDsl branch = new BranchDsl()
        branch.branch name
        [targeting: { String caseName ->
            branch.targeting caseName
            [returns: { double adjustment ->
                branch.returns adjustment
            }]
        }]

        defaultBranch = branch
    }

}
