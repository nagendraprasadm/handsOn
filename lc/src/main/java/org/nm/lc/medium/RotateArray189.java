package org.nm.lc.medium;

public class RotateArray189
{
    public void rotate (int[] nums, int k)
    {
        int l = nums.length;
        k = k % l;
        //int sp = l - k;
        rotate(nums, 0, k);
    }

    private void rotate (int[] nums, int sp, int k)
    {
        int rl = nums.length - sp;
        if (rl > k) {
            int fe = nums.length - k;
            int ul = sp + k;
            while (sp < ul) {
                swap(nums, fe, sp);
                fe++;
                sp++;
            }
            if (sp == nums.length - k) {
                return;
            }
            else {
                rotate(nums, sp, k);
            }
        }
        else if (rl < k){
            k = k - rl;
            rotate(nums, sp, k);
        }
    }

    private void swap (int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
