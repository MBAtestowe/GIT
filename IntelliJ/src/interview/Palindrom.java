package interview;

public class Palindrom {
    public static void main(String[] args) {
        System.out.println(isPallindrom("kajak"));
    }
    public static boolean isPallindrom (String word){
       int n = word.length();
       for (int i =0; i<(n/2); i++){
           if (word.charAt(i) != word.charAt(n-i-1)){
               return false;
           }
       }
        return true;
    }
}
