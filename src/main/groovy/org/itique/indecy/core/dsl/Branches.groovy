package org.itique.indecy.core.dsl

class Branches {

    List<Branch> branches

    Branches() {
        this.branches = new ArrayList<>()
    }

    def branch_targeting = { caseName ->
        [matches: { Boolean condition ->
            [returns: { Double adjustment ->
                Branch branch = new Branch()
                branch.targeting caseName
                branch.matches condition
                branch.returns adjustment
                branches.add(branch)
            }]
        }]
    }
}
