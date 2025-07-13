class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int p = players.length;
        int t = trainers.length;

        int i = 0;
        int j = 0;
        int count = 0;

        while(i < p && j < t){
            if(players[i] <= trainers[j]){
                count++;
                i++;
                j++;
            }else{
                j++;
            }
        }
    return count;

    }
}