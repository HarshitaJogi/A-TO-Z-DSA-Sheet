class Solution{
    static String oddEven(int N){
        int check = (N & 1);
        if(check == 1) return "odd";
        else return "even";
    }
}