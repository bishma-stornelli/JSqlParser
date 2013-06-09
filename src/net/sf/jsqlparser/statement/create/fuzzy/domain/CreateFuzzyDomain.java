package net.sf.jsqlparser.statement.create.fuzzy.domain;

import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.operators.relational.ExpressionList;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.StatementVisitor;

/**
 * A "CREATE FUZZY DOMAIN" statement
 */
public class CreateFuzzyDomain implements Statement {

    private String name;
    private ExpressionList values;

    public CreateFuzzyDomain(String name, ExpressionList values) {
        this.name = name;
        this.values = values;
    }

    public void accept(StatementVisitor statementVisitor) throws Exception {
        statementVisitor.visit(this);
    }

    /**
     * The name of the fuzzy domain to be created
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * A list of {@link Expression}s of this fuzzy domain. Only strings not
     * validated by the parser
     */
    public ExpressionList getValues() {
        return values;
    }

    public void setValues(ExpressionList values) {
        this.values = values;
    }

    public String toString() {
        return "CREATE FUZZY DOMAIN " + name + " (" + values.toString() + ") ";
    }
}