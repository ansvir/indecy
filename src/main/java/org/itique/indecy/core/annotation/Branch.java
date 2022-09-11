package org.itique.indecy.core.annotation;

import org.itique.indecy.core.flow.Branchable;
import org.itique.indecy.core.flow.RootBranch;

public @interface Branch {

    boolean isDefault() default false;
    String caseName();
    Class<? extends Branchable> targetCase() default RootBranch.class;

}
