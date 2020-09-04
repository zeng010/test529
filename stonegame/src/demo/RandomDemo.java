package demo;

import java.util.Random;

/**
 * @author: Zzz_tjhd
 * @date: 2020-09-03 22:28
 */
public class RandomDemo {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        for (int i = 0; i < 10; i++) {
            Random r = new Random();
            int index = r.nextInt(arr.length);
            int num = arr[i];
            arr[i] = arr[index];
            arr[index] = num;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println(10/2);
    }
}
