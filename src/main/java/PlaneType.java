public enum PlaneType {

    AIRBUSA350(366, 115700),
    AIRBUSA380 (544, 277000),
    BOEING747(410, 183500),
    BOEING787(330, 161000),
    NOCAPACITY(0, 0),
    MAXCAPACITYOFTHREE(3,1000);

    private final int capacity;
    private final int totalWeight;

    PlaneType (int capacity, int totalWeight){
        this.capacity = capacity;
        this.totalWeight = totalWeight;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public int getTotalWeight(){
        return this.totalWeight;
    }

}
