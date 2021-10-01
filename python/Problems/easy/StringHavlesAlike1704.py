class Solution(object):
    def halvesAreAlike(self, s):
        """
        :type s: str
        :rtype: bool
        """
        s = s.lower()
        vcnt = {}
        for i, c in enumerate(s):
            if i < len(s)/2:
                if self.isVowel(c):
                    if c in vcnt:
                        vcnt[c] = vcnt[c] + 1
                    else:
                        vcnt[c] = 1
            else:
                if self.isVowel(c):
                    if c in vcnt and vcnt[c] > 0:
                        vcnt[c] = vcnt[c] - 1
                    else:
                        return False

        for key in vcnt:
            if vcnt[key] > 0:
                return False

        return True


    def halvesAreAlikeNew(self, s):
        """
        :type s: str
        :rtype: bool
        """
        s = s.lower()
        vcnt = 0
        for i, c in enumerate(s):
            if i < len(s)/2:
                if self.isVowel(c):
                    vcnt += 1
            else:
                if self.isVowel(c):
                    if vcnt > 0:
                        vcnt -= 1
                    else:
                        return False

        return vcnt == 0

    def isVowel(self, c):
        return c == 'a' or c == 'e' or c == 'i' or c == 'o' or c == 'u'

def main():
    soln = Solution()
    print(soln.halvesAreAlikeNew('AbCdEfGh'))


if __name__ == '__main__':
    main()