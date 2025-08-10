class Solution {
    public boolean reorderedPowerOf2(int n) {
        String target = sortDigits(n);

        for(int i = 0; i<31; i++){
            int powOfTwo = 1 << i;
            if(sortDigits(powOfTwo).equals(target)){
                return true;
            }
        }

        return false;
    }

    public String sortDigits(int num){
        char[] arr = String.valueOf(num).toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}