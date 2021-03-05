package main.java;
import java.lang.Math;
import java.math.BigDecimal;
import java.util.Scanner;
/*
    1073741824
 */
public class Test {
    public static void main(String[] args) {
        int i = 0;
        do {
            Scanner sc = new Scanner(System.in);
            choices();
            System.out.print("Enter your choice: ");
            i = sc.nextInt();
            if (i == 1)
            {
                System.out.print("Integer n: ");
                int n = sc.nextInt();
                System.out.print("Double x: ");
                double x = sc.nextDouble();
                System.out.println("n = " + n + "\nx = " + x);
                System.out.println("**Multiplication x*n");
                System.out.println(String.format("\t+ Multiply: %f", x*n));
                System.out.println(String.format("\t+ Multiply by adding: %f", multiplyByAdd(n, x)));
                System.out.println(String.format("\t+ Fast algorithm: %f", multiplyByFastAlgorithm(n, x)));
                System.out.println("------------------------------------");
                System.out.println("**Power x^n");
                System.out.println(String.format("\t+ Pow in Math: %f", Math.pow(x, n)));
                System.out.println(String.format("\t+ Pow by multiplying: %f", powByMultiply(n, x)));
                System.out.println(String.format("\t+ Fast algorithm: %f", powByFastAlgorithm(n, x)));
                System.out.println("------------------------------------");
                System.out.println("**BigDecimal");
                BigDecimal a = new BigDecimal(n);
                BigDecimal b = new BigDecimal(x);
                System.out.println("\t+ Multiply with big decimal: " + b.multiply(a));
                System.out.println("\t+ Pow with big decimal: " + b.pow(n));
                System.out.println("------------------------------------");
            }
        } while (i != 2);
    }

    static void choices()
    {
        System.out.println("1. Continue");
        System.out.println("2. Exit");
    }

    static double multiplyByAdd(int n, double x)
    {
        double result = 0;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++)
        {
            result += x;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
        return result;
    }

    static double multiplyByFastAlgorithm(int n, double x)
    {
        double result = 0;
        long startTime = System.currentTimeMillis();
        while (n > 0)
        {
            if (n % 2 == 1)
            {
                result += x;
            }
            n /= 2;
            x += x;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
        return result;
    }

    static double powByMultiply(int n, double x)
    {
        double result = 1;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++)
        {
            result *= x;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
        return result;
    }

    static double powByFastAlgorithm(int n, double x)
    {
        double result = 1;
        long startTime = System.currentTimeMillis();
        while (n > 0)
        {
            if (n % 2 == 1)
            {
                result *= x;
            }
            n /= 2;
            x *= x;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
        return result;
    }

    /*static void usingBigDecimal(int n, double x)
    {
        BigDecimal a = new BigDecimal(n);
        BigDecimal b = new BigDecimal(x);
        System.out.println("Multiply with big decimal: " + b.multiply(a));
        System.out.println("Pow with big decimal: " + b.pow(n));
    }*/

}
