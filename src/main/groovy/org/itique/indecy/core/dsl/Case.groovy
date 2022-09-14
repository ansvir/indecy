package org.itique.indecy.core.dsl

abstract class Case {

    String name
    Branches branches
    DefaultBranch defaultBranch
    protected Closure closure
    Option[] options

    enum Option {
        IS_FIRST
    }

}