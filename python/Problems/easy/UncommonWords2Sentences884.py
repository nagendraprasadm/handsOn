class Solution(object):
    def uncommonFromSentences(self, s1, s2):
        """
        :type s1: str
        :type s2: str
        :rtype: List[str]
        """
        def uncommonword(word, checklist):
            return word not in checklist

        words1 = s1.split(' ')
        words2 = s2.split(' ')
        finalwords = []
        dupwords = []
        for i in range(len(words1)):
            word = words1[i]
            isRepeating = True
            if i < len(words1) - 1:
                isRepeating = (word in words1[i+1:]) or (word in dupwords)
            else:
                isRepeating = word in dupwords
            if isRepeating:
                dupwords.append(word)
            if uncommonword(word, words2) and not isRepeating:
                finalwords.append(word)
        dupwords = []
        for i in range(len(words2)):
            word = words2[i]
            if i < len(words2) - 1:
                isRepeating = (word in words2[i+1:]) or (word in dupwords)
            else:
                isRepeating = word in dupwords
            if isRepeating:
                dupwords.append(word)
            if uncommonword(word, words1) and not isRepeating:
                finalwords.append(word)

        return finalwords


def main():
    soln = Solution()
    print(soln.uncommonFromSentences("this apple apple is sweet","sour this orange sour"))


if __name__ == '__main__':
    main()