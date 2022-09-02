package calculatorpolishreverse;

public class DynamicCalculator {
    Item[] expression;
    int pointer;
    DynamicStack stack;
    
    public DynamicCalculator(Item[] expr) {
        this.expression = expr;
        this.pointer = 0;
        this.stack = new DynamicStack();
    }
    
    private void step() {
        Item next = this.expression[this.pointer++];
        switch(next.getType()) {
            case ADD : {
                double y = this.stack.pop().getValue();
                double x = this.stack.pop().getValue();
                this.stack.push(new Item(x + y));
                break;
            }
            case SUB : {
                double y = this.stack.pop().getValue();
                double x = this.stack.pop().getValue();
                this.stack.push(new Item(x - y));
                break;
            }
            case MUL : {
                double y = this.stack.pop().getValue();
                double x = this.stack.pop().getValue();
                this.stack.push(new Item(x * y));
                break;
            }
            case DIV : {
                double y = this.stack.pop().getValue();
                double x = this.stack.pop().getValue();
                this.stack.push(new Item(x / y));
                break;
            }
            case MOD : {
                double x = this.stack.pop().getValue();
                this.stack.push(new Item(x % 10));
                break;
            }
            case MULX : {
                double y = this.stack.pop().getValue() * 2;
                if(y < 10){
                    stack.push(new Item(y));
                }
                else
                    this.stack.push(new Item((y - 10) + 1));
                break;
            }
            case VALUE : {
                this.stack.push(new Item(next.getValue()));
                break;
            }
        }
    }
    
    public double run() {
        while ( this.pointer < this.expression.length ) {
            step();
        }
        return this.stack.pop().getValue();
    }

}
