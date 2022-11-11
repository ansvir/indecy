package org.itique.indecy.coregroovy.dsl

import org.itique.indecy.coregroovy.dsl.constant.TargetStrategy

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