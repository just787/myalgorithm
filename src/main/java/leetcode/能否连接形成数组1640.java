package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: TODO
 * @author: leo
 * @createDate: 2020/11/4 20:50
 * @version: 1.0
 */
public class 能否连接形成数组1640 {
    public static void main(String[] args) {
        // int[] a = new int[]{2, 1, 4, 6};
        // int[][] b = new int[][]{{1, 4}, {6}, {2}};

        int[] a = new int[]{49, 18, 16};
        int[][] b = new int[][]{{49, 18, 16, 10}};


        System.out.println(canFormArray1(a, b));
        System.out.println(canFormArray2(a, b));
    }

    public static boolean canFormArray(int[] arr, int[][] pieces) {
        // 方便获取arr元素的下标
        HashMap<Integer, Integer> arrIndex = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            arrIndex.put(arr[i], i);
        }
        // 遍历pieces
        for (int[] piece : pieces) {
            // 找到piece中第一个数在arr中的下标
            int start = arrIndex.get(piece[0]);
            for (int i = 0; i < piece.length; i++) {
                // 当piece中的元素和arr不一致，也不成立
                if (arr[start + i] != piece[i]) {
                    return false;
                }
            }
        }
        return true;
    }


    public static boolean canFormArray1(int[] arr, int[][] pieces) {

        // pieces中匹配到一维数据数量
        int pieceMatchCount = 0;
        // pieces中平台一维数组后的元素个数
        int allPieceCount = 0;
        // 遍历pieces
        for (int[] piece : pieces) {
            allPieceCount = piece.length + allPieceCount;

            for (int i = 0; i < arr.length; i++) {
                // 找到piece匹配的首位，然后顺延匹配
                if (arr[i] == piece[0]) {
                    // 找到piece长度为1则代表全匹配
                    if (piece.length == 1) {
                        pieceMatchCount++;
                    } else {
                        for (int j = 1; j < piece.length; j++) {
                            if (i + j < arr.length && arr[i + j] == piece[j]) {
                                // 找到piece遍历完才代表全匹配
                                if (j + 1 == piece.length) {
                                    pieceMatchCount++;
                                }
                            }
                        }
                    }
                }
            }
        }

        return allPieceCount == arr.length && pieces.length == pieceMatchCount;
    }


    public static boolean canFormArray2(int[] arr, int[][] pieces) {
        // 构造 HashMap O(1) 取值
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] piece : pieces) {
            map.put(piece[0], piece);
        }
        // 对单个 piece 数组，遍历对比
        for (int i = 0; i < arr.length; ) {
            int curVal = arr[i];
            if (map.containsKey(curVal)) {
                int[] piece = map.get(curVal);
                for (int value : piece) {
                    if (i < arr.length && arr[i] == value) {
                        i++;
                    } else {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
        return true;
    }


}
