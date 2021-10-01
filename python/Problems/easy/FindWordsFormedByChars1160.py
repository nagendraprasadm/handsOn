class Solution(object):
    def countCharacters(self, words, chars):
        """
        :type words: List[str]
        :type chars: str
        :rtype: int
        """
        result = 0
        chrCnt = []
        expCnt = {}
        for word in words:
            if len(chars) >= len(word):
                dct = {}
                for c in word:
                    if c in dct:
                        dct[c] += 1
                    else:
                        dct[c] = 1
                chrCnt.append(dct)
            else:
                chrCnt.append({})

        for c in chars:
            if c in expCnt:
                expCnt[c] += 1
            else:
                expCnt[c] = 1

        for crcnt in chrCnt:
            matched = True
            if len(crcnt) > 0:
                for curCr, curVal in crcnt.items():
                    if curCr not in expCnt or expCnt[curCr] < curVal:
                        matched = False
            else:
                matched = False

            if matched:
                result += sum(crcnt.values())

        return result

def main():
    soln = Solution()
    print(soln.countCharacters(["cat","bt","hat","tree"], "atach"))

if __name__ == "__main__":
    main()