/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // Your code here
        // value to wt, wt
        // PriorityQueue<pair> valtoweight = new PriorityQueue<pair>();
        // HashMap<Double, Integer> valtoweight = new HashMap<Double, Integer>();
        // PriorityQueue<ArrayList<Double>> valtoweight = new PriorityQueue<ArrayList<Double>>();
        
        
        // for(Item i: arr){
        //     double curr_val = i.value;
        //     double curr_wt = i.weight;
        //     double d = curr_val/curr_wt;
        //     System.out.println(d);
        //     ArrayList<Double> l = new ArrayList<Double>();
        //     l.add(d);
        //     l.add(curr_wt);
        //     valtoweight.add(l);
        // }
        
        // return 0.0;
        
        // for(int i=0; i<n; i++){
        //     for(int j=i; j<n-1; j++){
        //         double r1 = (double)arr[j].value/(double)arr[j].weight;
        //         double r2 = (double)arr[j+1].value/(double)arr[j+1].weight;
        //         // System.out.println(r1 + " " + r2);
        //         if(r2>r1){
        //             // swap j and j+1
        //             // Item temp = arr[j];
        //             // arr[j] = arr[j+1];
        //             // arr[j+1] = temp;
        //             int valtemp = arr[j].value;
        //             int wttemp = arr[j].weight;
                    
        //             arr[j].value = arr[j+1].value;
        //             arr[j].weight = arr[j+1].weight;
                    
        //             arr[j+1].value = valtemp;
        //             arr[j+1].weight = wttemp;
        //         }
        //     }
        //     // System.out.println(arr[i].value);
        // }
        
        
        
        
        // Sorting arr
        Arrays.sort(arr, new itemComparator());
        
        // for(Item i: arr){
        //     double r = i.value/i.weight;
        //     System.out.println(i.value + " " + i.weight + " " + r);
        // }
        
        double ans = 0.0;
        double wt_left = W;
        
        for(int i=0; i<n; i++){
            double curr_wt = arr[i].weight;
            double curr_val = arr[i].value;
            double ratio = curr_val/curr_wt;
            // System.out.println(curr_wt + " " + curr_val + " " + ratio);
            
            if(wt_left == 0) break;
            
            if(wt_left - curr_wt < 0){
                curr_wt = wt_left;
            }
            
            ans += ratio*curr_wt;
            wt_left -= curr_wt;
        }
        
        return ans;
        
    }
}

class itemComparator implements Comparator<Item>
{
    @Override
    public int compare(Item a, Item b) 
    {
        double r1 = (double)(a.value) / (double)(a.weight); 
        double r2 = (double)(b.value) / (double)(b.weight); 
        if(r1 < r2) return 1; 
        else if(r1 > r2) return -1; 
        else return 0; 
    }
}