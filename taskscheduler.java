class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer>max = new PriorityQueue<Integer>((a,b) -> (b-a));
        int[]freq = new int[26];
        for(char c : tasks){
            freq[c - 'A']++;
        }
        for(int ele : freq){
            if(ele != 0){
                max.add(ele);
            }
        }
        int cycle = n + 1;
        int totalTime = 0;
        while(!max.isEmpty()){
            List<Integer>processedTasks = new ArrayList<>();
            int workTime = 0;
            for(int i = 0; i < cycle; i++){
                if(!max.isEmpty()){
                    processedTasks.add(max.poll());
                    workTime++;
                }
            }
            for(int ele : processedTasks){
                ele--;
                if(ele != 0){
                    max.add(ele);
                }
            }
            totalTime +=  max.isEmpty() ? workTime : cycle;
        }
        return totalTime;
    }
}
