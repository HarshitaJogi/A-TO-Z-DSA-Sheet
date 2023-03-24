class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n)
    {
        Stack<Integer> st = new Stack<Integer>();
        int [] pge = new int [n]; // this stores index of previous greater element
        Arrays.fill(pge, -1);
        int [] ans = new int [n];
        
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && price[st.peek()]<price[i]){
                pge[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }
        
        for(int i=n-1; i>=0; i--){
            int num = i - pge[i];
            ans[i] = num;
        }
        
        return ans;