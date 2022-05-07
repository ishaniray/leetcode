class MyCalendar {
    
    private TreeMap<Integer, Integer> bookings; // key = start time; value = end time

    public MyCalendar() {
        this.bookings = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        if (bookings.lowerEntry(end) != null && bookings.lowerEntry(end).getValue() > start) { // previous booking's end time > this booking's start time
            return false;
        }
        bookings.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */