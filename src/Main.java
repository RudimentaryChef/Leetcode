import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.*;

//Welcome to my scratch pad for random programming problems that sounded fun or cool!
//I usually warm up or do these when I'm a bit bored
//These solutions are all mine
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
        //int[] arr = {99999,99,99,99,99,10000};
        //int target = 1000;
        //System.out.println(gpcone(arr,target));

        //Prefix Array Example one
        //int[] nums = {1, 6, 3, 2, 7, 2};
        //int[][] queries = {{0,3},{2,5},{2,4}};
        //int limit = 13;
        //boolean[] answer = prefixOne(nums,queries,limit);
        //System.out.println(Arrays.toString(answer));






    }
    public static long taskOfPairing(List<Long> freq) {
        // Write your code here
        long answer = 0;
        if(freq.size() == 1){
            return freq.get(0)/2;
        }
        for(int i = 0;i<freq.size() ;i++){

            if(freq.get(i) >= 2){
                answer = answer + freq.get(i)/2;
                freq.set(i, freq.get(i) %2);

            }
            if(freq.get(i) == 1 && i != 0 && freq.get(i-1) > 0){
                freq.set(i,freq.get(i) - 1);
                freq.set(i - 1,freq.get(i - 1) - 1);
                answer++;
            }
            if(freq.get(i) == 1 && i != freq.size() -1 && freq.get(i+1) > 0){
                freq.set(i,freq.get(i) - 1);
                freq.set(i +1,freq.get(i + 1) - 1);
                answer++;
            }

        }


        return answer;

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
    public static boolean[] prefixOne(int[] nums, int[][] queries,int limit){
        //return a boolean array that represents the answer to each query.
        // A query is true if the sum of the subarray from x to y is less than limit,
        // or false otherwise.
        boolean[] answer = new boolean[queries.length];
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for(int i = 1;i<nums.length;i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
        for(int i = 0;i<queries.length;i++){
            answer[i] = (prefixSum[queries[i][1]] - prefixSum[queries[i][0]] + nums[queries[i][0]]) < limit;
        }
            return answer;
    }
    public static int waysToSplitArray(int[] nums) {
        int answer = 0;
        long[] prefix = new long[nums.length];
        prefix[0] = nums[0];
        for(int i = 1;i< nums.length;i++){
            prefix[i] = prefix[i-1] + nums[i];
        }
        long first;
        long second;
        long combo = prefix[nums.length -1];
        System.out.println(Arrays.toString(prefix));
        for(int split = 0;split <nums.length - 1;split++){
            first = prefix[split];
            second = combo - first;
            if(first >= second ){
                System.out.println(first + " " + second);
                answer++;
            }

        }
        return answer;

    }
    public static int minStartValue(int[] nums) {
        int answer = 1;
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i = 1;i<prefix.length;i++){
            prefix[i] = prefix[i-1] + nums[i];
        }
        int currsum;
        for(int i =0;i<nums.length;i++){
            currsum = prefix[i];

            if(currsum + answer < 1){
                answer = currsum * -1  + 1;
            }

        }


        return answer;
    }
    public static int middleLinked(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;

        }
        return slow.val;
    }
    public static boolean cycleDetector(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow.equals(fast)){
                return true;
            }
        }
        return false;
    }
    public static ListNode FindKth(ListNode head, int k){
        ListNode slow = head;
        ListNode fast = head;
        for(int i = 0;i<k;i++){
            fast = fast.next;
        }
        while(fast!= null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;



    }
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode nextNode = null;
        ListNode curr = head;
        while(curr != null){
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
    public static char repeatedCharacter(String s) {
        Map<Character, Integer> hashy = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            if(hashy.containsKey(s.charAt(i))){
                return s.charAt(i);
            }
            else{
                hashy.put(s.charAt(i),1);
            }
        }
        return 'z';

    }
    //Given an integer array nums,
    // find all the numbers x in nums that satisfy the following:
    // x + 1 is not in nums, and x - 1 is not in nums.
    public static List<Integer> hashSet(int[] nums){
        List<Integer> answer = new ArrayList<>();
        HashSet<Integer> holder = new HashSet<>();

        for(int n : nums){
            holder.add(n);
        }
        for(int n : nums){
            if(!(holder.contains(n + 1) || holder.contains(n-1))){
                answer.add(n);
            }
        }
        return answer;
    }
    public static  boolean checkIfPangram(String sentence) {
        HashSet<Character> set = new HashSet<>();
        for(int i = 0;i<sentence.length();i++){
            set.add(sentence.charAt(i));
        }
        if (set.size() == 26){
            return true;
        }
        return false;
    }
    public int countElements(int[] arr) {
        int answer = 0;
        HashSet<Integer>  hol = new HashSet<Integer>();
        for(int n:arr){
            hol.add(n);
        }
        for(int n:arr){
            if(hol.contains(n+1)){
                answer++;
            }
        }
        return answer;
    }
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int answer = 0;
        int left = 0;
        HashMap<Character, Integer> hashy = new HashMap<>();
        for(int right =0;right<s.length();right++){

            if(!hashy.containsKey(s.charAt(right))){
                hashy.put(s.charAt(right), 1);
            }
            else{
                hashy.put(s.charAt(right), hashy.get(s.charAt(right)) + 1);
            }

            while(hashy.size() > k){
                char leftChar = s.charAt(left);
                //shift the left guy over one
                hashy.put(leftChar,hashy.get(leftChar) -1);
                if(hashy.get(leftChar) == 0){
                    hashy.remove(leftChar);
                }
                left++;
            }
            answer = Math.max(right - left + 1,answer);
        }

        return answer;
    }
    public static List<Integer> intersection(int[][] nums) {
        List<Integer> answer = new ArrayList<Integer>();
        HashMap<Integer,Integer> hashy = new HashMap<>();
        int req = nums.length;
        for(int i = 0;i<nums.length;i++){
            for(int check: nums[i]){


                if(hashy.containsKey(check)){
                    hashy.put(check, hashy.get(check) + 1);
                }
                else{
                    hashy.put(check,1);
                }
            }
        }

        for(int n:hashy.keySet()){
            if(hashy.get(n) == req ){
                answer.add(n);
            }
        }
        Collections.sort(answer);
        return answer;
    }




}


class KthLargest {
    private static int k;
    private static PriorityQueue<Integer> heap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.heap = new PriorityQueue<>();
        for(int n:nums){
            heap.add(n);
        }
        while(heap.size() > k){
            heap.remove();
        }

    }

    public int add(int val) {
        heap.add(val);
        if(heap.size()>k){
            heap.remove();
        }
        return heap.peek();
    }
}
class MedianFinder {
    PriorityQueue<Double> big = new PriorityQueue<>();
    PriorityQueue<Double> small = new PriorityQueue<>(Comparator.reverseOrder());
    public MedianFinder() {


    }

    public void addNum(int num) {
        big.add((double)num);
        small.add(big.remove());
        if(small.size() > big.size()){
            big.add(small.remove());
        }


    }

    public double findMedian() {

        if((big.size() + small.size()) %2 == 0){
            return (big.peek() + small.peek())/2;
        }
        else{
            return big.peek();
        }
    }

}



    /*
     * Complete the 'authEvents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts 2D_STRING_ARRAY events as parameter.
     */
class result {
    public static List<Integer> authEvents(List<List<String>> events) {
        // Write your code here
        List<Integer> answer = new ArrayList<>();
        String secret = "shhhhh";
        System.out.println(hash("000A"));
        for(int i = 0;i<events.size();i++){
            if(events.get(i).get(0).equals("setPassword")){
                secret = hash(events.get(i).get(1));
            }
            else{

                if(secret.equals(events.get(i).get(1))){
                    answer.add(1);
                }
                else if(1 > 2){ // how to figure if its one character off
                    System.out.println("hi");
                }
                else{
                    answer.add(0);
                }
            }
        }
        return answer;

    }
    public static String hash(String s){
        String hashedversion = "";
        int p = 131;
        long M = (long) Math.pow(10,9) + 7;
        int[] hashy = new int[s.length()];
        for(int i = 0;i<s.length();i++){
            hashy[i] = (int) s.charAt(i);
        }
        long left = 0;
        for(int i = 0;i<hashy.length;i++){
            left = left + (hashy[i] * (long) Math.pow(p,s.length() - 1 - i));
        }
        long func =(long) (left % M);
        hashedversion = "" + func;
        return hashedversion;
    }
    public static int returnMiddle(List<Integer> arr){
        int answer = 0;

        return answer;
    }
    public static String removeDuplicates(String s) {
        Stack<Character> hol = new Stack<Character>();
        String answer = "";
        char c;
        for(int i = 0;i<s.length();i++){
            c = s.charAt(i);
            if(hol.isEmpty()){
                hol.add(c);
            }
            else if(c == hol.peek()){
                hol.pop();
            }
            else{
                hol.add(c);
            }
        }
        while(!hol.isEmpty()){
            answer = hol.pop() + answer;
        }
        return answer;

    }


}
class stackStuff {
    public static String removeDuplicates(String s) {
        Stack<Character> hol = new Stack<Character>();
        String answer = "";
        char c;
        for(int i = 0;i<s.length();i++){
            c = s.charAt(i);
            if(hol.isEmpty()){
                hol.add(c);
            }
            else if(c == hol.peek()){
                hol.pop();
            }
            else{
                hol.add(c);
            }
        }
        while(!hol.isEmpty()){
            answer = hol.pop() + answer;
        }
        return answer;

    }
}
class BackCompare {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder S = new StringBuilder();
        StringBuilder T = new StringBuilder();
        for(char c: s.toCharArray()){
            if(c == '#'){
                if(!S.isEmpty()){
                    S.deleteCharAt(S.length() - 1);
                }
            }
            else{
                S.append(c);
            }

        }
        for(char c: t.toCharArray()){

            if(c == '#'){
                if(!T.isEmpty()){
                    T.deleteCharAt(T.length() - 1);
                }
            }
            else{
                T.append(c);
            }

        }

        return S.toString().equals(T.toString());
    }
}

class makeStringGoodg {
    public String makeGood(String s) {
        StringBuilder answer = new StringBuilder();
        //plus or minus 32
        char c;
        for(int i = 0;i<s.length();i++){
            c = s.charAt(i);
            if(answer.isEmpty() || Math.abs(answer.charAt(answer.length() - 1) - c) != 32){
                answer.append(c);
            }
            else{
                answer.deleteCharAt(answer.length() - 1);
            }
        }
        return answer.toString();
    }
}