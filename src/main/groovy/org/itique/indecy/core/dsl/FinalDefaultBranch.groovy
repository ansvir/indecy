package org.itique.indecy.core.dsl

import org.itique.indecy.core.dsl.constant.TargetStrategy

class FinalDefaultBranch {

    Branch defaultBranch

    def returns = { result ->
        Branch branch = new Branch()
        branch.targeting TargetStrategy.NONE
        branch.matches true
        branch.returns result
        this.defaultBranch = branch
    }

}
