/**
 * @ClassName: Test2
 * @author:zhouzhu
 * @Date: 2018/10/16 10:53
 * @Version: V1.0
 */
public class Test2 {
    public static void main(String[] args){
        for (int i=1;i<=9;i++){
            for (int j=1;j<=i;j++){
                System.out.print(i+"*"+j+"="+(i*j)+"\t");
            }
            System.out.println();
        }

        int[] arr={55,2,5,3,7,99,11,111,66};
        int nim=arr[0];
        for (int i=0;i<arr.length;i++){
            if (nim>arr[i]){
                nim=arr[i];
            }
        }
        System.out.println(nim);
    }
}
