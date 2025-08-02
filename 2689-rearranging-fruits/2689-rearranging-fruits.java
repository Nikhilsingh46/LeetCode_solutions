class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int m = Integer.MAX_VALUE;

        for(int b1 : basket1){
            map.put(b1, map.getOrDefault(b1, 0) + 1);
            m = Math.min(m, b1);
        }

        for(int b2 : basket2){
            map.put(b2, map.getOrDefault(b2, 0) -1);
            m = Math.min(m, b2);
        }

        List<Integer> merge = new ArrayList<>();
        for(var entry : map.entrySet()){
            int count = entry.getValue();
            if(count % 2 != 0) return -1;
            for(int i = 0; i<Math.abs(count)/2; i++){
                merge.add(entry.getKey());
            }
        }

        Collections.sort(merge);
        long res = 0;
        for(int i = 0; i<merge.size()/2; i++){
            res += Math.min(2*m, merge.get(i));
        }
        return res;
    }
}