package net.sf.jsqlparser.statement.table;

import java.util.ArrayList;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.StatementVisitor;

public class AlterTable implements Statement {
    
    Table table;
    ArrayList<AlterOperation> alterOperations;
    
    public AlterTable(Table table, ArrayList<AlterOperation> alterOperations) {
        this.table = table;
        this.alterOperations = alterOperations;
    }

    public Table getTable() {
        return table;
    }

    public ArrayList<AlterOperation> getAlterOperations() {
        return alterOperations;
    }

    @Override
    public void accept(StatementVisitor statementVisitor) throws Exception {
        statementVisitor.visit(this);
    }
}
