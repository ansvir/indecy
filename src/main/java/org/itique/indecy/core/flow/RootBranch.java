package org.itique.indecy.core.flow;

import org.itique.indecy.core.annotation.Branch;
import org.itique.indecy.core.datatype.Index;

@Branch(caseName = "root")
public class RootBranch implements Branchable {
    @Override
    public boolean execute() {
        return false;
    }

    @Override
    public Index adjustment() {
        return null;
    }
}
