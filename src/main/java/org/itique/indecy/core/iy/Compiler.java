package org.itique.indecy.core.iy;


public class Compiler {

    // regex's
    private static final String IY_DATATYPE = "(boolean|decimal)";
    private static final String IY_VARIABLE_NAME = "([_A-Za-z]{1}[0-9_A-Za-z]{1,19})";
    private static final String IY_FLOW_NAME = IY_VARIABLE_NAME;
    private static final String IY_FLOW_DECLARATION = IY_DATATYPE + "\\s[\\s\\t]*"
            + IY_FLOW_NAME + "[\\s\\t]*:[\\s\\t]*[\\s\\t\\n]*";
    private static final String IY_EXPRESSIONS_START = "\\t";
    private static final String IY_COMPARISON_OPERATORS = "(>|<|<=|>=|=|!=)";
    private static final String IY_STATIC_VALUE = "\\[0-9]{1,10}\\.[0-9]{1,10}";
    private static final String IY_STATIC_PARAMETER = IY_VARIABLE_NAME + "[\\s\\t]*=[\\s\\t]*" + IY_STATIC_VALUE;
    private static final String IY_STATIC_PARAMETERS_LIST = "(\\((" + IY_STATIC_PARAMETER + "){1,}\\))*";
    private static final String IY_LOGICAL_OPERATORS = "(AND|OR|AND NOT|OR NOT)";
    private static final String IY_EXPRESSION = IY_EXPRESSIONS_START + IY_VARIABLE_NAME
            + IY_VARIABLE_NAME + "\\." + IY_VARIABLE_NAME;

    public void compile(byte[] iy) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0 ; i < iy.length; i++) {
            char character = (char) iy[i];

            stringBuilder.append((char) iy[i]);
        }
    }
}
