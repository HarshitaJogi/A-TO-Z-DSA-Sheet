class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> merge = new ArrayList<Integer>();
        int m = nums1.length;
        int n = nums2.length;

        int p1 = 0;
        int p2 = 0;

        while(p1<m && p2<n){
            if(nums1[p1]<nums2[p2]){
                merge.add(nums1[p1]);
                p1++;
            }
            else if(nums2[p2]<nums1[p1]){
                merge.add(nums2[p2]);
                p2++;
            }
            else{
                merge.add(nums1[p1]);
                merge.add(nums2[p2]);
                p1++;
                p2++;
            }
        }

        while(p1<m){
            merge.add(nums1[p1]);
            p1++;
        }
        while(p2<n){
            merge.add(nums2[p2]);
            p2++;
        }

        for(int p: merge){
            System.out.print(p + " ");
        }
        System.out.println();

        int l = merge.size();
        double ans = 0;
        ans = ((merge.get(l/2)) + (merge.get((l-1)/2)))/2.0;
        return ans;
    }
}