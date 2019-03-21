import java.util.Arrays;
import java.util.Random;
public class Quick{
  public static void main(String[]args){
    Random r = new Random();
    int[] ary = new int[1000];
    for (int idx = 0; idx < ary.length; idx ++) ary[idx] = r.nextInt(5);
    //System.out.println(Arrays.toString(partitionDutch(ary, 0, ary.length - 1)));
    //System.out.println(Arrays.toString(ary));
    quicksort(ary);
    System.out.println(Arrays.toString(ary));
  }

  public static void quicksortDutch(int[] data) {quicksortDutch(data, 0, data.length - 1);}

  public static void quicksortDutch(int[] data, int lo, int hi){
    if (lo >= hi) return;
    int[] pivots = partitionDutch(data, lo, hi);
    System.out.println(Arrays.toString(pivots));
    quicksortDutch(data, lo, pivots[0]);
    quicksortDutch(data, pivots[1] + 1, hi);
  }

  public static void quicksort(int[] data){
    quicksort(data, 0, data.length - 1, 150);
  }
  public static void quicksort(int[] ary, int lo, int hi, int minLength){
    if (hi - lo <= minLength){
      insertionSort(ary, lo, hi);
      return;
    }
    int pivot = partition(ary, lo, hi);
    quicksort(ary, lo, pivot - 1, minLength);
    quicksort(ary, pivot + 1, hi, minLength);
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

  private static int[] partitionDutch(int[] data, int lo, int hi){
    if (hi == lo) return new int[]{lo, lo};
    Random r = new Random();
    int[][] median = new int[][]{{0, data[lo]}, {1, data[hi]}, {2, data[hi - lo / 2]}};
    if (median[0][1] > median[1][1]) swap(median, 0, 1);
    if (median[0][1] > median[2][1]) swap(median, 0, 2);
    if (median[1][1] > median[2][1]) swap(median, 1, 2);
    int pivIndex = median[1][0];
    int pivot = data[pivIndex];
    swap(data, lo, pivIndex);
    int i = lo + 1;
    int j = hi;
    while (i != j){
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

  public static void insertionSort(int[] ary, int lo, int hi){
    if (hi - lo == 0) return;
    for (int idx = lo + 1; idx < hi + 1; idx ++){
      int val = ary[idx];
      int i = idx - 1;
      for (;i >= lo && ary[i] > val; i--){
        ary[i + 1] = ary[i];
      }
      ary[i + 1] = val;
    }
  }

  public static void swap(int[] data, int idx1, int idx2){
    int temp = data[idx1];
    data[idx1] = data[idx2];
    data[idx2] = temp;
  }

  public static void swap(int[][] data, int idx1, int idx2){
    int[] temp = data[idx1];
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
