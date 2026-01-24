 class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: nums2 ka Next Greater nikaalo
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }

            int nge = stack.isEmpty() ? -1 : stack.peek();
            map.put(nums2[i], nge);
            stack.push(nums2[i]);
        }

        // Step 2: nums1 ke answers uthao
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}