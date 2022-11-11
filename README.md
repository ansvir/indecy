# Indecy Core

## Description:
The main goal of project - to simplify displaying a business flow sequences in the view of tree (Groovy).
Was created DSL using Groovy and implemented business logic in Java to run custom declared DSL scripts.

There are **three** main components in Indecy:
1. Flow
2. Cases
3. Branches

Flow - aggregation of cases, consider it like business process. Cases - single subprocess that contains business rules - branches.
Generally, `switch` instruction in Java is very similar to logic of Indecy in current version.

**Note**: Currently validation is not implemented, so, you cannot have two regular branches that fit specified condition!
## Sample usage
### Example 1:
#### Prerequisites:
1. We have example flow (DSL script): `org/itique/indecy/core/groovy/bonusesFlow.groovy`
2. We have next declaration: 
```java
double startIndex = 1.0;

IndecyFlow flow = IndecyFlow.builder(startIndex)
        .runFlow(new File(BONUSES_FLOW_PATH));

System.out.println(flow.getResult().doubleValue());
```

Console output will be `2.3` (after rounding)
### Example 2 (with parameters):
#### Prerequisites:
1. We have example flow (DSL script): `org/itique/indecy/core/groovy/parametrizedBonusesFlow.groovy`
2. We have next declaration:
```java
private static final String PERFORMANCE = "PERFORMANCE";
private static final String PENALTIES = "PENALTIES";
private static final String MAX_PENALTIES = "MAX_PENALTIES";
private static final String PROGRESS = "PROGRESS";

// ...
        
double startIndex = 1.0;

IndecyFlow flow = IndecyFlow.builder(startIndex)
        .addParam(PERFORMANCE, 0.3)
        .addParam(PENALTIES, 30.0)
        .addParam(MAX_PENALTIES, 200.0)
        .addParam(PROGRESS, 0.2)
        .runFlow(new File(PARAMETRIZED_BONUSES_FLOW_PATH));

System.out.println(flow.getResult().doubleValue());
```

Console output will be `3.8` (after rounding)
### Changelog
Version 1.0.1-SNAPSHOT

- Added parameters
- Added default values
- Added tests

Version 1.0-SNAPSHOT

- Developed MVP

### TODO (In order of priority):
1. Add dynamically branch returned result to parameters
2. Add validation
3. Move `org.itique.indecy.core.dsl.FinalCase` to `org.itique.indecy.core.dsl.Case.Option`
