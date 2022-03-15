class Logger {
    
    Map<String, Integer> messageLastPrintedAtMap;

    public Logger() {
        messageLastPrintedAtMap = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (messageLastPrintedAtMap.containsKey(message) && 
            timestamp - messageLastPrintedAtMap.get(message) < 10) {
            return false;
        }
        messageLastPrintedAtMap.put(message, timestamp);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */