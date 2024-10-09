/*
 * INSTRUCTION:
 *     This is a Java staring code for hw6_1.
 *     When you finish the development, download this file and and submit to Canvas
 *     according to the submission instructions.

 *     Please DO NOT change the name of the main class "Main"
 */

// Finish the head comment with Abstract, Name, and Date.
/*
 * Abstract: Describe the main ideas of the program.
 * Name: Write your name
 * Date: MM/DD/YYYY
 */

import java.sql.SQLOutput;
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
        }

        //Start on 1/1 (0/0)
        //From top or from left only
        //Recurrence relation - recursive

        //Create value map
        Integer[][] valueMap = new Integer[height][width];
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                int leftCol = i == 0 ? 0 : valueMap[i-1][j];
                int upperRow = j == 0 ? 0 : valueMap[i][j-1];
                int fMax = Math.max(leftCol, upperRow);
                valueMap[i][j] = fMax + (coinMap[i][j] ? 1 : 0);
            }
        }

        //Print out Value Map for troubleshooting
        System.out.println("Value Map:");
        for(int i = 0; i < height; i++) {
            String output = "";
            for(int j = 0; j < width; j++) {
                output += valueMap[i][j];
            }
            System.out.println(output);
        }

        //Back tracking to determine path
        int i = height - 1;
        String path = "(" + height + "," + width + ")";
        while (i > 0) {
            int j = width - 1;
            while (j > 0) {
                if(valueMap[i-1][j] >= valueMap[i][j-1]) {
                    i--; //what happens if J decrements all the way??
                    path = "(" + i + "," + j + ")->" + path;
                } else {
                    j--;
                    path = "(" + i + "," + j + ")->" + path;
                }
            }
        }
        System.out.println("Path: " + path);
    }
}

