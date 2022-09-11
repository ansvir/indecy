package org.itique.indecy.core.groovy


import org.itique.indecy.core.dsl.FlowDsl

//new Flow() [
//        Case INIT_CASE [
//        ExampleBranch { params -> params.PENALTIES > 20.0 & params.PERFORMANCE < 10.0 & params.PROGRESS == 0.5 }
//        ExampleBranch2 { params.PENALTIES > 15.0 & params.PERFORMANCE < 11.0 & params.PROGRESS == 0.2 },
//        ExampleBranch3 { params.PENALTIES > 20.0 & params.PERFORMANCE < 10.0 & params.PROGRESS == 0.5 },
//        ExampleBranch4 { params.PENALTIES > 15.0 & params.PERFORMANCE < 11.0 & params.PROGRESS == 0.2 }
//],
//        Case INIT_CASE_2 [
//        ExampleBranch5 { params.PENALTIES > 20.0 & params.PERFORMANCE < 10.0 & params.PROGRESS == 0.5 },
//        ExampleBranch6 { params.PENALTIES > 15.0 & params.PERFORMANCE < 11.0 & params.PROGRESS == 0.2 }
//],
//        Case INIT_CASE_3 [
//        ExampleBranch7 { params.PENALTIES > 15.0 & params.PERFORMANCE < 11.0 & params.PROGRESS == 0.2 },
//        ExampleBranch8 { params.PENALTIES > 20.0 & params.PERFORMANCE < 10.0 & params.PROGRESS == 0.5 },
//        ExampleBranch9 { params.PENALTIES > 15.0 & params.PERFORMANCE < 11.0 & params.PROGRESS == 0.2 }
//]
//]

FlowDsl.openFlow {
    name "INIT_FLOW"
    cases {
        caseDef("INIT_CASE") {
            branches {
                branch "INIT_BRANCH" targeting "SOME_BRANCH" matches 1.0 + 1.0 > 2.0 returns 1.0
                branch "INIT_BRANCH2" targeting "SOME_CASE" matches 1.0 + 2.0 < 10.0 returns 2.0
                branch "INIT_BRANCH2" targeting "SOME_CASE" matches 1.0 + 2.0 < 10.0 returns 2.0
                branch "INIT_BRANCH2" targeting "SOME_CASE" matches 1.0 + 2.0 < 10.0 returns 2.0
                branch "INIT_BRANCH2" targeting "SOME_CASE" matches 1.0 + 2.0 < 10.0 returns 2.0
            }
            defaultBranch {
                branch "DSADSA" targeting "DSADSA"
            }

        }
        caseDef("INIT_CASE2") {
            branches { params ->
                branch "INIT_BRANCH" targeting "SOME_BRANCH" matches 1.0 + 1.0 > 2.0 returns 1.0
            }
            branches { params ->
                branch "INIT_BRANCH" targeting "SOME_BRANCH" matches 1.0 + 1.0 > 2.0 returns 1.0
            }
            branches { params ->
                branch "INIT_BRANCH" targeting "SOME_BRANCH" matches 1.0 + 1.0 > 2.0 returns 1.0
            }
        }
    }
}