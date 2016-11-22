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
    static String printAllOptions2(double numberOfPairs) {
        return decToBin2(((int) Math.pow(2, numberOfPairs)) - 1, (int) numberOfPairs );
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


    static String printAllOptions3(double numberOfPairs) {
        return decToBin2(((int) Math.pow(2, numberOfPairs - 1)) - 1, (int) numberOfPairs - 1);
    }

    static String decToBin2(int number, int length) {
        int start = number;
        String binary = "";
        if (number == -1) {
            String openParens = "";
            String closeParens = "";

            for (int i = 0; i <= length; i++) {
                openParens += "(";
                closeParens += ")";
            }
            return openParens + closeParens;
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
}
