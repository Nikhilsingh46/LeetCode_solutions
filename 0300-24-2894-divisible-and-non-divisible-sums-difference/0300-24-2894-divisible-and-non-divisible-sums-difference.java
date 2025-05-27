class Solution {
    public int differenceOfSums(int n, int m) {
        // Total sum from 1 to n
        long totalSum = (long) n * (n + 1) / 2;

        // Number of multiples of m from 1 to n
        long count = n / m;

        // Sum of numbers divisible by m
        long divisibleSum = m * count * (count + 1) / 2;

        // Non-divisible sum
        long nonDivisibleSum = totalSum - divisibleSum;

        return (int)(nonDivisibleSum - divisibleSum);
    }
}
