class MyCalendar {
    
    private TreeMap<Integer, Character> timeLine;

    public MyCalendar() {
        this.timeLine = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        if (timeLine.containsKey(start) && timeLine.get(start) != 'E') {
            return false;
        }
        if (timeLine.containsKey(end) && timeLine.get(end) != 'S') {
            return false;
        }
        
        if (timeLine.lowerEntry(start) != null && timeLine.lowerEntry(start).getValue() != 'E' && !timeLine.containsKey(start)) {
            return false;
        }
        if (timeLine.higherEntry(end) != null && timeLine.higherEntry(end).getValue() != 'S' && !timeLine.containsKey(end)) {
            return false;
        }
        
        if (timeLine.higherKey(start) != null && timeLine.higherKey(start) < end) {
            return false;
        }
        
        if (timeLine.containsKey(start)) {
            timeLine.put(start, 'T');
        } else {
            timeLine.put(start, 'S');
        }
        
        if (timeLine.containsKey(end)) {
            timeLine.put(end, 'T');
        } else {
            timeLine.put(end, 'E');
        }
        
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */