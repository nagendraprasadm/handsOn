class Solution(object):
    def openLock(self, deadends, target):

        deadends = set(deadends)
        start = '0000'
        queue = []
        if start not in deadends:
            queue.append(start)
            deadends.add(start)
        ans = 0
        while queue:
            size = len(queue)
            for i in range(size):
                node = queue.pop(0)
                if node == target:
                    return ans
                states = self.findAllNeighbours(node)
                for state in states:
                    if state not in deadends:
                        deadends.add(state)
                        queue.append(state)
            ans += 1

        return -1

    def findAllNeighbours(self, node):
        combinations = []
        for i in range(len(node)):
            for j in {-1,1}:
                first = node[:i]
                second1 = int(node[i])+j
                second2 = (second1) % 10
                second = str(second2)
                print(f'Second Part being formed - Original - {node[i]}, Diff - {j},  First Change - {second1}, Second Change - {second2}, Final - {second}')
                third = node[i+1:]
                #combinations.append( node[:i] + str((int(node[i])+j) % 10) + node[i+1:])
                combinations.append( first + second + third)
        return combinations

def main():
    soln = Solution()
    soln.openLock(["0201","0101","0102","1212","2002"], "0202")
if __name__ == '__main__':
    main()