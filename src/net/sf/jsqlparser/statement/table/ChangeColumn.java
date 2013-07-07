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
    private String columnNew;
    private ColumnDefinition columnDefinition;

    public ChangeColumn(String columnOld, String columnNew, ColumnDefinition colDef) {
        super(TYPE.CHANGE);
        this.columnOld = columnOld;
        this.columnNew = columnNew;
        this.columnDefinition = colDef;
    }

    public String getColumnOld() {
        return columnOld;
    }

    public String getColumnNew() {
        return columnNew;
    }

    public ColumnDefinition getColumnDefinition() {
        return columnDefinition;
    }
}
