class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        def productAux(ans, nums, counter, product):
            if counter == len(nums) - 1:
                ans.append(product)
                return nums[counter]
            else:
                currentProduct = product * nums[counter]
                reverseProduct = productAux(ans, nums, counter + 1, currentProduct)
                ansProduct = product * reverseProduct
                ans.insert(0, ansProduct)
                return reverseProduct * nums[counter]
        ans = []
        productAux(ans, nums, 0, 1)
        return ans