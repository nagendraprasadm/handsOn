class Solution(object):

    def findMax(self, arr, i , j):
        if(i == j):
            return i
        mid = (i+j)//2
        fM = self.findMax(arr, i, mid)
        sM = self.findMax(arr, mid + 1, j)
        return fM if arr[fM] > arr[sM] else sM

    def peakIndexInMountainArray(self, arr):
        """
        :type arr: List[int]
        :rtype: int
         This can be further enchanced to check by comparing mid-1 , mid and mid + 1
        """
        return self.findMax(arr, 0, len(arr) - 1)

def main():
    soln = Solution();
    print(soln.peakIndexInMountainArray([0,1,0]))

if __name__ == "__main__":
    main()