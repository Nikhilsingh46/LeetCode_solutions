class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> visited = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            int diff = target - nums[i];
            
            if(visited.containsKey(diff)){
                return new int[] {i, visited.get(diff)};
            }
        
            visited.put(nums[i], i);
        }
        return new int[] {0, 0};
    }
}