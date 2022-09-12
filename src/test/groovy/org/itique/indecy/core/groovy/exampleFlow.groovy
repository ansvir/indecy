package org.itique.indecy.core.groovy


import org.itique.indecy.core.dsl.Flow
import static org.itique.indecy.core.dsl.constant.TargetStrategy.FINAL_CASE

Flow.declare {
    declareCase("INIT_CASE") {
        branches {
            branch_targeting FINAL_CASE matches 1.0 + 2.0 < 10.0 returns 1.0
            branch_targeting FINAL_CASE matches 1.0 + 2.0 > 10.0 returns 1.0
            branch_targeting FINAL_CASE matches 1.0 + 2.0 >= 10.0 returns 1.0
        }
        defaultBranch {
            branch_targeting FINAL_CASE returns 2.0
        }
    }
    declareFinalCase {
        branches {
            branch_matches 2.0 == 1.0 returns 3.0
            branch_matches 2.0 == 1.0 returns 3.0
            branch_matches 2.0 == 1.0 returns 3.0
        }
        defaultBranch {
            returns 2.0
        }
    }
}