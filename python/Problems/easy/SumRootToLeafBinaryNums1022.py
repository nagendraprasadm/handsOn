# Definition for a binary tree node.
class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right

class Solution:
    nums = []
    def traverse(self, node: TreeNode, binStr):
        binStr = binStr + str(node.val)
        if node.left == None and node.right == None:
            self.nums.append(int(binStr,2))
        else:
            self.traverse(node.left, binStr)
            self.traverse(node.right, binStr)

    def sumRootToLeaf(self, root: TreeNode) -> int:
        self.traverse(root,'')
        return sum(self.nums)

def main():
    soln = Solution()
    leftN = TreeNode(0, TreeNode(0), TreeNode(1))
    rightN = TreeNode(1, TreeNode(0), TreeNode(1))
    rootNode = TreeNode(1, leftN, rightN)
    print(soln.sumRootToLeaf(rootNode))

if __name__ == "__main__":
    main()