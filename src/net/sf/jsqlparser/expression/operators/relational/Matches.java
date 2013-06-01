package net.sf.jsqlparser.expression.operators.relational;

import net.sf.jsqlparser.expression.BinaryExpression;
import net.sf.jsqlparser.expression.ExpressionVisitor;

public class Matches extends BinaryExpression {
	public void accept(ExpressionVisitor expressionVisitor) throws Exception {
		expressionVisitor.visit(this);
	}

	public String getStringExpression() {
		return "@@";
	}
}
