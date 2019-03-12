import java.util.Random;
public class Quick{
  public static void main(String[]args){
    int[] ary = new int[]{999,999,999,4,1,0,3,2,999,999,999};
    partition(ary, 0, ary.length);
    System.out.println(intString(ary));
  }

  public static int partition(int[] data, int start, int end){
    Random r = new Random();
    int pivIndex = r.nextInt(end - start) + start;
    System.out.println(pivIndex + ": " + data[pivIndex]);
    swap(data, start, pivIndex);
    for (int idx = start + 1; idx < end; idx ++){
      if (data[idx] > data[pivIndex]) swap(data, idx, end - idx);
    }
    return -1;
  }

  public static void swap(int[] data, int idx1, int idx2){
    int temp = data[idx1];
    data[idx1] = data[idx2];
    data[idx2] = temp;
  }

  public static String intString(int[] ary){
    String output = "[";
    for (int idx = 0; idx < ary.length; idx ++){
      output += ary[idx] + ", ";
    }
    return output.substring(0, output.length() - 2) + "]";
  }

}
