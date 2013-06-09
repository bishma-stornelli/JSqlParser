package net.sf.jsqlparser.statement.alter.fuzzy.domain;

import net.sf.jsqlparser.expression.operators.relational.ExpressionList;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.StatementVisitor;

/**
 * A "CREATE FUZZY DOMAIN" statement
 */
public class AlterFuzzyDomain implements Statement {

    private String name;
    private ExpressionList addValues, dropValues;
    private ExpressionList addSimilarity;
    private ExpressionList dropSimilarity;

    public AlterFuzzyDomain(String name) {
        this.name = name;
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

    public ExpressionList getAddValues() {
        return addValues;
    }

    public void setAddValues(ExpressionList addValues) {
        this.addValues = addValues;
    }

    public ExpressionList getAddSimilarity() {
        return addSimilarity;
    }

    public void setAddSimilarity(ExpressionList addSimilarity) {
        this.addSimilarity = addSimilarity;
    }

    public ExpressionList getDropValues() {
        return dropValues;
    }

    public void setDropValues(ExpressionList dropValues) {
        this.dropValues = dropValues;
    }

    public ExpressionList getDropSimilarity() {
        return dropSimilarity;
    }

    public void setDropSimilarity(ExpressionList dropSimilarity) {
        this.dropSimilarity = dropSimilarity;
    }

    public String toString() {
        String sql = "ALTER FUZZY DOMAIN " + name;
        if (null != addValues) {
            sql += " ADD VALUES " + addValues.toString();
        } else if (null != addSimilarity) {
            sql += " ADD SIMILARITY {" + addSimilarity.toString(false) + "}";
        } else if (null != dropValues) {
            sql += " DROP VALUES " + dropValues.toString();
        } else if (null != dropSimilarity) {
            sql += " DROP SIMILARITY {" + dropSimilarity.toString(false) + "}";
        }
        return sql;
    }
}