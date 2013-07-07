package net.sf.jsqlparser.util.deparser;

import java.util.Iterator;

import net.sf.jsqlparser.statement.table.AlterOperation;
import net.sf.jsqlparser.statement.table.AlterTable;
import net.sf.jsqlparser.statement.table.ChangeColumn;
import net.sf.jsqlparser.statement.table.ColumnDefinition;
import net.sf.jsqlparser.statement.table.Index;

/**
 * A class to de-parse (that is, tranform from JSqlParser hierarchy into a string)
 * a {@link net.sf.jsqlparser.statement.create.table.CreateTable}
 */
public class AlterTableDeParser {

    protected StringBuffer buffer;

    /**
     * @param buffer the buffer that will be filled with the select
     */
    public AlterTableDeParser(StringBuffer buffer) {
        this.buffer = buffer;
    }

    public void deParse(AlterTable alterTable) {
        buffer.append("ALTER TABLE ");
        buffer.append(alterTable.getTable().getWholeTableName());
        boolean first = true;
        for (AlterOperation alterOperation : alterTable.getAlterOperations()) {
            if (!first) {
                buffer.append(", ");
            } else {
                first = false;
            }
            buffer.append("\n    ");
            switch (alterOperation.getType()) {
            case CHANGE:
                ChangeColumn changeColumn = (ChangeColumn)alterOperation;
                ColumnDefinition columnDefinition = changeColumn.getColumnDefinition();
                buffer.append("CHANGE ");
                buffer.append(changeColumn.getColumnOld());
                buffer.append(" ");
                buffer.append(columnDefinition.getColDataType().getDataType());
                if (columnDefinition.getColDataType().getArgumentsStringList() != null) {
                    for (Iterator iterator = columnDefinition.getColDataType().getArgumentsStringList().iterator(); iterator.hasNext();) {
                        buffer.append(" ");
                        buffer.append((String) iterator.next());
                    }
                }
                if (columnDefinition.getColumnSpecStrings() != null) {
                    for (Iterator iterator = columnDefinition.getColumnSpecStrings().iterator(); iterator.hasNext();) {
                        buffer.append(" ");
                        buffer.append((String) iterator.next());
                    }
                }
            }
        }
    }

    public StringBuffer getBuffer() {
        return buffer;
    }

    public void setBuffer(StringBuffer buffer) {
        this.buffer = buffer;
    }
}
