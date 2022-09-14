package org.itique.indecy.core.dsl

import org.itique.indecy.core.dsl.constant.TargetStrategy

class FinalDefaultBranch extends DefaultBranch {

    Branch defaultBranch

    def returns = { result ->
        RegularBranch branch = new RegularBranch()
        branch.targeting TargetStrategy.NONE
        branch.matches true
        branch.returns result
        this.defaultBranch = branch
    }

}