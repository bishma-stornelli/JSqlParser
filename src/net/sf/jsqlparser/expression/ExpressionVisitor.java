/* ================================================================
 * JSQLParser : java based sql parser 
 * ================================================================
 *
 * Project Info:  http://jsqlparser.sourceforge.net
 * Project Lead:  Leonardo Francalanci (leoonardoo@yahoo.it);
 *
 * (C) Copyright 2004, by Leonardo Francalanci
 *
 * This library is free software; you can redistribute it and/or modify it under the terms
 * of the GNU Lesser General Public License as published by the Free Software Foundation;
 * either version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this
 * library; if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA 02111-1307, USA.
 */
 
 package net.sf.jsqlparser.expression;

import net.sf.jsqlparser.expression.operators.arithmetic.Addition;
import net.sf.jsqlparser.expression.operators.arithmetic.BitwiseAnd;
import net.sf.jsqlparser.expression.operators.arithmetic.BitwiseOr;
import net.sf.jsqlparser.expression.operators.arithmetic.BitwiseXor;
import net.sf.jsqlparser.expression.operators.arithmetic.Concat;
import net.sf.jsqlparser.expression.operators.arithmetic.Division;
import net.sf.jsqlparser.expression.operators.arithmetic.Multiplication;
import net.sf.jsqlparser.expression.operators.arithmetic.Subtraction;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.conditional.OrExpression;
import net.sf.jsqlparser.expression.operators.relational.Between;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.expression.operators.relational.ExistsExpression;
import net.sf.jsqlparser.expression.operators.relational.GreaterThan;
import net.sf.jsqlparser.expression.operators.relational.GreaterThanEquals;
import net.sf.jsqlparser.expression.operators.relational.InExpression;
import net.sf.jsqlparser.expression.operators.relational.IsNullExpression;
import net.sf.jsqlparser.expression.operators.relational.LikeExpression;
import net.sf.jsqlparser.expression.operators.relational.Matches;
import net.sf.jsqlparser.expression.operators.relational.MinorThan;
import net.sf.jsqlparser.expression.operators.relational.MinorThanEquals;
import net.sf.jsqlparser.expression.operators.relational.NotEqualsTo;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.select.SubSelect;

public interface ExpressionVisitor {
	public void visit(NullValue nullValue) throws Exception;
	public void visit(Function function) throws Exception;
	public void visit(InverseExpression inverseExpression) throws Exception;
	public void visit(JdbcParameter jdbcParameter) throws Exception;
	public void visit(DoubleValue doubleValue) throws Exception;
	public void visit(LongValue longValue) throws Exception;
	public void visit(DateValue dateValue) throws Exception;
	public void visit(TimeValue timeValue) throws Exception;
	public void visit(TimestampValue timestampValue) throws Exception;
	public void visit(Parenthesis parenthesis) throws Exception;
	public void visit(StringValue stringValue) throws Exception;
	public void visit(Addition addition) throws Exception;
	public void visit(Division division) throws Exception;
	public void visit(Multiplication multiplication) throws Exception;
	public void visit(Subtraction subtraction) throws Exception;
	public void visit(AndExpression andExpression) throws Exception;
	public void visit(OrExpression orExpression) throws Exception;
	public void visit(Between between) throws Exception;
	public void visit(EqualsTo equalsTo) throws Exception;
	public void visit(GreaterThan greaterThan) throws Exception;
	public void visit(GreaterThanEquals greaterThanEquals) throws Exception;
	public void visit(InExpression inExpression) throws Exception;
	public void visit(IsNullExpression isNullExpression) throws Exception;
	public void visit(LikeExpression likeExpression) throws Exception;
	public void visit(MinorThan minorThan) throws Exception;
	public void visit(MinorThanEquals minorThanEquals) throws Exception;
	public void visit(NotEqualsTo notEqualsTo) throws Exception;
	public void visit(Column tableColumn) throws Exception;
	public void visit(SubSelect subSelect) throws Exception;
	public void visit(CaseExpression caseExpression) throws Exception;
	public void visit(WhenClause whenClause) throws Exception;
	public void visit(ExistsExpression existsExpression) throws Exception;
	public void visit(AllComparisonExpression allComparisonExpression) throws Exception;
	public void visit(AnyComparisonExpression anyComparisonExpression) throws Exception;
	public void visit(Concat concat) throws Exception;
	public void visit(Matches matches) throws Exception;
	public void visit(BitwiseAnd bitwiseAnd) throws Exception;
	public void visit(BitwiseOr bitwiseOr) throws Exception;
	public void visit(BitwiseXor bitwiseXor) throws Exception;
	public void visit(SimilarColumn similarColumn) throws Exception;
	public void visit(Similarity similarity) throws Exception;
	public void visit(Relation relation) throws Exception;


}
