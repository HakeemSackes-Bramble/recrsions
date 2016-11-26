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
        for (int i = 0; i < set.length(); i++) {
            if (set.charAt(i) =='('){
                pairCount++;
            }else if (set.charAt(i) ==')'){
                pairCount--;
            }
            if (pairCount <= -1) {  //if pairCount is ever less than zero make the count uneven on purpose to invalidate it
                closeCount += innerParens*2;
                openCount -= innerParens*2;
            }

        }

        if (openCount != closeCount) {
            set = "";
        } else {
            set = " (" + set + ") " + number;
        }
        if (number == 0) {
            return set;
        }

        return set + parensToBinary(number - 1, innerParens);
    }
}
