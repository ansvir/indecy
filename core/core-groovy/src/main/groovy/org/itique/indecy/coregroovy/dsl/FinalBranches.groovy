package org.itique.indecy.coregroovy.dsl

import org.itique.indecy.coregroovy.dsl.constant.TargetStrategy

class FinalBranches extends Branches {

    List<Branch> branches

    FinalBranches() {
        this.branches = new ArrayList<>()
    }

    def branch_matches = { Boolean condition ->
        [returns: { Double adjustment ->
            RegularBranch branch = new RegularBranch()
            branch.targeting TargetStrategy.NONE
            branch.matches condition
            branch.returns adjustment
            branches.add(branch)
        }]
    }

}
