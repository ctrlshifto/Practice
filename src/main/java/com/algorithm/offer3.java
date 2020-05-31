package com.algorithm;


/**
 * @author WhomHim
 * @description
 * @date Create in 2020-5-30 23:42:15
 */
public class offer3 {
    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 8, 9},
                {2, 4, 9, 12}
        };
        Find(9, array);
    }

    private static boolean Find(int target, int[][] array) {
        if (array == null) {
            return false;
        }
        int row = 0;
        int colum = array[0].length - 1;
        while (row < array.length && colum >= 0) {
            if (array[row][colum] == target) {
                return true;
            }
            if (array[row][colum] > target) {
                colum--;
            } else {
                row++;
            }
        }
        return false;
    }


}
