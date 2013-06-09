package net.sf.jsqlparser.util.deparser;

import net.sf.jsqlparser.expression.Similarity;
import net.sf.jsqlparser.expression.operators.relational.ExpressionList;
import net.sf.jsqlparser.statement.create.fuzzy.domain.CreateFuzzyDomain;

/**
 * A class to de-parse (that is, tranform from JSqlParser hierarchy into a string)
 * a {@link net.sf.jsqlparser.statement.create.table.CreateTable}
 */
public class CreateFuzzyDomainDeParser {

    protected StringBuffer buffer;

    /**
     * @param buffer the buffer that will be filled with the select
     */
    public CreateFuzzyDomainDeParser(StringBuffer buffer) {
        this.buffer = buffer;
    }

    public void deParse(CreateFuzzyDomain createFuzzyDomain) {
        buffer.append("CREATE FUZZY DOMAIN ")
              .append(createFuzzyDomain.getName())
              .append(" AS VALUES ");
        ExpressionDeParser expressionDeParser = new ExpressionDeParser(null, buffer);
        try {
            createFuzzyDomain.getValues().accept(expressionDeParser);
        } catch (Exception e) {
        }
        if (createFuzzyDomain.getSimilarities().getExpressions().size() > 0) {
            expressionDeParser.setUseBracketsInExprList(false);
            buffer.append(" SIMILARITY {");
            try {
                createFuzzyDomain.getSimilarities().accept(expressionDeParser);
            } catch (Exception e) {
            }
            buffer.append("}");
            expressionDeParser.setUseBracketsInExprList(true);
        }
    }

    public StringBuffer getBuffer() {
        return buffer;
    }

    public void setBuffer(StringBuffer buffer) {
        this.buffer = buffer;
    }
}
