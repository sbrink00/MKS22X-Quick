import java.util.Arrays;
import java.util.Random;
public class Quick{
  public static void main(String[]args){
    int[] ary = new int[]{999,999,999,4,1,0,3,2,999,999,999};
    //System.out.println(quickselect(ary, 2));
    //partition(ary, 0, ary.length - 1);
    //quicksort(ary, 0, ary.length - 1);
    //System.out.println(Arrays.toString(ary));
    int[] qs = new int[100];
    Random r = new Random(5);
    for (int idx = 0; idx < qs.length; idx ++) qs[idx] = r.nextInt(10000);
    int[] as = qs;
    System.out.println(quickselect(qs , 40));
    //quicksort(qs, 0, qs.length - 1);
    //Arrays.sort(as);
    //System.out.println(Arrays.equals(qs, as));
    /*int[] data = { 2, 10, 15, 23, 0,  5};
    System.out.println(quickselect(data , 0));//  would return 0
    System.out.println(quickselect(data , 1 ));//  would return 2
    System.out.println(quickselect(data, 2 ));//  would return 5
    System.out.println(quickselect(data, 3));//  would return 10
    System.out.println(quickselect(data, 4 ));//  would return 15
    System.out.println(quickselect(data, 5 ));//  would return 23*/
  }

  public static void quicksort(int[] data){
    quicksort(data, 0, data.length - 1);
  }

  public static void quicksort(int[] ary, int lo, int hi){
    if (lo >= hi) return;
    int pivot = partition(ary, lo, hi);
    quicksort(ary, lo, pivot - 1);
    quicksort(ary, pivot + 1, hi);
  }

  public static int quickselect(int[] data, int k){
    int start = 0;
    int end = data.length - 1;
    int pivIndex = data.length + 1;
    while (pivIndex != k){
      System.out.println(end - start);
      pivIndex = partition(data, start, end);
      if (pivIndex > k) end = pivIndex - 1;
      else if (pivIndex < k) start = pivIndex + 1;
    }
    return data[pivIndex];
  }

  /*public static int quickselect(int[] data, int k){
    int pivIndex = partition(data, 0, data.length - 1);
    while (pivIndex != k){
      if (pivIndex > k) pivIndex = partition(data, 0, pivIndex);
      if (pivIndex < k) pivIndex = partition(data, pivIndex, data.length - 1);;
    }
    return data[pivIndex];
  }*/

  public static int partition(int[] data, int start, int end){
    if (data.length == 1) return 0;
    Random r = new Random();
    int pivIndex = r.nextInt(end - start + 1) + start;
    int pivot = data[pivIndex];
    swap(data, start, pivIndex);
    int i = start + 1;
    int j = end;
    int idx = 1;
    while (i < j){
      if (data[i] < pivot) i ++;
      else if (data[i] > pivot){
        swap(data, i, j);
        j --;
      }
      else if (data[i] == pivot){
        if (r.nextInt(2) == 0){
          swap(data, i, j);
          j--;
        }
        else i ++;
      }
      idx ++;
    }
    if (i == data.length) return i - 1;
    else if (data[i] < pivot){
      swap(data, start, i);
      return i;
    }
    else{
      swap(data, start, i - 1);
      return i - 1;
    }
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
