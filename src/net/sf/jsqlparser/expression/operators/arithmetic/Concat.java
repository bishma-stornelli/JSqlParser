package net.sf.jsqlparser.expression.operators.arithmetic;

import net.sf.jsqlparser.expression.BinaryExpression;
import net.sf.jsqlparser.expression.ExpressionVisitor;

public class Concat extends BinaryExpression {

	public void accept(ExpressionVisitor expressionVisitor) throws Exception {
		expressionVisitor.visit(this);
	}
	
	public String getStringExpression() {
		return "||";
	}

}
