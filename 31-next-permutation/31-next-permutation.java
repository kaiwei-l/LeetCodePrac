class Solution {
    public void swap(int left, int right, int[] nums) {
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;
    }
    
    public void reverse(int left, int right, int[] nums) {
        while (left <= right) {
            swap(left, right, nums);
            left++;
            right--;
        }
    }
    
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        } else if (nums.length == 2) {
            swap(0, 1, nums);
            return;
        }
        
        boolean isRev = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                isRev = false;
                break;
            }
        }
        if (isRev) {
            reverse(0, nums.length - 1, nums);
            return;
        }
        
        int right = nums.length - 1;
        int left = nums.length - 2;
        while (left != -1) {
            if (nums[left] < nums[right]) {
                int rightMin = nums.length - 1;
                while (rightMin != right) {
                    if (nums[rightMin] > nums[left]) {
                        break;
                    } else {
                        rightMin--;
                    }
                }
                swap(left, rightMin, nums);
                
                int curr = rightMin;
                int currNext = rightMin + 1;
                while (currNext != nums.length) {
                    if (nums[curr] < nums[currNext]) {
                        swap(curr, currNext, nums);
                        curr++;
                        currNext++;
                    } else {
                        break;
                    }
                }
                reverse(right, nums.length - 1, nums);
                break;
            } else {
                left--;
                right--;
            }
        }
    }
}