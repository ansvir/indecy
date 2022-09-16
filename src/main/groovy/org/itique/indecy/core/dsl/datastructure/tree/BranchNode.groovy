package org.itique.indecy.core.dsl.datastructure.tree

import org.itique.indecy.core.dsl.BranchOption

class BranchNode {

    CaseNode targetCase
    boolean condition
    Double adjustment
    List<BranchOption> options

}
