class StockPrice {
    
    private TreeMap<Integer, Integer> timestampPriceMap;
    
    private TreeMap<Integer, Integer> priceOccurenceMap;
    

    public StockPrice() {
        timestampPriceMap = new TreeMap<>();
        priceOccurenceMap = new TreeMap<>();
    }
    
    public void update(int timestamp, int price) {
        if (timestampPriceMap.containsKey(timestamp)) {
            if (priceOccurenceMap.get(timestampPriceMap.get(timestamp)) > 1) {
                priceOccurenceMap.put(timestampPriceMap.get(timestamp), 
                                      priceOccurenceMap.get(timestampPriceMap.get(timestamp)) - 1);
            } else {
                priceOccurenceMap.remove(timestampPriceMap.get(timestamp));
            }
        }
        
        timestampPriceMap.put(timestamp, price);
        
        if (priceOccurenceMap.containsKey(price)) {
            priceOccurenceMap.put(price, priceOccurenceMap.get(price) + 1);
        } else {
            priceOccurenceMap.put(price, 1);
        }
    }
    
    public int current() {
        return timestampPriceMap.lastEntry().getValue();
    }
    
    public int maximum() {
        return priceOccurenceMap.lastEntry().getKey();
    }
    
    public int minimum() {
        return priceOccurenceMap.firstEntry().getKey();
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