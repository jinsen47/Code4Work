package com.github.jinsen47;

/**
 * Created by Jinsen on 16/4/23.
 */
public class CallOrder {
    public CallOrder() {
        System.out.println("Hello A");

    }
    {
        System.out.println("I am A class");
    }

    static {
        System.out.println("static A");
    }

    public static void main(String[] args) {
        B o = new B();
    }

    public static class B extends CallOrder {
        public B() {
            System.out.println("Hello B");
        }
        {
            System.out.println("I am B class");
        }

        static {
            System.out.println("static B");
        }

    }
}
