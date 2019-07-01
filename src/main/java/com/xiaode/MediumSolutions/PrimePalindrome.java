package com.xiaode.MediumSolutions;

/**
 * Created by liyangde on Jun, 2019
 *
 * 866. Prime Palindrome
 *
 * Find the smallest prime palindrome greater than or equal to N.
 *
 * Recall that a number is prime if it's only divisors are 1 and itself, and it is greater than 1.
 *
 * For example, 2,3,5,7,11 and 13 are primes.
 *
 * Recall that a number is a palindrome if it reads the same from left to right as it does from right to left.
 *
 * For example, 12321 is a palindrome.
 *
 * Example 1:
 *
 * Input: 6
 * Output: 7
 * Example 2:
 *
 * Input: 8
 * Output: 11
 * Example 3:
 *
 * Input: 13
 * Output: 101
 */
public class PrimePalindrome {

    //TLE
    //     public int primePalindrome(int N) {
//         //
//         while(N <= 100000000) {
//             if(isPrime(N)){
//                 if(isPalindrome(N)) return N;
//             }
//             N++;
//         }
//         return 0;

//     }

//     boolean isPrime(int N) {
//         if (N < 2 || N % 2 ==0) return N == 2;
//         for (int i = 3; i*i <= N; i+=2){
//              if (N % i == 0) return false;
//         }
//         return true;
//     }

//     boolean isPalindrome(int N) {
//         StringBuilder s = new StringBuilder(Integer.toString(N));
//         String os = Integer.toString(N);
//         String rs = s.reverse().toString();
//         return rs.equals(os);
//     }

    // Intuition:
    // All palindrome with even digits is multiple of 11.
    // So: we only consider palindrome with odd digits.

    public int primePalindrome(int N) {
        if (8 <= N && N <= 11) return 11;
        for (int x = 1; x < 100000; x++) {
            //construct the palindrome number with odd digits
            String s = Integer.toString(x), r = new StringBuilder(s).reverse().toString().substring(1);

            int y = Integer.parseInt(s + r);
            if (y >= N && isPrime(y)) return y;
        }
        return -1;
    }

    public Boolean isPrime(int x) {
        if (x < 2 || x % 2 == 0) return x == 2;
        for (int i = 3; i * i <= x; i += 2)
            if (x % i == 0) return false;
        return true;
    }
}
