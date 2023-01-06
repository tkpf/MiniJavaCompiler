package parser.adapter;

import syntaxtree.expressions.BinaryExpr;
import syntaxtree.expressions.Expression;

public class BinaryExpressionAdapter {
    static Expression adapt(Expression expr1, Expression expr2, String op) {
        return new BinaryExpr(expr1, expr2, op);
    }

}
    /*
    static PrimaryExpr adapt(PrimaryExpr expr1, PrimaryExpr expr2, String op) {
        String[] calcOp = {"*", "/", "%", "+", "-"};
        String[] compOp = {">", "<", ">=", "<=", "==", "!="};
        String[] quanOp = {"&&", "||"};

        List<String> ops = new ArrayList<>();
        ops.addAll(Arrays.asList(calcOp));
        ops.addAll(Arrays.asList(compOp));
        ops.addAll(Arrays.asList(quanOp));

        if (ops.indexOf(op) < calcOp.length)  {
            return adaptIntToInt(expr1, expr2, op);
        }
        else if (ops.indexOf(op) >= calcOp.length
                && ops.indexOf(op) < (calcOp.length + compOp.length)) {
            return adaptIntToBool(expr1, expr2, op);
        }
        else if (ops.indexOf(op) >= (calcOp.length + compOp.length)) {
            return adaptBoolToBool(expr1, expr2, op);
        }
        else {
            return null; // is never reached
        }
    }

    private static IntegerExpr adaptIntToInt(PrimaryExpr expr1, PrimaryExpr expr2, String op) {
        int op1 = Integer.parseInt(expr1.getValue());
        int op2 = Integer.parseInt(expr2.getValue());
        int res = switch (op) {
            case "*" -> op1 * op2;
            case "/" -> op1 / op2;
            case "%" -> op1 % op2;
            case "+" -> op1 + op2;
            case "-" -> op1 - op2;
            default -> 99999999; // never reached
        };
        return new IntegerExpr(res);
    }

    private static BoolExpr adaptIntToBool(PrimaryExpr expr1, PrimaryExpr expr2, String op) {
        int op1 = Integer.parseInt(expr1.getValue());
        int op2 = Integer.parseInt(expr2.getValue());
        boolean res = switch (op) {
            case ">" -> op1 > op2;
            case "<" -> op1 < op2;
            case ">=" -> op1 >= op2;
            case "<=" -> op1 <= op2;
            case "==" -> op1 == op2;
            case "!=" -> op1 != op2;
            default -> false; // never reached
        };
        return new BoolExpr(res);
    }

    private static BoolExpr adaptBoolToBool(PrimaryExpr expr1, PrimaryExpr expr2, String op) {
        boolean op1 = Boolean.parseBoolean(expr1.getValue());
        boolean op2 = Boolean.parseBoolean(expr2.getValue());
        boolean res = switch (op) {
            case "&&" -> op1 && op2;
            case "||" -> op1 || op2;
            default -> false; // never reached
        };
        return new BoolExpr(res);
    }

*/

