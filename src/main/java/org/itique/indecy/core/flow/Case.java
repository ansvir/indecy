package org.itique.indecy.core.flow;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class Case {

    private final Set<Branchable> branches;

    public Case() {
        this.branches = new HashSet<>();
    }

    public void addBranch(Branchable branchable) {
        this.branches.add(branchable);
    }

}
