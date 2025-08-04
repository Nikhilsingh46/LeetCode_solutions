class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int lFruit = -1, slFruit = -1;
        int lcount = 0, currMax = 0, max = 0;

        for(int i = 0; i<n; i++){
            int fruit = fruits[i];

            if(fruit == lFruit || fruit == slFruit){
                currMax++;
            }else{
                currMax = lcount + 1;
            }

            if(fruit == lFruit){
                lcount++;
            }else{
                lcount = 1;
                slFruit = lFruit;
                lFruit = fruit;
            }

            max = Math.max(max, currMax);
        }
        return max;
    }
}