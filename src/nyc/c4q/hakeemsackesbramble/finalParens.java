package nyc.c4q.hakeemsackesbramble;

import java.util.ArrayList;

/**
 * Created by hakeemsackes-bramble on 11/25/16.
 */
public class finalParens {
    public static void main(String[] args) {
        System.out.println(printAllParens6(3));
    }

    public static String printAllParens5(int pairs) {
        int innerParens = (pairs - 1) * 2;
        return parensToBinary((int) Math.pow(2, innerParens) - 1, innerParens);
    }

    public static String parensToBinary(int number, int innerParens) {
        int start = number;
        String[] paren = {"(", ")"};
        String set = "";
        int openCount = 0;
        int closeCount = 0;
        int pairCount = 1;
        for (int i = (int) (Math.log(number) / Math.log(2)); i >= 0; i--) {
            if ((int) (start / Math.pow(2, i)) == 1) {
                set += paren[0];
                start -= Math.pow(2, i);
                openCount++;
            } else {
                set += paren[1];
                closeCount++;
            }
        }
        while (set.length() < innerParens) {
            set = paren[1] + set;
            closeCount++;
        }
        for (int l = 0; l < set.length(); l++) {
            if (paren[0].equals(String.valueOf(set.charAt(l)))) {
                pairCount++;
            } else if (paren[1].equals(String.valueOf(set.charAt(l)))) {
                pairCount--;
            } //if pairCount is ever less than zero make the count uneven on purpose to invalidate it
            if (pairCount <= -1) {
                closeCount += innerParens * 2;
                openCount -= innerParens * 2;
            }
        }
        System.out.println(pairCount);
        if (openCount != closeCount) {
            set = "";
        } else {
            set = " (" + set + ") " + number + "\n";
        }
        if (number <= 0) {
            return set;
        }

        return set + parensToBinary(number - 1, innerParens);
    }

    //#################################################################################
    //#################################################################################
    //#################################################################################
    //#################################################################################
    //#################################################################################
    //#################################################################################
    //#################################################################################

    //done without recursion


    public static String printAllParens6(int pairs) {
        int innerParens = (pairs - 1) * 2;
        return parensToBinary2((int) Math.pow(2, innerParens) - 1, innerParens);
    }

    public static String parensToBinary2(int number, int innerParens) {



        String[] paren = {")", "("};
        String group = "";

        for (int k = number; k >= 0; k--) {
            int start = k;
            String set = "";
            int openCount = 0;
            int closeCount = 0;
            int pairCount = 1;
            for (int i = (int) (Math.log(start) / Math.log(2)); i >= 0; i--) {

                if ((int) (start / Math.pow(2, i)) == 1) {
                    set += paren[0];
                    start -= Math.pow(2, i);
                    openCount++;
                } else {
                    set += paren[1];
                    closeCount++;
                }
            }
            while (set.length() < innerParens) {
                set = paren[1] + set;
                closeCount++;
            }
            for (int i = 0; i < set.length(); i++) {
                if (paren[1].equals(String.valueOf(set.charAt(i)))) {
                    pairCount++;
                } else if (paren[0].equals(String.valueOf(set.charAt(i)))) {
                    pairCount--;
                } //if pairCount is ever less than zero make the count uneven on purpose to invalidate it
                if (pairCount <= -1) {
                    closeCount += innerParens * 2;
                    openCount -= innerParens * 2;
                }
            }
            if (openCount != closeCount) {
                set = "";
            } else {
                set = " (" + set + ") " + k + "\n";
            }
            group += set;
        }

        return group;
    }


}
