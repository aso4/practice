package com.company;

/**
 * Created by albertso on 4/21/17.
 */
public class BasicOperations
{
    public static Integer basicMath(String op, int v1, int v2)
    {
        int solution = 0;
        if (op == "+") {
            solution = v1 + v2;
        } else if (op == "-") {
            solution = v1 - v2;
        } else if (op == "*") {
            solution = v1*v2;
        } else if (op == "/") {
            solution = v1/v2;
        }
        return solution;
    }
}

/* switch statement with thrown exceptions and default case
public class BasicOperations
{
    public static Integer basicMath(String op, int v1, int v2)
    {
        switch (op) {
            case "-":
                return v1 - v2;
            case "+":
                return v1 + v2;
            case "*":
                return v1 * v2;
            case "/": {
                if (v2 == 0)
                    throw new IllegalArgumentException("Division by zero");
                return v1 / v2;
            }
            default:
                throw new IllegalArgumentException("Unknown operation: " + op);
        }
    }
}*/
