class Solution{
    static int setBit(int N){
        
        int index = -1;
        int num = N;
        for(int i=0; i<31; i++){
            if(num==0) break;
            if(((N>>i)&1)!=1){
                index = i;
                break;
            }
            num = num/2;
        }
        
        if(index == -1) return N;
        
        //System.out.println(index);
        
        N = N | (1<<index);
        return N;
    }
}