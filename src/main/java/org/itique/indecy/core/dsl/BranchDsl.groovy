package org.itique.indecy.core.dsl

import jdk.internal.joptsimple.internal.Strings

class BranchDsl {

    String name
    String branchName
    boolean condition
    double adjustment

    BranchDsl branch(String name) {
        if (name || name == Strings.EMPTY) {
            throw new IllegalArgumentException("Branch name should not be null or empty!")
        }
        this.name = name
        return this
    }

    BranchDsl targeting(String branchName) {
        if (branchName || branchName == Strings.EMPTY) {
            throw new IllegalArgumentException("Target branch name should not be null or empty!")
        }
        this.branchName = branchName
        return this
    }

    BranchDsl matches(boolean condition) {
        this.condition = condition
        return this
    }

    BranchDsl returns(double adjustment) {
        this.adjustment = adjustment
        return this
    }

}
