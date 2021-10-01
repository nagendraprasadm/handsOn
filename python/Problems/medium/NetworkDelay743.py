class Solution(object):
    def networkDelayTime(self, times, n, k):
        """
        :type times: List[List[int]]
        :type n: int
        :type k: int
        :rtype: int
        """
        """
        Populate times into a readable data structure based on the node given.
        Loop through each of the nodes except for the given node k
            for each of the paths
                find the path distance to k, if not found then return -1
                
                
        navigating inputnode, times Modified, k, distance
            if paths exist
                loop through the paths
                    curDistance = distance + curDistance
                    if node == k
                        return max(knownDistance, curDistance)
                    else
                        return navigate(curNode, times modifieid, k, curDistance
            else
                return -1
            
        """
        distances = {}
        for time in times:
            fromNode = time[0]
            toNode = time[1]
            timeTaken = time[2]
            if fromNode in distances:
                nodetimings = distances[fromNode]
                nodetimings.append((toNode, timeTaken))
            else:
                nodetimings = []
                nodetimings.append((toNode, timeTaken))
                distances[fromNode] = nodetimings
        minDistances = [-1 for i in range(n+1)]
        if k in distances:
            for nextNodeTiming in distances[k]:
                nextNode = nextNodeTiming[0]
                distance = nextNodeTiming[1]
                if minDistances[nextNode] == -1:
                    minDistance = distance
                else:
                    minDistance = min(distance, minDistances[nextNode])

                minDistances[nextNode] = minDistance
                self.dfs(nextNode, distances, k, minDistance, minDistances)
        else:
            return -1
        total = 0
        for i in range(1, n+1):
            if i != k:
                if minDistances[i] == -1:
                    return -1
                else:
                    total = max(total, minDistances[i])

        return total

    def dfs(self, node, distances, k, distance, minDistances):
        if node in distances:
            nodetimings = distances[node]
            for nextNodeTiming in nodetimings:
                nextNode = nextNodeTiming[0]
                curdistance = nextNodeTiming[1] + distance
                if curdistance > minDistances[nextNode] and minDistances[nextNode] != -1:
                    return
                if minDistances[nextNode] == -1:
                    minDistance = curdistance
                else:
                    minDistance = curdistance
                minDistances[nextNode] = minDistance
                self.dfs(nextNode, distances, k, minDistance, minDistances)

def main():
    soln = Solution()
    #print(soln.networkDelayTime([[2,1,1],[2,3,1],[3,4,1]], 4, 2))
    #print(soln.networkDelayTime([[1,2,1]], 2, 1))
    #print(soln.networkDelayTime([[1,2,1], [2,1,3]], 2, 2))
    #print(soln.networkDelayTime([[2,1,1],[2,3,1],[3,4,1]],4,2))
    print(soln.networkDelayTime([[1,2,1],[2,3,7],[1,3,4],[2,1,2]],3, 2))
[[1,3,68],[1,4,20],[4,1,65],[3,2,74],[2,1,44],[3,4,61],[4,3,68],[3,1,26],[5,1,60],[5,3,3],[4,5,5],[2,5,36],[2,3,94],[1,2,0],[3,5,90],[2,4,28],[4,2,12],[5,4,52],[5,2,85],[1,5,42]]
5
4
#34
if __name__ == '__main__':
    main()

