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

        Boolean[][] map = new Boolean[height][width];
        for(int i = 0; i < height; i++) {
            String[] tableRow = scanner.nextLine().split(" ");
            for (int j = 0; j < width; j++) {
                map[i][j] = Integer.parseInt(tableRow[j]) == 1;
            }
        }

        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if(map[i][j]) {
                    System.out.println("1 ");
                } else {
                    System.out.println("0 ");
                }
            }
        }
    }
}

