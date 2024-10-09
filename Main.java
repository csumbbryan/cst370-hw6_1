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
                System.out.println("i: " + i + " j: " + j);
                int leftCol = i == 0 ? 0 : valueMap[i-1][j];
                int upperRow = j == 0 ? 0 : valueMap[i][j-1];
                valueMap[i][j] = leftCol + upperRow + (coinMap[i][j] ? 1 : 0);
            }
        }

        System.out.println("Value Map:");
        for(int i = 0; i < height; i++) {
            String output = "";
            for(int j = 0; j < width; j++) {
                output += valueMap[i][j];
            }
            System.out.println(output);
        }
    }
}

