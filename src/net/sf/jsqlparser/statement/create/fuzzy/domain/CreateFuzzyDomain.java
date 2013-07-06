package net.sf.jsqlparser.statement.create.fuzzy.domain;

import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.operators.relational.ExpressionList;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.StatementVisitor;

/**
 * A "CREATE FUZZY DOMAIN" statement
 */
public class CreateFuzzyDomain implements Statement {

    private String name;
    private ExpressionList values;
    private ExpressionList similarityList;
    private Column column;

    public CreateFuzzyDomain(String name, ExpressionList values,
            ExpressionList similarityList) {
        this.name = name;
        this.values = values;
        this.similarityList = similarityList;
    }

    public CreateFuzzyDomain(String name, Column column) {
        this.name = name;
        this.column = column;
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

    public ExpressionList getSimilarities() {
        return similarityList;
    }

    public void setSimilarities(ExpressionList similarityList) {
        this.similarityList = similarityList;
    }

    public String toString() {
        String sql = "CREATE FUZZY DOMAIN " + name + " " + values.toString();
        if (similarityList.getExpressions().size() > 0) {
            sql += " SIMILARITY {" + similarityList.toString(false) + "}";
        }
        return sql;
    }

    public boolean isFromColumn() {
        return null != column;
    }

    public Column getFromColumn() {
        return this.column;
    }
}