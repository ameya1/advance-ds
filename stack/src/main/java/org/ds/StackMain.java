package org.ds;

import java.util.Stack;

public class StackMain {
    public static void main(String[] args) {
        /*System.out.println(balancedBrackets("[{()}{}]"));
        System.out.println(balancedBrackets("[{(){}]"));*/
        //reverse();
        lexicographicallyNumbers(1000);
    }

    public static void lexicographicallyNumbers(int n) {
        for(int i = 1; i < 10; i++) {
            lexicographicallyNumbers(i, n);
            System.out.println();
        }
    }

    public static void lexicographicallyNumbers(int num, int n) {

        if(num >= n) {
            return;
        }
        System.out.print(num + " ");
        for(int i = 0; i < 10; i++) {
            lexicographicallyNumbers(10 * num + i, n);
        }
    }

    public static void reverse() {
        Stack<Integer> stack  =new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println(stack);
        reverse(stack);
        System.out.println(stack);
    }

    public static void reverse(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop();
            reverse(stack);
            reverse(stack, top);
        }
    }

    public static void reverse(Stack<Integer> stack, int top) {
        if(stack.isEmpty()) {
            stack.push(top);
            return;
        }

        int num = stack.pop();
        reverse(stack, top);
        stack.push(num);
    }



    public static boolean balancedBrackets(String input) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < input.length(); i++) {
            char bracket = input.charAt(i);
            if(isOpeningBracket(bracket))
                stack.push(bracket);
            else {
                char ch = stack.pop();
                if(ch == '(' && bracket == ')')
                    continue;
                else if(ch == '{' && bracket == '}')
                    continue;
                else if(ch == '[' && bracket == ']')
                    continue;
                else
                    return false;
            }
        }
        return true;
    }

    public static boolean isOpeningBracket(char bracket) {
        return bracket == '(' || bracket == '{' || bracket == '[';
    }

    public static char closingBracket(char bracket) throws Exception {
        switch (bracket) {
            case '(' -> { return ')'; }
            case '{' -> { return '}'; }
            case '[' -> { return ']'; }
            default -> throw new Exception("Incorrect bracket");
        }
    }
}