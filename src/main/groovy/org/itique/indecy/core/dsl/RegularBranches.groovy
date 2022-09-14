package org.itique.indecy.core.dsl

class RegularBranches extends Branches {

    List<Branch> branches

    RegularBranches() {
        this.branches = new ArrayList<>()
    }

    def branch_targeting = { caseName ->
        [matches: { Boolean condition ->
            [returns: { Double adjustment ->
                RegularBranch branch = new RegularBranch()
                branch.targeting caseName
                branch.matches condition
                branch.returns adjustment
                branches.add(branch)
            }]
        }]
    }
}
