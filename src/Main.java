// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println(longestBinary("1101100111"));
    }
    public static int longestBinary(String s){

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

}
