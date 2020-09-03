/**
 * @author: Zzz_tjhd
 * @date: 2020-09-03 22:52
 */
public class RandomDemo1 {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        int[][] datas = new int[4][4];
        for (int i = 0; i < arr.length; i++) {
            datas[i/4][i%4] = arr[i];
        }

        for (int i = 0; i < datas.length; i++) {
            for (int j = 0; j < datas[i].length; j++) {
                System.out.println(datas[i][j]);
            }
            System.out.println("---------------");
        }
    }
}
