import java.math.BigInteger;
import java.util.Scanner;

/**
 *  大数值 中奖概率计算
 * @ClassName: BigIntegerTest
 * @author:zhouzhu
 * @Date: 2018/10/12 16:13
 * @Version: V1.0
 */
public class BigIntegerTest {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);

        System.out.print("How many number do you need to draw?");

        int k=in.nextInt();

        System.out.print("What is the highest number you can draw?");

        int n=in.nextInt();

        BigInteger lotterOdds=BigInteger.valueOf(1);

        for (int i=1;i<=k;i++){
            lotterOdds=lotterOdds.multiply(BigInteger.valueOf(n-i+1)).divide(BigInteger.valueOf(i));
        }
        System.out.println("You odds are 1 in "+lotterOdds+".Good luck!");
    }
}
