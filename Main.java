/*
 * INSTRUCTION:
 *     This is a Java staring code for hw6_1.
 *     When you finish the development, download this file and and submit to Canvas
 *     according to the submission instructions.

 *     Please DO NOT change the name of the main class "Main"
 */

// Finish the head comment with Abstract, Name, and Date.
/*
 * Abstract: Program accepts a matrix representing a grid of coins and calculates the maximum
 * amount of coins that can be picked up traversing the grid without moving backward (left to right,
 * top to bottom)
 * Name: Bryan Zanoli
 * Date: 10/15/2024
 */

import java.util.Scanner;

class Main
{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Process input
        int height;
        int width;

        String[] tableSize = scanner.nextLine().split(" ");
        height = Integer.parseInt(tableSize[0]);
        width = Integer.parseInt(tableSize[1]);

        Boolean[][] coinMap = new Boolean[height][width];
        for(int i = 0; i < height; i++) {
            String[] tableRow = scanner.nextLine().split(" ");
            for (int j = 0; j < width; j++) {
                coinMap[i][j] = Integer.parseInt(tableRow[j]) == 1;
            }
        }

        //Print Table for Troubleshooting purposes
        /*
        System.out.println("Coin Map:");
        for(int i = 0; i < height; i++) {
            String output = "";
            for(int j = 0; j < width; j++) {

                if(coinMap[i][j]) {
                    output += "1 ";
                } else {
                    output += "0 ";
                }
            }
            System.out.println(output);
        }*/

        //Start on 1/1 (0/0)
        //From top or from left only
        //Recurrence relation - recursive

        //Create value map
        Integer[][] valueMap = new Integer[height][width];
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                int upperRow = i == 0 ? 0 : valueMap[i-1][j];
                int leftCol = j == 0 ? 0 : valueMap[i][j-1];
                int fMax = Math.max(upperRow, leftCol);
                valueMap[i][j] = fMax + (coinMap[i][j] ? 1 : 0);
            }
        }
        System.out.println("Max coins:" + valueMap[height-1][width-1]);

        //Print out Value Map for troubleshooting
        /*System.out.println("Value Map:");
        for(int i = 0; i < height; i++) {
            String output = "";
            for(int j = 0; j < width; j++) {
                output += valueMap[i][j] + " ";
            }
            System.out.println(output);
        }*/


        //Back tracking to determine path
        int i = height - 1;
        int j = width - 1;
        String path = "(" + height + "," + width + ")";
        while (i > 0 || j > 0) {
            /*System.out.println("Value: " + valueMap[i][j] +
                " Left Col: " + valueMap[i-1][j] +
                " Upper Row: " + valueMap[i][j-1] +
                " i: " + i +
                " j: " + j);*/
            //System.out.println("i: " + i + " j: " + j);
            int upperRow = i <= 0 ? -1 : valueMap[i-1][j];
            int leftCol = j <= 0 ? -1 : valueMap[i][j-1];
            if(upperRow > leftCol && i > 0) {
                i--;
            } else if (j > 0) {
                j--;
            }
            int pathi = i+1;
            int pathj = j+1;
            path = "(" + pathi + "," + pathj + ")->" + path;
        }
        System.out.println("Path:" + path);
    }
}

