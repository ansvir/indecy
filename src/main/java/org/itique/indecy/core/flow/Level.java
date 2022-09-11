package org.itique.indecy.core.flow;

import lombok.Data;

import java.util.Set;

@Data
public class Level {

    private Set<Branchable> nodes;
    private Long level;

}
