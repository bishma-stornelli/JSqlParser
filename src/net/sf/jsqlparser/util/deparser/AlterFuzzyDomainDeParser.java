package net.sf.jsqlparser.util.deparser;

import net.sf.jsqlparser.statement.alter.fuzzy.domain.AlterFuzzyDomain;

/**
 * A class to de-parse (that is, tranform from JSqlParser hierarchy into a string)
 * a {@link net.sf.jsqlparser.statement.create.table.CreateTable}
 */
public class AlterFuzzyDomainDeParser {

    protected StringBuffer buffer;

    /**
     * @param buffer the buffer that will be filled with the select
     */
    public AlterFuzzyDomainDeParser(StringBuffer buffer) {
        this.buffer = buffer;
    }

    public void deParse(AlterFuzzyDomain alterFuzzyDomain) {
        buffer.append("CREATE FUZZY DOMAIN ")
              .append(alterFuzzyDomain.getName());
        ExpressionDeParser expressionDeParser = new ExpressionDeParser(null, buffer);
        if (null != alterFuzzyDomain.getAddValues()) {
            buffer.append(" ADD VALUES ");
            try{
                alterFuzzyDomain.getAddValues().accept(expressionDeParser);
            }catch(Exception e) {};
        } else if (null != alterFuzzyDomain.getAddSimilarity()) {
            buffer.append(" ADD SIMILARITY {");
            expressionDeParser.setUseBracketsInExprList(false);
            try{
                alterFuzzyDomain.getAddSimilarity().accept(expressionDeParser);
            }catch(Exception e) {};
            expressionDeParser.setUseBracketsInExprList(true);
            buffer.append("}");
        } else if (null != alterFuzzyDomain.getDropValues()) {
            buffer.append(" DROP VALUES ");
            try{
                alterFuzzyDomain.getDropValues().accept(expressionDeParser);
            }catch(Exception e) {};
        } else if (null != alterFuzzyDomain.getDropSimilarity()) {
            buffer.append(" DROP SIMILARITY {");
            expressionDeParser.setUseBracketsInExprList(false);
            try{
                alterFuzzyDomain.getDropSimilarity().accept(expressionDeParser);
            }catch(Exception e) {};
            expressionDeParser.setUseBracketsInExprList(true);
            buffer.append("}");
        }
    }

    public StringBuffer getBuffer() {
        return buffer;
    }

    public void setBuffer(StringBuffer buffer) {
        this.buffer = buffer;
    }
}
