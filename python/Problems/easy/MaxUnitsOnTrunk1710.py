class Solution(object):
    def maximumUnits(self, boxTypes, truckSize):
        """
        :type boxTypes: List[List[int]]
        :type truckSize: int
        :rtype: int
        """
        boxTypes.sort(key = lambda x : x[1], reverse=True)
        print(boxTypes)
        totalUnits = 0
        totalBoxes = 0
        for item in boxTypes:
            boxes = item[0]
            units = item[1]
            if totalBoxes < truckSize:
                if totalBoxes + boxes <= truckSize:
                    totalBoxes += boxes
                    totalUnits += (boxes * units)
                elif totalBoxes + boxes > truckSize:
                    boxesToAdd = (truckSize - totalBoxes)
                    totalUnits += (boxesToAdd * units)
                    totalBoxes += boxesToAdd
            else:
                break

        return totalUnits
def main():
    soln = Solution()
    print(soln.maximumUnits([[5,10],[2,5],[4,7],[3,9]],10))
if __name__ == "__main__":
    main()