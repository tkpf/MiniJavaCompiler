package parser.adapter;

import parser.exceptions.EscapeHatchException;
import parser.production.JavaMiniParser;
import syntaxtree.expressions.*;

public class TypeLiteralAdapter {

    static Expression adapt(JavaMiniParser.TypeLiteralContext ctx) throws EscapeHatchException {
        if (ctx.BoolLiteral() != null) {
            return new BoolExpr(
                    Boolean.parseBoolean(
                            ctx.BoolLiteral().getText()));
        }
        else if (ctx.CharacterLiteral() != null) {
            return new CharExpr(
                    ctx.CharacterLiteral().getText().charAt(1));
        }
        else if (ctx.DecimalLiteral() != null) {
            return new IntegerExpr(
                    Integer.parseInt(ctx.DecimalLiteral().getText()));
        }
        else if (ctx.StringLiteral() != null) {

            String originalString = ctx.StringLiteral().getText();
            String stringWithoutQuotes = originalString.substring(1, originalString.length() - 1);
            // Unescape Java escape sequences in string
            String unescapedString = unescapeJava(stringWithoutQuotes);
            return new StringExpr(unescapedString);
        }
        else if (ctx.NullLiteral() != null) {
            return new JNullExpr();
        }
        else {
            // should never be reached
            throw new EscapeHatchException();
        }
    }

    public static String unescapeJava(String str) {
        if (str == null) {
            return null;
        }
        int len = str.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (c == '\\') {
                if (i < len - 1) {
                    char nextChar = str.charAt(i + 1);
                    switch (nextChar) {
                        case '\"' -> sb.append('\"');
                        case '\'' -> sb.append('\'');
                        case '\\' -> sb.append('\\');
                        case 'r' -> sb.append('\r');
                        case 'n' -> sb.append('\n');
                        case 'f' -> sb.append('\f');
                        case 't' -> sb.append('\t');
                        case 'b' -> sb.append('\b');
                        default -> {
                            sb.append('\\');
                            sb.append(nextChar);
                        }
                    }
                    i++;
                } else {
                    sb.append('\\');
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }


}
