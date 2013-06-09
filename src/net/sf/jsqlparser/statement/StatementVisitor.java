/* ================================================================
 * JSQLParser : java based sql parser 
 * ================================================================
 *
 * Project Info:  http://jsqlparser.sourceforge.net
 * Project Lead:  Leonardo Francalanci (leoonardoo@yahoo.it) throws Exception;
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

package net.sf.jsqlparser.statement;

import net.sf.jsqlparser.statement.alter.fuzzy.domain.AlterFuzzyDomain;
import net.sf.jsqlparser.statement.create.fuzzy.domain.CreateFuzzyDomain;
import net.sf.jsqlparser.statement.create.table.CreateTable;
import net.sf.jsqlparser.statement.delete.Delete;
import net.sf.jsqlparser.statement.drop.Drop;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.replace.Replace;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.truncate.Truncate;
import net.sf.jsqlparser.statement.update.Update;

public interface StatementVisitor {
	public void visit(Select select) throws Exception;
	public void visit(Delete delete) throws Exception;
	public void visit(Update update) throws Exception;
	public void visit(Insert insert) throws Exception;
	public void visit(Replace replace) throws Exception;
	public void visit(Drop drop) throws Exception;
	public void visit(Truncate truncate) throws Exception;
	public void visit(CreateTable createTable) throws Exception;
	public void visit(CreateFuzzyDomain fuzzyDomain) throws Exception;
	public void visit(AlterFuzzyDomain alterFuzzyDomain) throws Exception;

}
