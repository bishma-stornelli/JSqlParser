/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sf.jsqlparser.statement.table;

/**
 *
 * @author andras
 */
public class ChangeColumn extends AlterOperation {
    
    private String columnOld;
    private ColumnDefinition columnDefinition;

    public ChangeColumn(String columnOld, ColumnDefinition colDef) {
        super(TYPE.CHANGE);
        this.columnOld = columnOld;
        this.columnDefinition = colDef;
    }

    public String getColumnOld() {
        return columnOld;
    }

    public ColumnDefinition getColumnDefinition() {
        return columnDefinition;
    }
}
