import java.util.Arrays;
import java.util.Random;
public class Quick{
  public static void main(String[]args){
    /*int[] ary = new int[]{999,999,999,4,1,0,3,2,999,999,999};
    int[] qs = new int[100000000];
    Random r = new Random(5);
    for (int idx = 0; idx < qs.length; idx ++) qs[idx] = r.nextInt(100000000);
    System.out.println(quickselect(qs, 50000000));*/
    int[] dutch = new int[]{0, 1, 2, 4, 3, 2, 1, 3, 4, 3, 2, 1, 2, 3 ,2, 2, 1, 4, 3};
    System.out.println(Arrays.toString(partitionDutch(dutch, 0, dutch.length - 1)));
    System.out.println(Arrays.toString(dutch));

  }

  public static void quicksortDutch(int[] data, int lo, int hi){
    if (lo >= hi) return;
    int[] pivots = partitionDutch(data, lo, hi);
    
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

  private static int[] partitionDutch(int[] data, int lo, int hi){
    if (data.length == 1) return new int[2];
    Random r = new Random();
    int pivIndex = r.nextInt(hi - lo + 1) + lo;
    int pivot = data[pivIndex];
    swap(data, lo, pivIndex);
    int i = lo + 1;
    int j = hi;
    System.out.println(pivot);
    System.out.println(data[lo]);
    while (i != j){
      System.out.println(i + " " + j);
      if (data[i] <= pivot) i ++;
      else {
        swap(data, i, j);
        j --;
      }
    }
    int piv;
    if (data[i] < pivot){
      swap(data, lo, i);
      j = i - 1;
      piv = i;
    }
    else{
      swap(data, lo, i - 1);
      j = i - 2;
      piv = i - 1;
    }
    i = 0;
    while (i != j){
      if (data[i] == pivot){
        swap(data, i, j);
        j --;
      }
      else i++;
    }
    return new int[]{i, piv};
  }

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
    if (data[i] < pivot){
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
