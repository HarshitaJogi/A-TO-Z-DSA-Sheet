// Function to find square root
// x: element to find square root
class Solution
{
     long floorSqrt(long x)
	 {
		// Your code here
		long low = 0l;
		long high = x;
		
		while(low<=high){
		    long mid = low + (high - low)/2;
		    
		    if(mid*mid == x) return mid;
		    else if(mid*mid < x){
		        low = mid+1;
		    }
		    else{
		        high = mid-1;
		    }
		}
		return high;
	 }
}