package nyc.c4q.hakeemsackesbramble;

import java.util.ArrayList;

/**
 * Created by hakeemsackes-bramble on 11/22/16.
 */
public class parenthesis {

    public static void main(String[] args) {
        System.out.println(printAllOptions3(4));
    }

    public static ArrayList<String> printAllOptions(int number) {
        ArrayList<String> allOutcomes = new ArrayList<>();
        String outcome = "";
        if (number == 0) {
            return allOutcomes;
        }

        allOutcomes.add(outcome);
        allOutcomes.addAll(printAllOptions(number - 1));

        return allOutcomes;
    }

    public static String outerParens(ArrayList<String> string, int numberOfPairs) {
        String openParens = "";
        String closeParens = "";

        for (int i = string.size(); i < numberOfPairs; i++) {
            openParens += "(";
            closeParens += ")";
        }
        return openParens + string + closeParens;
        // ()()()
        // (()())
        // ((()))
    }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    static String printAllOptions2(double numberOfPairs) {
        return decToBin2(((int) Math.pow(2, numberOfPairs)) - 1, (int) numberOfPairs);
    }

    static String decToBin(int number, int length) {
        int start = number;
        String binary = "";
        if (number == -1) {
            return "0";
        }
        for (int i = (int) (Math.log(number) / Math.log(2)); i >= 0; i--) {
            if ((int) (start / Math.pow(2, i)) == 1) {
                binary += ")(";
                start -= Math.pow(2, i);
            } else {
                binary += "()";
            }

        }
        while (binary.length() != length * 2) {
            binary = "()" + binary;
        }
        binary = "(" + binary + ")";
        return binary + " || " + decToBin2(number - 1, length);
    }

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    static String printAllOptions3(double numberOfPairs) {
        int base = 2;
        if (base < numberOfPairs - 1) {
            base = (int) numberOfPairs - 1;
        }
        return decToBin2(((int) Math.pow(base, numberOfPairs - 1)) - 1, (int) numberOfPairs - 1);
    }

    static String decToBin2(int number, int length) {
        int start = number;
        String binary = "";
        int base = 2;
        int test = 0;
        if (base < length) {
            base = length;
        }
        ArrayList<String> set = new ArrayList<>();
        set.add("()");
        set.add(")(");
        // for more than 3 parens
        if (length >= 3) {
            for (int i = 2; i < length + 1; i++) {
                String openParens = "";
                String closeParens = "";
                for (int j = 0; j < i; j++) {
                    openParens += "(";
                    closeParens += ")";
                }
                set.add(openParens + closeParens);
            }
            System.out.println(set);
        }

        if (number == -1 || length < 1) {
            String openParens = "";
            String closeParens = "";

            for (int i = 0; i <= length; i++) {
                openParens += "(";
                closeParens += ")";
            }
            return openParens + closeParens;
        }
        for (int i = (int) (Math.log(number) / Math.log(base)); i >= 0; i--) {
            if ((int) (start / Math.pow(base, i)) != 0) {
                int a = (int) (start / Math.pow(base, i));
                binary += set.get(a);
                start -= a * Math.pow(base, i);
                test += a;

            } else {
                binary += set.get(0);
                test += 1;
            }

        }
        while (binary.length() <= length) {
            binary = "()" + binary;
        }

        binary = "(" + binary + ")";
        if (test <= length) {
            return binary + " || " + decToBin2(number - 1, length);
        } else {
            return decToBin2(number - 1, length);
        }
    }

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    static String printAllOptions4(double numberOfPairs) {
        return decToBase3(((int) Math.pow(numberOfPairs - 2, numberOfPairs - 1)) - 1, (int) numberOfPairs - 1);
    }

    static String decToBase3(int number, int length) {
        int start = number;
        String binary = "";
        int logBase = 2;
        int test = 0;
        ArrayList<String> set = new ArrayList<>();
        set.add("()");
        set.add(")(");
        // for more than 3 parens
        if (length >= 3) {
            for (int i = 2; i < length + 1; i++) {
                String openParens = "";
                String closeParens = "";
                for (int j = 0; j < i; j++) {
                    openParens += "(";
                    closeParens += ")";
                }
                set.add(openParens + closeParens);
            }
            logBase = set.size();
        }
        if (number == -1) {

            String openParens = "";
            String closeParens = "";

            for (int i = 0; i <= length; i++) {
                openParens += "(";
                closeParens += ")";
            }
            return openParens + closeParens;
        }
        for (int i = (int) (Math.log(number) / Math.log(logBase)); i > 0; i--) {
            binary += set.get((int) (start / Math.pow(logBase, i)));
            start -= Math.pow(logBase, i);
            test += i;
        }
//        if(length< test){
//            binary = "";
//        }

        while (binary.length() <= length * 2) {
            binary = ")(" + binary;
        }
        binary = "(" + binary + ")";

        return binary + " || " + decToBin2(number - 1, length);
    }
    // () , )( , (()), ((())),
}
