package org.itique.indecy.core.groovy

import org.itique.indecy.core.dsl.Case
import org.itique.indecy.core.dsl.RegularCase
import org.itique.indecy.core.dsl.Flow

import static org.itique.indecy.core.dsl.constant.TargetStrategy.FINAL_CASE

// This example flow describes influence of awarding employees with bonuses
//
// Next cases can be declared in any order, considering they should target to some other case except final case
// All values are abstract in this example. You can use next script with parameters like:
// branch_targeting ERI
//    matches params.PENALTIES + 100.0 < params.MAX_PENALTIES
//        & params.PROGRESS <= 0.5
//        & params.PERFORMANCE + 0.2 > 11.0
//    returns 1.5
//
// Original parameters come from Java code within addParam(key, value) method

// This variables contain cases names.
// It's optional to declare them as a variables, they can be constants or enum values
def PI = "POSITIVE_IMPACT_CASE"
def ERI = "EQUIPMENT_RATE_INCREASE_CASE"

Flow.declare {

    declareCase(PI) {
        branches {
            branch_targeting ERI matches 1.0 + 2.0 > 10.0 returns 2.0
            branch_targeting ERI matches 1.0 - 2.0 < 10.0 returns -0.5
            branch_targeting ERI matches 1.0 + 2.0 + 5.5 >= 10.0 returns 1.5
        }
        defaultBranch {
            branch_targeting FINAL_CASE returns 1.0
        }
        options Case.Option.IS_FIRST
    }

    declareCase(ERI) {
        branches {
            branch_targeting FINAL_CASE matches 100.0 * 1.5 < 10.0 returns 0.5
            branch_targeting FINAL_CASE matches 20.0 + 2.0 > 10.0 returns 0.7
            branch_targeting FINAL_CASE matches 1.0 + 2.0 >= 10.0 returns -0.1
        }
        defaultBranch {
            branch_targeting FINAL_CASE returns 2.0
        }
        options RegularCase.Option.IS_FIRST
    }

    declareFinalCase {
        branches {
            branch_matches 20.0 + 0.5 == 20.6 returns 1.0
            branch_matches 1.0 - 0.5 == 0.5 & 10.0 >= 0.1 returns 1.1
            branch_matches 0.1 + 0.2 + 1.3 + 0.57 > 3.0 returns 0.09
        }
        defaultBranch {
            returns 1.0
        }
    }

}