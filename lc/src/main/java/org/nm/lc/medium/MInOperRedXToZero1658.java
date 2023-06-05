package org.nm.lc.medium;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.Queue;

public class MInOperRedXToZero1658
{
    private static final Logger logger = LoggerFactory.getLogger(
        MInOperRedXToZero1658.class);

    public int minOperations (int[] nums, int x)
    {
        int sum = 0;
        for (int num : nums)
            sum += num;

        int maxLength = -1, currSum = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            currSum += nums[r];
            while (l <= r && currSum > sum - x)
                currSum -= nums[l++];
            if (currSum == sum - x)
                maxLength = Math.max(maxLength, r - l + 1);
        }

        return maxLength == -1 ? -1 : nums.length - maxLength;
    }

    public int minOperationsBFSTLE (int[] nums, int x)
    {

        int s = 0;
        int e = nums.length - 1;
        int cnt = 1;
        Queue<Integer[]> queue = new ArrayDeque<>();
        queue.add(new Integer[] { x, s, e });
        //queue.add(new Integer[] { x, s, e});
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i >= 1; i--) {
                Integer[] elem = queue.poll();
                logger.info("Popped - {}, val - start : {}, val - end : {}",
                            ArrayUtils.toString(elem), elem[0] - nums[elem[1]],
                            elem[0] - nums[elem[2]]);
                if (nums[elem[1]] == elem[0] || nums[elem[2]] == elem[0]) {
                    return cnt;
                }
                else {
                    if (elem[1] <= nums.length - 2 && elem[0] - nums[elem[1]] > 0) {
                        queue.add(new Integer[] { elem[0] - nums[elem[1]], elem[1] + 1,
                                                  elem[2] });
                    }
                    if (elem[2] >= 1 && elem[0] - nums[elem[2]] > 0) {
                        queue.add(new Integer[] { elem[0] - nums[elem[2]], elem[1],
                                                  elem[2] - 1 });
                    }
                }
            }
            logger.info("\n\n** Moving onto next level - {}", cnt + 1);
            cnt++;
        }
        return -1;
    }

    public int dfsTLE (int[] nums, int x, int s, int e, int cnt)
    {
        if (x >= 0 && s >= 0 && e < nums.length && s <= e) {
            if (x == 0) {
                return cnt;
            }
            else if (s == e) {
                if (x == nums[s]) {
                    return cnt + 1;
                }
            }
            else {
                return Math.min(dfsTLE(nums, x - nums[s], s + 1, e, cnt + 1),
                                dfsTLE(nums, x - nums[e], s, e - 1, cnt + 1));
            }
        }
        return Integer.MAX_VALUE;
    }
}
