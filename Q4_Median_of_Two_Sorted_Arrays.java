import java.util.*;
public class Q4_Median_of_Two_Sorted_Arrays 
{
    //Brute Force
    public double findMedianSortedArrays(int[] nums1, int[] nums2) 
    {
        int i = nums1.length;
        int j = nums2.length;
 
        int[] nums3 = new int[i + j];
 
        System.arraycopy(nums1, 0, nums3, 0, i);
        System.arraycopy(nums2, 0, nums3, i, j);
 
        Arrays.sort(nums3);

        int n = nums3.length;
       
        if (n % 2 == 0)
        {
            int z = n / 2;
            int e = nums3[z];
            int q = nums3[z - 1];
 
            double ans = (e + q) / 2;
            return ans;
        }
       
        else
        {
            int z = (n / 2);
            double ans = nums3[z];
            return ans;
        }
    }
}