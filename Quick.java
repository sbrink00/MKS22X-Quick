import java.util.Random;
public class Quick{
  public static void main(String[]args){

  }

  public static int partition(int[] data, int start, int end){
    Random r = new Random();
    int pivIndex = r.nextInt(start - end) + start;
    swap(data, 0, pivIndex);
    for (int idx = start; idx < end; idx ++){
      if (data[idx] > pivot)  
    }
  }

  public static void swap(int[] data, int idx1, int idx2){
    int temp = data[idx1];
    data[idx1] = data[idx2];
    data[idx2] = temp;
  }

}
