class ReverseInteger:
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        result = 0

        if x == 0 :
            return 0

        isNegative = x < 0;
        if isNegative:
            x = -1 * x

        while x != 0:
            r = x % 10
            x = x // 10
            #print(f'Remainder -> {r}')
            #print(f'Quotient  ->  {x}')
            result = (result * 10) + r

        if isNegative:
            return 0 if result > 2**31 else -1 * result
        else:
            return 0 if result > 2**31 - 1 else result

def main():
    soln = ReverseInteger();
    print(soln.reverse(-123))
    print(soln.reverse(2**31 + 1))

if __name__ == "__main__":
    main()