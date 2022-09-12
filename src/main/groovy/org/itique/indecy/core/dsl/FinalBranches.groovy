package org.itique.indecy.core.dsl

import org.itique.indecy.core.dsl.constant.TargetStrategy

class FinalBranches {

    List<Branch> branches

    FinalBranches() {
        this.branches = new ArrayList<>()
    }

    def branch_matches = { Boolean condition ->
        [returns: { Double adjustment ->
            Branch branch = new Branch()
            branch.targeting TargetStrategy.NONE
            branch.matches condition
            branch.returns adjustment
            branches.add(branch)
        }]
    }

}
