 class Solution {

    public int majorityElement(int[] nums) {
        int n = nums.length;

        for (int val : nums) {
            int count = 0;

            for (int el : nums) {
                if (el == val) {
                    count++;
                }
            }

            if (count > n / 2) {
                return val;
            }
        }

        return -1; // never reached (given majority exists)
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] num = {3, 2, 3};
        System.out.println(obj.majorityElement(num));
    }
}
