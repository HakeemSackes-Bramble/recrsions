package nyc.c4q.hakeemsackesbramble;

import java.util.ArrayList;

/**
 * Created by hakeemsackes-bramble on 11/25/16.
 */
public class finalParens {
    public static void main(String[] args) {
        System.out.println(printAllParens5(4));
    }

    public static String printAllParens5(int pairs) {
        int innerParens = (pairs - 1) * 2;
        return parensToBinary((int) Math.pow(2, innerParens) - 1, innerParens);
    }

    public static String parensToBinary(int number, int innerParens) {
        int start = number;
        String[] paren = {")", "("};
        String set = "";
        String binSet = "";
        int openCount = 0;
        int closeCount = 0;
        for (int i = (int) (Math.log(number) / Math.log(2)); i >= 0; i--) {
            if ((int) (start / Math.pow(2, i)) == 1) {
                set += paren[0];
                binSet += 0;
                start -= Math.pow(2, i);
                openCount++;
            } else {
                set += paren[1];
                binSet += 1;
                closeCount++;
            }
        }

        while (set.length() < innerParens) {
            set = paren[1] + set;
            closeCount++;
        }
        System.out.println(number + "  " + openCount + " " + closeCount);
        if (openCount != closeCount) {
            set = "";
            binSet = "";
        } else {
            set = " (" + set + ") " + number;
            binSet = " (" + binSet + ") " + number;
        }
        if (number == 0) {
            return set;
        }
        System.out.println(binSet);
        return set + parensToBinary(number - 1, innerParens);
    }
}
