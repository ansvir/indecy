package org.itique.indecy.core.flow;

import org.itique.indecy.core.annotation.Branch;
import org.itique.indecy.core.annotation.Parameter;
import org.itique.indecy.core.datatype.Index;

@Branch(caseName = "case2", targetCase = ExampleBranch2.class)
public class ExampleBranch2 implements Branchable {

    @Parameter
    private Integer value;
    @Parameter
    private Integer value2;

    @Override
    public boolean execute() {
        return (value * value) > 20;
    }

    @Override
    public Index adjustment() {
        return Index.of(0.1);
    }

}