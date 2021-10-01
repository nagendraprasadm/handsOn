class Solution(object):

    def thousandsStr(self, num, previous):
        if num//10 == 0:
            return '.00' + str(num) + previous
        elif num//100 == 0:
            return '.0' + str(num) + previous
        else:
            return '.' + str(num) + previous

    def thousandSeparator(self, n):
        """
        :type n: int
        :rtype: str
        """
        if n//1000 == 0:
            return str(n)
        else:
            result = ''
            r = n%1000
            n = n//1000
            while n > 0:
                result = self.thousandsStr(r, result)
                r = n%1000
                n = n//1000
            result = str(r) + result
            return result

def main():
    soln = Solution()
    print(soln.thousandSeparator(1000))
    print(soln.thousandSeparator(1005))
    print(soln.thousandSeparator(1045))
    print(soln.thousandSeparator(1645))
    print(soln.thousandSeparator(16453))
    print(soln.thousandSeparator(123456))
    print(soln.thousandSeparator(1234567))
    print(soln.thousandSeparator(12345678))

if __name__ == '__main__':
    main()