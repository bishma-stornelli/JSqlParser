package net.sf.jsqlparser.statement.table;

public abstract class AlterOperation {
    
    public enum TYPE {CHANGE};
    private TYPE type;

    AlterOperation(TYPE type) {
        this.type = type;
    }
    
    public TYPE getType() {
        return type;
    };
}
