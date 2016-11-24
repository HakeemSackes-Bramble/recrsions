package nyc.c4q.hakeemsackesbramble;

/**
 * Created by hakeemsackes-bramble on 11/22/16.
 */
public class RomanNumbers {
    public static void main(String[] args) {
        System.out.println(romanToint("MCLXIV"));
    }
    public static int romanToint(String romanNumber) {


        int number = 0;
        String smallerString = "";


        if (romanNumber.length() == 0) {
            return 0;
        } else {
            number = numberValOfChar(romanNumber, 0);
        }

        if ((romanNumber.length() > 1) && (numberValOfChar(romanNumber, 0) < numberValOfChar(romanNumber, 1))) {
            number = number * (-1);
        }
        for (int i = 1; i < romanNumber.length(); i++) {
            smallerString += romanNumber.charAt(i);
        }

        return number + romanToint(smallerString);
    }

    private static int numberValOfChar(String romanString, int place) {
        int M = 1000;
        int D = 500;
        int C = 100;
        int L = 50;
        int X = 10;
        int V = 5;
        int I = 1;

        int number = 0;
        if (romanString.charAt(place) == ('M')) {
            number = M;
        } else if (romanString.charAt(place) == ('D')) {
            number = D;
        } else if (romanString.charAt(place) == ('C')) {
            number = C;
        } else if (romanString.charAt(place) == ('L')) {
            number = L;
        } else if (romanString.charAt(place) == ('X')) {
            number = X;
        } else if (romanString.charAt(place) == ('V')) {
            number = V;
        } else if (romanString.charAt(place) == ('I')) {
            number = I;
        }
        return number;
    }
}
