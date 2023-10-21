//Welcome to my scratch pad for random programming problems I thought sounded fun or cool!
//I usually warm up or do these when I'm a bit bored
public class Main {
    public static void main(String[] args) {
        //System.out.println(longestBinary("1101100111"));

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

            if(curr >= k){
                while(curr >= k){
                    curr = curr/nums[left];
                    left = left + 1;
                }
            }
            answer = answer + right - left + 1;

        }

        return 0;
    }

}
