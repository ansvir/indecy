package org.itique.indecy.core.flow;

import org.itique.indecy.core.dsl.Branch;
import org.itique.indecy.core.dsl.Case;
import org.itique.indecy.core.dsl.Cases;
import org.itique.indecy.core.dsl.FinalCase;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.itique.indecy.core.dsl.constant.TargetStrategy.FINAL_CASE;

public class IndecyFlow {

    private final Double result;

    private IndecyFlow(Double result) {
        this.result = result;
    }

    public Double getResult() {
        return result;
    }

    public static Runner.Builder builder(Double initValue) {
        return new Runner.Builder(initValue);
    }

    public static class Runner extends IndecyContext {

        private final Double initValue;

        public Runner(Map<Object, Double> params, Double initValue, File scriptFile) {
            super(params, scriptFile);
            this.initValue = initValue;
        }

        public IndecyFlow runFlow() {
            Cases casesDsl = (Cases) run();
            List<Case> cases = casesDsl.getCases();
            Case finalCase = casesDsl.getCases().stream().filter(c -> c instanceof FinalCase).findFirst().get();
            Double result = initValue;
            Case targetCase = null;

            if (Arrays.stream(finalCase.getOptions()).anyMatch(o -> o == Case.Option.IS_FIRST)) {
                Branch finalDefBranch = finalCase.getDefaultBranch().getDefaultBranch();
                Branch finalMatchedBranch = finalCase.getBranches().getBranches().stream()
                        .filter(Branch::getCondition).findFirst().orElse(finalDefBranch);
                result += finalMatchedBranch.getAdjustment();
                return new IndecyFlow(result);
            } else {
                for (int i = 0; i < cases.size(); i++) {
                    if (Arrays.stream(cases.get(i).getOptions()).anyMatch(o -> o == Case.Option.IS_FIRST)) {
                        targetCase = cases.get(i);
                        break;
                    }
                }
            }

            Branch firstDefBranch = targetCase.getDefaultBranch().getDefaultBranch();
            Branch firstMatchedBranch = targetCase.getBranches().getBranches().stream()
                    .filter(Branch::getCondition).findFirst().orElse(firstDefBranch);
            result += firstMatchedBranch.getAdjustment();

            targetCase = cases.stream().filter(c -> c.getName().equals(firstMatchedBranch.getTargetCase())).findFirst().get();

            for (int i = 0; i < cases.size() + 1; i++) {
                Branch defBranch = targetCase.getDefaultBranch().getDefaultBranch();
                Branch matchedBranch = targetCase.getBranches().getBranches().stream()
                        .filter(Branch::getCondition).findFirst().orElse(defBranch);
                result += matchedBranch.getAdjustment();
                if (matchedBranch.getTargetCase().equals(FINAL_CASE)) {
                    Branch finalDefBranch = finalCase.getDefaultBranch().getDefaultBranch();
                    Branch finalMatchedBranch = finalCase.getBranches().getBranches().stream()
                            .filter(Branch::getCondition).findFirst().orElse(finalDefBranch);
                    result += finalMatchedBranch.getAdjustment();
                    break;
                }
                Optional<Case> optionalTargetCase = cases.stream().filter(c -> c.getName().equals(matchedBranch.getTargetCase())).findFirst();
                if (optionalTargetCase.isEmpty()) {
                    break;
                } else {
                    targetCase = optionalTargetCase.get();
                }
            }
            return new IndecyFlow(result);
        }

        public static class Builder {

            private final Map<Object, Double> params;
            private final Double initValue;

            public Builder(Double initValue) {
                this.params = new HashMap<>();
                this.initValue = initValue;
            }

            public Builder addParam(Object key, Double value) {
                this.params.put(key, value);
                return this;
            }

            public Runner create(File scriptFile) {
                return new Runner(params, initValue, scriptFile);
            }
        }
    }
}
