from functools import reduce
class Solution(object):
    def subdomainVisits(self, cpdomains):
        """
        :type cpdomains: List[str]
        :rtype: List[str]
        """
        rsltDict = {}
        for curDomain in cpdomains:
            dmtCnt = curDomain.split(' ')
            cnt = dmtCnt[0]
            domain = dmtCnt[1]
            indDomains = domain.split('.')
            for i, indDomain in enumerate(indDomains):
                domainKey = reduce(lambda x, y : x + '.' + y, indDomains[i:])
                if domainKey in rsltDict:
                    rsltDict[domainKey] = rsltDict[domainKey] + int(cnt)
                else:
                    rsltDict[domainKey] = int(cnt)
        return [str(v) + ' ' + str(k) for k,v in rsltDict.items()]

def main():
    soln = Solution()
    print(soln.subdomainVisits(["10 a.b.com", "20 b.com"]))

if __name__ == "__main__":
    main()