package net.sf.jsqlparser.util.deparser;

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
              .append(" ");
        ExpressionDeParser expressionDeParser = new ExpressionDeParser(null, buffer);
        try {
            createFuzzyDomain.getValues().accept(expressionDeParser);
        } catch (Exception e) {
        }
    }

    public StringBuffer getBuffer() {
        return buffer;
    }

    public void setBuffer(StringBuffer buffer) {
        this.buffer = buffer;
    }
}
