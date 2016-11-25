package nyc.c4q.hakeemsackesbramble;

import java.util.ArrayList;

/**
 * Created by hakeemsackes-bramble on 11/22/16.
 */
public class parenthesis {

    public static void main(String[] args) {
        System.out.println(printAllOptions2(3));
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
        return decToBin(((int) Math.pow(2, numberOfPairs)) - 1, (int) numberOfPairs);
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
        return binary + " || " + decToBin(number - 1, length);
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
            System.out.println("t" + base);
        }
        return decToBin2(((int) Math.pow(base, numberOfPairs - 1)) - 1, (int) numberOfPairs - 1,"");
    }

    static String decToBin2(int combinations, int setLength, String lastSet) {
        int start = combinations;
        String binary = "";
        int base = 2;
        int test = 0;
        if (base < setLength) {
            base = setLength;
        }
        ArrayList<String> set = new ArrayList<>();
        set.add(")(");
        set.add("()");
        // for more than 3 parens
        if (setLength >= 3) {
            for (int i = 2; i < setLength + 1; i++) {
                String openParens = "";
                String closeParens = "";
                for (int j = 0; j < i; j++) {
                    openParens += "(";
                    closeParens += ")";
                }
                set.add(openParens + closeParens);
            }
        }

        if (combinations == -1 || setLength < 1) {
            String openParens = "";
            String closeParens = "";

            for (int i = 0; i <= setLength; i++) {
                openParens += "(";
                closeParens += ")";
            }
            return openParens + closeParens;
        }
        for (int i = (int) (Math.log(combinations) / Math.log(base)); i >= 0; i--) {
            int a = (int) (start / Math.pow(base, i));
            int b = a;
            if (a == 0) {
                b = 1;
            }
           if (test + b <= setLength) {
               binary += set.get(a);
               start -= a * Math.pow(base, i);
               test += a;
               if (a == 0) {
                   test += 1;
               }
           }else {
               start -= a * Math.pow(base, i);
           }
        }

        while (test < setLength) {
            binary = ")(" + binary;
            test += 1;
        }
        System.out.println("" + combinations + " " + test);
        binary = " (" + binary + ") " +"||";
        if (binary.equals(lastSet)){
            binary = "";
        }
        return binary  + decToBin2(combinations - 1, setLength , binary);

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

        return binary + " || " + decToBase3(number - 1, length);
    }
    // () , )( , (()), ((())),
}
