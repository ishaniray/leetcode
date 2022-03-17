class StockPrice {
    
    private TreeMap<Integer, Integer> timestampPriceMap;
    
    private TreeMap<Integer, Integer> priceOccurrenceMap;
    

    public StockPrice() {
        timestampPriceMap = new TreeMap<>();
        priceOccurrenceMap = new TreeMap<>();
    }
    
    public void update(int timestamp, int price) {
        if (timestampPriceMap.containsKey(timestamp)) {
            int previousPriceAtTimestamp = timestampPriceMap.get(timestamp);
            priceOccurrenceMap.put(previousPriceAtTimestamp, 
                                   priceOccurrenceMap.get(previousPriceAtTimestamp) - 1);
            if (priceOccurrenceMap.get(previousPriceAtTimestamp) == 0) {
                priceOccurrenceMap.remove(previousPriceAtTimestamp);
            }
        }
        
        timestampPriceMap.put(timestamp, price);
        
        int occurrence = 1;
        if (priceOccurrenceMap.containsKey(price)) {
            occurrence = priceOccurrenceMap.get(price) + 1;
        }
        priceOccurrenceMap.put(price, occurrence);
    }
    
    public int current() {
        return timestampPriceMap.lastEntry().getValue();
    }
    
    public int maximum() {
        return priceOccurrenceMap.lastKey();
    }
    
    public int minimum() {
        return priceOccurrenceMap.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */