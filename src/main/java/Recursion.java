public class Recursion {

    static void recursiveMethod(int n){
        if (n < 1){
            System.out.println("n is less than 1");
        } else {
            recursiveMethod(n - 1);
            System.out.println(n);
        }
    }

    static int powerOfTwo(int n){
        if (n == 0){
            return 1;
        } else {
            return 2 * powerOfTwo(n-1);
        }
    }

    static int factorial(int n){
        if (n < 0){
            return -1;
        }
        if (n == 0 || n == 1){
            return 1;
        }
        return n * factorial(n-1);
    }

    static int fibonacci(int n){
        if (n < 0){
            return -1;
        }

        if (n == 0 || n == 1){
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    static int sumOfDigit(int n){
        if (n == 0 || n < 0){
            return 0;
        }
        return n%10 + sumOfDigit(n/10);
    }

    static int power(int base, int exp){
        if (exp < 0){
            return -1;
        }
        if (exp == 0){
            return 1;
        }
        return base * power(base, exp - 1);
    }

    static int gcd(int a, int b){
        if (a < 0 || b < 0){
            return -1;
        }
        if (b == 0){
            return a;
        }
        return gcd(b, a%b);
    }

    static int decimalToBinary(int n){
        if (n < 0){
            return -1;
        }
        if (n == 0){
            return 0;
        }
        return n%2 + 10 * decimalToBinary(n/2);
    }

    static int binaryToDecimal(String b, int i){
        int n = b.length();
        if (i == n -1){
            return b.charAt(i) - '0';
        }
        return ((b.charAt(i) - '0' << (n-i-1)) + binaryToDecimal(b, i+1));
    }

    static int numOfStep(int num){
        if (num == 0){
            return 0;
        }
        int result = 0;
        while (num != 0){
            result += 1 + (num & 1);
            num /= 2;
        }
        result--;
        return result;
    }

    static int productOfArray(int a[], int n){
        if (n <= 0){
            return 1;
        } else {
            return (productOfArray(a, n - 1) * a[n - 1]);
        }
    }

    static int recursiveRange(int num) {
        if (num<=0) {
            return 0;
        }
        return num + recursiveRange(num - 1);
    }

    static String reverse(String str)
    {
        if (str.isEmpty())
            return str;
        return reverse(str.substring(1)) + str.charAt(0);
    }

    static boolean isPalindrome(String s)
    {   // if length is 0 or 1 then String is palindrome
        if(s.length() == 0 || s.length() == 1)
            return true;
        if(s.charAt(0) == s.charAt(s.length()-1))
            return isPalindrome(s.substring(1, s.length()-1));
        return false;
    }

    static char first(String str) {
        if(str.isEmpty()) {
            return ' ';
        }
        if (Character.isUpperCase(str.charAt(0))) {
            return str.charAt(0);
        }else {
            return first(str.substring(1, str.length()));
        }
    }

    static String capitalizeWord(String str) {
        if(str.isEmpty()) {
            return str;
        }
        char chr = str.charAt(str.length()-1);
        if(str.length()==1) {
            return Character.toString(Character.toUpperCase(chr));
        }
        if((str.substring(str.length()-2, str.length()-1).equals(" "))) {
            chr = Character.toUpperCase(chr);
        }
        return capitalizeWord(str.substring(0,str.length()-1))+ Character.toString(chr);
    }

    public static void main(String[] args){
        //System.out.println(gcd(8, 4));

        int arr[] = {1, 2, 3, 4, 5};
        //System.out.println(productOfArray(arr, arr.length));

        System.out.println(numOfStep(binaryToDecimal("1", 0)));
    }
}
