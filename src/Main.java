import org.jetbrains.annotations.NotNull;

//Welcome to my scratch pad for random programming problems that sounded fun or cool!
//I usually warm up or do these when I'm a bit bored
public class Main {
    public static void main(String[] args) {
        //Longest Binary
        //System.out.println(longestBinary("1101100111"));

        //numArray
        //int[] tester = {10,5,2,6};
        //System.out.println(numSubarrayProductLessThanK(tester, 100));

        //findBest Array
        //int[] arr = {1,1000000,1,1,1,1,1,100000000,99,2};
        //System.out.println(findBest(arr,2));

        //Find max Average
        //Tested within online IDE

        //Max ones binary III
        //Tested within online IDE

        //GPC ONE LIGHT WORK :))))
        int[] arr = {99999,99,99,99,99,10000};
        int target = 1000;
        System.out.println(gpcone(arr,target));





    }
    public static int longestBinary(String s){
        //Problem:
        //You are given a binary string s (a string containing only "0" and "1").
        // You may choose up to one "0" and flip it to a "1".
        // What is the length of the longest substring achievable that contains only "1"?
        int answer = 0;
        int left = 0;
        int zero_count = 0;
        for(int right = 0;right<s.length();right++){
            if(s.charAt(right) == '0'){
                zero_count++;
            }
            while(zero_count > 1){
                if(s.charAt(left) == '0'){
                    zero_count = zero_count - 1;
                }
                left = left + 1;
            }
            answer = Math.max(answer,right - left + 1);

        }


        return answer;
    }
    public static int numSubarrayProductLessThanK(int[] nums, int k){
        // return the number of subarrays where the product of all the elements in the subarray is strictly less than k
        //An important math trick is to note that the number of sub arrays that end at right = length of subarray
        int answer = 0;
        int curr = 1;
        int left = 0;
        if(k <= 1){
            return 0;
        }
        for(int right = 0;right<nums.length;right++){
            curr = curr * nums[right];
            while(curr >= k){
                curr = curr/nums[left];
                left = left + 1;
            }

            answer = answer + right - left + 1;

        }

        return answer;
    }
    public static int findBest(int[] nums, int k){
        //Find the sum of the chonkiest subarray with length k
        int answer = 0;
        int curr_sum = 0;
        int left = 0;
        for(int i = 0;i<k;i++){
            curr_sum = curr_sum + nums[i];
        }
        answer = Math.max(curr_sum,answer);
        for(int right = k;right<nums.length;right++){
            curr_sum = curr_sum- nums[left] + nums[right];
            left = left + 1;
            answer = Math.max(curr_sum,answer);

        }

        return answer;
    }
    public static double MaxAvgSub(int[] nums, int k){
        double curr = 0;
        double answer = 0;
        if(nums.length == 1){

            return nums[0];
        }
        for(int i = 0;i<k;i++){
            curr = curr + nums[i];
        }
        answer = curr;
        int left = 0;
        for(int j = k;j<nums.length;j++){
            curr = curr - nums[left] + nums[j];
            left = left + 1;
            answer = Math.max(answer,curr);
        }

        return answer/k;
    }
    public static double MaxOnesBinary(int[] nums,int k){
        int answer = 0;
        int zero_count = 0;
        int left = 0;
        for(int right = 0; right <nums.length;right++){

            if(nums[right] == 0){
                zero_count++;
            }
            while(zero_count >k){
                if(nums[left] == 0){
                    zero_count--;
                }
                left++;
            }
            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }
    //Given an array find the length of longest subarray such that its not greater than the target
    public static int gpcone(int[] nums, int target){
        int answer = 0;
        int left = 0;
        int curr_max = 0;
        for(int right = 0;right<nums.length;right++){
            curr_max = curr_max + nums[right];
            while(curr_max > target){
                curr_max = curr_max - nums[left];
                left++;
            }
            curr_max = right - left + 1;
            answer = Math.max(answer,curr_max);
        }

        return answer;
    }


}
