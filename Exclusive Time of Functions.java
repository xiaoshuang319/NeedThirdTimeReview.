//current consumed time = endTime - startTime + 1 - previousFunctionConsumedTime;
//go out first but come late => stack => keep id, startTime, previousFunctionConsumedTime
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Log>stack = new Stack<>();
        int[]result = new int[n];
        for(String ele : logs){
            String[]splits = ele.split(":");
            int id = Integer.parseInt(splits[0]);
            String signal = splits[1];
            int time = Integer.parseInt(splits[2]);
            if(signal.equals("end")){
                Log peek = stack.pop();
                int consumedTime = time - peek.startTime + 1 - peek.previousTaskConsumedTime;
                result[id] += consumedTime;
                if(!stack.isEmpty()){
                    Log next = stack.peek();
                    next.previousTaskConsumedTime += time - peek.startTime + 1;
                }
            }else{
                stack.add(new Log(id,time,0));
            }
        }
        return result;
    }
    private class Log{
        int id;
        int startTime;
        int previousTaskConsumedTime;
        public Log(int id, int startTime, int previousTaskConsumedTime){
            this.id = id;
            this.startTime = startTime;
            this.previousTaskConsumedTime = previousTaskConsumedTime;
        }
    }
}
