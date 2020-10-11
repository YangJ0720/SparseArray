import java.util.Arrays;

/**
 * 稀疏数组
 */
public class Main {

    public static void main(String[] args) {
        // 行
        int row = 10;
        // 列
        int column = 10;
        // 原始数组
        int[][] array = new int[row][column];
        // 向原始数组添加任意元素
        array[0][9] = 1;
        array[7][1] = 2;
        array[8][6] = 1;
        array[9][9] = 2;
        // 打印输出原始数组
        System.out.println("--------------------- 原始数组 ---------------------");
        print(array, row, column);
        // 将原始数组转换为稀疏数组
        int[][] sparseArray = convertToSparseArray(array, row, column);
        // 打印输出稀疏数组
        System.out.println("--------------------- 稀疏数组 ---------------------");
        print(sparseArray, sparseArray.length, 3);
        // 将稀疏数组转换为原始数组
        convertToInitialArray(sparseArray);
    }

    /**
     * 将原始数组转换为稀疏数组
     *
     * @param array
     * @param row
     * @param column
     * @return
     */
    private static int[][] convertToSparseArray(int[][] array, int row, int column) {
        // 原始数组中有效元素的个数
        int valid = 0;
        // 遍历原始数组，计算有效元素的个数
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int number = array[i][j];
                if (number == 0) {
                    continue;
                }
                valid++;
            }
        }
        // 根据原始数组中有效元素个数，定义稀疏数组大小
        int[][] sparseArray = new int[valid + 1][3];
        // 稀疏数组第一行用来记录原始数组的大小和有效元素个数
        sparseArray[0][0] = row;
        sparseArray[0][1] = column;
        sparseArray[0][2] = valid;
        // 遍历原始数组，将有效元素添加到稀疏数组
        int count = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int number = array[i][j];
                if (number == 0) {
                    continue;
                }
                sparseArray[count][0] = i;
                sparseArray[count][1] = j;
                sparseArray[count][2] = number;
                count++;
            }
        }
        return sparseArray;
    }

    /**
     * 将稀疏数组转换为原始数组
     * @param sparseArray
     * @return
     */
    private static int[][] convertToInitialArray(int[][] sparseArray) {
        int r = sparseArray[0][0];
        int c = sparseArray[0][1];
        int[][] initialArray = new int[r][c];
        for (int i = 1; i < sparseArray.length; i++) {
            int row = sparseArray[i][0];
            int column = sparseArray[i][1];
            int number = sparseArray[i][2];
            initialArray[row][column] = number;
        }
        System.out.println("--------------------- 原始数组 ---------------------");
        print(initialArray, r, c);
        return initialArray;
    }

    /**
     * 打印输出
     *
     * @param array
     * @param row
     * @param column
     */
    private static void print(int[][] array, int row, int column) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
