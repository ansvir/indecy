package org.itique.indecy.core.flow;

import org.itique.indecy.core.dsl.Branch;
import org.itique.indecy.core.dsl.Case;
import org.itique.indecy.core.dsl.Cases;
import org.itique.indecy.core.dsl.DslScript;
import org.itique.indecy.core.dsl.FinalCase;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.itique.indecy.core.dsl.constant.TargetStrategy.FINAL_CASE;

public class IndecyFlow {

    private Double result;

    private IndecyFlow(Double result) {
        this.result = result;
    }

    public Double getResult() {
        return this.result;
    }

    public static Builder builder(Double initValue) {
        return new Builder(initValue);
    }

    public static class Builder {

        private final Map<String, Double> params;
        private final Double initValue;

        public Builder(Double initValue) {
            this.params = new HashMap<>();
            this.initValue = initValue;
        }

        public Builder addParam(String key, Double value) {
            this.params.put(key, value);
            return this;
        }

        public IndecyFlow runFlow(File file) {
            DslScript script = new DslScript(params, file);
            Cases casesDsl = (Cases) script.run();
            List<Case> cases = casesDsl.getCases();
            FinalCase finalCase = casesDsl.getFinalCase();
            Double result = initValue;
//            AtomicReference<Double> result = new AtomicReference<>(initValue);
//            try {
            for (Case c : cases) {
                Case nextTargetCase = null;
                for (Case targetCase : cases) {
                    nextTargetCase = targetCase;
                    Branch defBranch = c.getDefaultBranch().getDefaultBranch();
                    Branch matchedBranch = c.getBranches().getBranches().stream()
                            .filter(Branch::getCondition).findFirst().orElse(defBranch);
                    if (!targetCase.getName().equals(FINAL_CASE)) {
                        if (targetCase.getName().equals(matchedBranch.getCaseName())) {
                            result += matchedBranch.getAdjustment();
                        }
                    } else {
                        Branch finalDefBranch = finalCase.getDefaultBranch().getDefaultBranch();
                        Branch finalMatchedBranch = finalCase.getBranches().getBranches().stream()
                                .filter(Branch::getCondition).findFirst().orElse(finalDefBranch);
                        result += finalMatchedBranch.getAdjustment();
                        break;
                    }
                }

                if (nextTargetCase.getName().equals(FINAL_CASE)) {
                    break;
                }
            }
//                cases.forEach(targetCase ->
//                        cases.forEach(c -> {
//                            Branch defBranch = targetCase.getDefaultBranch().getDefaultBranch();
//                            Branch matchedBranch = targetCase.getBranches().getBranches().stream()
//                                    .filter(Branch::getCondition).findFirst().orElse(defBranch);
//                            if (c.getName() != null) {
//                                if (c.getName().equals(matchedBranch.getCaseName())) {
//                                    result.set(result.get() + matchedBranch.getAdjustment());
//                                }
//                            } else {
//                                result.set(result.get() + matchedBranch.getAdjustment());
//                                throw new LoopInterruptionException();
//                            }
//                        }));
//            } catch (LoopInterruptionException e) {
//                // stub
//            }
            return new IndecyFlow(result);
        }

    }

}
