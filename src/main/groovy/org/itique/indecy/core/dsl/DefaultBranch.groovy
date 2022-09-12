package org.itique.indecy.core.dsl

class DefaultBranch {

    Branch defaultBranch

    def branch_targeting = { caseName ->
        [returns: { double adjustment ->
            Branch branch = new Branch()
            branch.targeting caseName
            branch.matches true
            branch.returns adjustment
            this.defaultBranch = branch
        }]
    }

}
