//User function Template for Java
class Solution
{
    public int[] twoOddNum(int Arr[], int N)
    {
        //Algo:
        // step 1: find xor of entire array and store in variable xor
        // step 2: do (xor)&(-xor), resultant number to be stored in variable set_bit_number
        //            find -xor by two's complement
        // step 3: do 'and' of set_bit_number with entire array, divide array into 2 grps:
        //         grp 1- gives ans=0 when set_bit_number & (arr[i]) is done
        //         grp 2- gives ans!=0 when set_bit_number & (arr[i]) is done
        // step 4: do xor of both these arrays to get both numbers that appear odd number of times
        
        int xor = 0;
        for(int i=0; i<N; i++){
            xor = xor^Arr[i];
        }
        
        int set_bit_no = xor&(~xor + 1);
        
        List<Integer> l1 = new ArrayList<Integer>();
        List<Integer> l2 = new ArrayList<Integer>();
        
        for(int i=0; i<N; i++){
            if((Arr[i]&set_bit_no) == 0){
                l1.add(Arr[i]);
            }
            else{
                l2.add(Arr[i]);
            }
        }
        
        int num1 = 0;
        for(int i=0; i<l1.size(); i++){
            num1 = num1^(l1.get(i));
        }
        int num2 = 0;
        for(int i=0; i<l2.size(); i++){
            num2 = num2^(l2.get(i));
        }
        
        int max = Math.max(num1, num2);
        int min = Math.min(num1, num2);
        
        int [] ans = new int[2];
        ans[0] = max;
        ans[1] = min;
        
        return ans;
        
    }
}