package org.itique.indecy.coregroovy.dsl

class RegularDefaultBranch extends DefaultBranch {

    Branch defaultBranch

    def branch_targeting = { caseName ->
        [returns: { double adjustment ->
            RegularBranch branch = new RegularBranch()
            branch.targeting caseName
            branch.matches true
            branch.returns adjustment
            this.defaultBranch = branch
        }]
    }

}
