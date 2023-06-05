package org.nm.lc.easy;

public class MergeSortedArray84
{
    public void merge (int[] nums1, int m, int[] nums2, int n)
    {
        int k = 0;
        int i = 0;
        int j = 0;
        int[] temp1 = new int[m];
        System.arraycopy(nums1, 0, temp1, 0, m);
        //int[] res = new int[m+n];
        while (i < m && j < n) {
            if (temp1[i] <= nums2[j]) {
                nums1[k++] = temp1[i];
                i++;
            }
            else {
                nums1[k++] = nums2[j];
                j++;
            }
        }
        if (i == m) {
            while (j < n) {
                nums1[k++] = nums2[j];
                j++;
            }
        }
        else if (j == n) {
            while (i < m) {
                nums1[k++] = temp1[i];
                i++;
            }
        }
        //nums1 = res;
    }
    public void mergeInPlace(int[] nums1, int m, int[] nums2, int n) {
        int s = nums1.length - 1;
        int i = m-1;
        while(i >= 0){
            nums1[s--] = nums1[i--];
        }
        i = nums1.length - m;
        int j = 0;
        int ri = 0;
        while(i < (m+n) && j < n){
            if(nums1[i] < nums2[j] ){
                nums1[ri++] = nums1[i];
                i++;
            }else{
                nums1[ri++] = nums2[j];
                j++;
            }
        }
        while(j < n){
            nums1[ri++] = nums2[j++];
        }
        while(i < m){
            nums1[ri++] = nums1[i++];
        }
    }


}
