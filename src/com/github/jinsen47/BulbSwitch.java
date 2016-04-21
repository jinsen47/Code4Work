package com.github.jinsen47;

/**
 * Created by Jinsen on 15/12/21.
 */
public class BulbSwitch {
    /**
     * A bulb ends up on iff it is switched an odd number of times.
     * Bulb i is switched in round d iff d divides i. So bulb i ends up on iff it has an odd number of divisors.
     * Divisors come in pairs, like i=12 has divisors 1 and 12, 2 and 6, and 3 and 4. Except if i is a square,
     * like 36 has divisors 1 and 36, 2 and 18, 3 and 12, 4 and 9,
     * and double divisor 6. So bulb i ends up on iff and only if i is a square.
     * So just count the square numbers.

     * @param n
     * @return
     */
    public static int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }

    public static void main(String[] args) {
        System.out.println(bulbSwitch(2));
    }
}
