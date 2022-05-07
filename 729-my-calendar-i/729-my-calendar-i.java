class MyCalendar {
    
    private TreeMap<Integer, Integer> bookings;

    public MyCalendar() {
        this.bookings = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> prevBooking = bookings.lowerEntry(end);
        if (prevBooking != null && prevBooking.getValue() > start) {
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