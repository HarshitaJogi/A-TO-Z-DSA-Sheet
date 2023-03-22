class Solution {
    static void bitManipulation(int num, int i) {
        int get = (num>>(i-1))&1;
        int set = num | (1<<(i-1));
        int clear = num & (~(1<<(i-1)));
        System.out.print(get + " " + set + " " + clear);
    }
}
