package codingPattern.KWayMerge.Helper;

import java.util.*;

public class Traversal {
    static void forwardTraversal(int[] arr){
        for (int j : arr) {
            System.out.print(j + "");
        }
    }
    static void backwardTraversal(int[] arr){
        for(int i = arr.length-1; i >= 0; i--){
            System.out.print(arr[i]+ "");
        }
    }
}
