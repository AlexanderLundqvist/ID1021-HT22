package calculatorpolishreverse;

public class Item {
    private ItemType type;
    private double value = 0;
    
    public Item(double value) {
        this.type = ItemType.VALUE;
        this.value = value;
    }
    
    public Item(ItemType type) {
        this.type = type;
    }

    
    public ItemType getType() {
        return this.type;
    }
    
    public double getValue() {
        return this.value;
    }

}
