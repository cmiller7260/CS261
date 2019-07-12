
package src;

import static java.lang.Math.min;

public class assign5 {

    static final int MAX = Integer.MAX_VALUE;
    static int minval = MAX;

    public static void main(String[] args) {
        String S[] = new String[20];
        S[0]="at";
        S[1]="the";
        S[2]="ball";
        S[3]="game";
        S[4]="i";
        S[5]="am";
        S[6]="going";
        S[7]="to";
        S[8]="be";
        S[9]="there";
        S[10]="however";
        S[11]="tomorrow";
        S[12]="somewhat";
        S[13]="maybe";
        S[14]="makeshift";
        S[15]="layers";
        S[16]="point";
        S[17]="there";
        S[18]="furthermore";
        S[19]="end";


        int M = 20; // max chars in a line
        

        minBadDynamicChoice(S,M);
        System.out.println("the minimum badness is : " + minBad(S,M,0));
    }

    /**
     * this is my extra space procedure.
     *
     * @param S an array of strings - the input
     * @param M the maximum number of charicters allowed in a single line
     * @param i the start index in the S array
     * @param j the end index in the S array
     * @return returns an int that is the amount od extra space at the end of the line
     * negative return meant input went past max line
     */
    static int extraSpace (String[] S, int M, int i, int j){
        int space = M-j+i;
        for (int k = i; k <= j; k++){
            space = space - S[k].length();
        }
        return space;
    }

    /**
     * this procedure calculates the extra space in a line. MAX if the line exceeds M.
     *
     * @param S an array of strings - the input
     * @param M the maximum number of charicters allowed in a single line
     * @param i the start index in the S array
     * @param j the end index in the S array
     * @return returns an int that is the amount od extra space at the end of the line
     */
    static int badnessLine (String[] S, int M, int i, int j){
        int badness = extraSpace(S,M,i,j);
        if (badness < 0){
            return MAX;
        }
        else{
            return badness;
        }
    }

    /**
     *  this procedure calculate the minimum line badness in an input.
     *  i was unable to make this recursive because then i had no way to retain the minimum extra space encountered.
     *  my solution goes through the input and finds the maximum words that will fit in a line and sets minbadness to
     *  the minumum of minbad and the current line badness. then the process loops untill the end of the input is hit.
     *  at this point the minbad is returned becasue the last line is not counted in the minimum badness.
     *
     *  added a global for the minval ... now its recursive.
     *
     * @param S an array of strings - the input
     * @param M the maximum number of charicters allowed in a single line
     * @param i the starting index. in my case alwayse want to be 0.
     * @return a int that is the minmum badness encountered.
     */
    static int minBad (String[] S, int M, int i){
        int n = S.length;
        int j = i+1;
        int badness=0;
        //int minbadness = MAX;
        //while(j < n) {
            while (badness != MAX) {
                if(j >= n){
                    return minval;
                }
                badness = badnessLine(S, M, i, j);
                j++;
            }
            j = j-1;
            badness = badnessLine(S, M, i, j-1);
            minval = min(minval, badness);
            minBad(S,M,j);
//            i = j;
//            j++;
//            badness = 0;
        //}
        return minval;
    }

//    minBadDynamic (String[] S, int M){
//
//    }

    /**
     * i did not understand the instructions.... my solution give the same result, however I did not use the accessory functions.
     * my function goes through the input S and finds the max words that can fit in a line, then calculates the line badness
     * and prints the line followed by the line badness.
     * this process continues untill the end of the input S.
     * @param S an array of strings - the input
     * @param M the maximum number of charicters allowed in a single line
     */
    static void minBadDynamicChoice (String[] S, int M){
        int n = S.length;
        int i = 0;
        int j = 1;
        int badness=0;
        while(j <= n) {
            while (badness != MAX) {
                if(j >= n){
                    j++;
                    break;
                }
                badness = badnessLine(S, M, i, j);
                j++;
            }
            j = j-1;
            for (int x = i; x < j; x++) {
                System.out.print(S[x] + " ");
            }
            badness = badnessLine(S, M, i, j-1);
            for(int x = 0; x < badness; x++){
                System.out.print(" ");
            }
            System.out.println("| badness : " + badness);

            i = j;
            j++;
            badness = 0;
        }
    }

}
