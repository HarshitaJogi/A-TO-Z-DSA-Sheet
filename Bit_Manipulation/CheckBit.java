class CheckBit
{
    // Function to check if Kth bit is set or not.
    static boolean checkKthBit(int n, int k)
    {
        int set = (n>>k)&1;
        if(set == 1) return true;
        else return false;
    }
    
}