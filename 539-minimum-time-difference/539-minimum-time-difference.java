class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> timePointsInM = new ArrayList<>();
        for (String timePoint : timePoints) {
            String[] hm = timePoint.split(":");
            timePointsInM.add(Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]));
        }
        Collections.sort(timePointsInM);
        
        int minimumTimeDifference = Integer.MAX_VALUE;
        for (int i = 0; i < timePointsInM.size(); ++i) {
            minimumTimeDifference = Math.min(minimumTimeDifference, 
                                             (1440 - timePointsInM.get(i) + 
                                              timePointsInM.get((i + 1) % timePointsInM.size())) 
                                             % 1440);
        }
        return minimumTimeDifference;
    }
}