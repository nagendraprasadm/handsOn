class RecentCounter(object):

    def __init__(self):
        self._times = []


    def ping(self, t):
        """
        :type t: int
        :rtype: int
        """
        self._times.append(t)
        while self._times[0] < t - 3000:
            del self._times[0]
        #ix = -1
        #for i in range(len(self._times)):
        #    if t - self._times[i] > 3000:
        #       ix = i
        #self._times = self._times[ix+1:]
        #self._times.append(t)
        return len(self._times)

def main():
    soln = RecentCounter();
    print(soln.ping(642))
    print(soln.ping(1849))
    print(soln.ping(4921))
    print(soln.ping(5936))
    print(soln.ping(5957))


if __name__ == "__main__":
    main()
