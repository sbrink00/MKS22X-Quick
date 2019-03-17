import java.util.Arrays;
import java.util.Random;
public class dutchDriver{
  public static void main(String[] args){
    System.out.println("ratio of dutch quicksort to normal quicksort");
    System.out.println("The array has 1 million elements because my normal");
    System.out.println("quicksort can't handle much more than that. The elements range from 0 to 9");
    System.out.println();
    for (int idx = 0; idx < 5; idx ++){
      int[] dutch = new int[1000000];
      Random r = new Random();
      for (int idx2 = 0; idx2 < dutch.length; idx2 ++) dutch[idx2] = r.nextInt(10);
      int[] normal = dutch;
      long t1 = System.currentTimeMillis();
      Quick.quicksortDutch(dutch);
      long t2 = System.currentTimeMillis();
      long dutchTime = t2 - t1;
      long t3 = System.currentTimeMillis();
      Quick.quicksort(normal);
      long t4 = System.currentTimeMillis();
      long normalTime = t4 - t3;
      //System.out.println(Arrays.equals(normal, dutch));
      System.out.println("Trial " + idx + ": " + 1.0 * dutchTime/normalTime);
    }
  }
}
