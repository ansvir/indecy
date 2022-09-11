package org.itique.indecy.core.flow;

import org.itique.indecy.core.datatype.Index;

public interface Branchable {

    boolean execute();
    Index adjustment();

}
