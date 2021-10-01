from functools import reduce

class Solution(object):
    def arrayStringsAreEqual(self, word1, word2):
        """
        :type word1: List[str]
        :type word2: List[str]
        :rtype: bool
        """
        i, j = 0, 0
        ix1, ix2 = 0, 0
        while i < len(word1) and j < len(word2):
            curword1 = word1[i]
            curword2 = word2[j]
            ln1 = len(curword1)
            ln2 = len(curword2)
            while ix1 < ln1 and ix2 < ln2:
                c1 = curword1[ix1]
                c2 = curword2[ix2]
                if c1 != c2:
                    return False
                ix1 += 1
                ix2 += 1
            if ix1 >= ln1:
                i += 1
                ix1 = 0
            if ix2 >= ln2:
                j += 1
                ix2 = 0

        if (i == len(word1) and j < len(word2)) or (j == len(word2) and i < len(word1)):
            return False
        return True

    def combine(self, word1, word2):
        return word1 + word2

def main():
    soln = Solution()
    print(soln.arrayStringsAreEqual(["ab", "c"], ["a", "bc"]))


if __name__ == '__main__':
    main()