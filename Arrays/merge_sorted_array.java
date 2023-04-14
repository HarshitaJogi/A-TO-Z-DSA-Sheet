class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        // int j = m;
        // for(int i=0; i<n; i++){
        //     if(j<nums1.length){
        //         nums1[j] = nums2[i];
        //         j++;
        //     }
        // }

        // Arrays.sort(nums1);

        // int p1 = 0;
        // int p2 = 0;
        // // System.out.println(nums1[0] + " " + nums2[0]);
        // if(n==0){
        //     return;
        // }

        // while(p1<m && p2<n){
        //     if(nums1[p1]>nums2[p2]){
        //         int temp = nums1[p1];
        //         nums1[p1] = nums2[p2];
        //         nums2[p2] = temp;
        //         p1++;
        //         p2++;
        //     }
        //     else{
        //         p1++;
        //     }
        // }

        // for(int i: nums1){
        //     System.out.print(i + " ");
        // }
        // System.out.println();
        // for(int i: nums2){
        //     System.out.print(i + " ");
        // }

        // // int j=0;
        // // for(int i=m; i<(m+n); i++){
        // //     nums1[i] = nums2[j];
        // //     j++;
        // // }

        int i = m-1;
        int j = n-1;
        int k = m+n-1;

        while(i>=0 && j>=0){
            if(nums1[i]>nums2[j]){
                nums1[k] = nums1[i];
                k--;
                i--;
            }
            else{
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }

        while(i>=0){
            nums1[k] = nums1[i];
            i--;
            k--;
        }
        while(j>=0){
            nums1[k] = nums2[j];
            j--;
            k--;
        }


    }
}