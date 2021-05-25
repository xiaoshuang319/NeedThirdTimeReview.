class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>>result = new ArrayList<>();
        backtrackingHelper(candidates,new ArrayList<>(),result,0,target,0);
        return result;
    }
    private void backtrackingHelper(int[]candidates,List<Integer>path, List<List<Integer>>result, int sum, int target, int startIndex){
        if(sum == target){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = startIndex; i < candidates.length; i++){
            sum += candidates[i];
            if(sum > target){
                break;
            }
            path.add(candidates[i]);
            backtrackingHelper(candidates,path,result,sum,target,i);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
