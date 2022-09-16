package org.itique.indecy.core.dsl.datastructure.tree

import org.itique.indecy.core.dsl.CaseOption

class CaseNode {
    String name
    List<BranchNode> branches
    List<CaseOption> options
}
