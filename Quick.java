import java.util.Random;
public class Quick{
  public static void main(String[]args){
    int[] ary = new int[]{999,999,999,4,1,0,3,2,999,999,999};
    //System.out.println(quickselect(ary, 2));
    //partition(ary, 0, ary.length - 1);
    quicksort(ary, 0, ary.length - 1);
    System.out.println(intString(ary));
    /*int[] data = { 2, 10, 15, 23, 0,  5};
    System.out.println(quickselect( ary , 0 ));//  would return 0
    System.out.println(quickselect( ary , 1 ));//  would return 2
    System.out.println(quickselect( ary , 2 ));//  would return 5
    System.out.println(quickselect( ary , 3 ));//  would return 10
    System.out.println(quickselect( ary , 4 ));//  would return 15
    System.out.println(quickselect( ary , 5 ));//  would return 23*/
  }

  public static void quicksort(int[] ary, int lo, int hi){
    //dont use zero as a parameter, use lo and high
    if (lo >= hi) return;
    int pivot = partition(ary, lo, hi);
    quicksort(ary, lo, pivot - 1);
    quicksort(ary, pivot + 1, hi);
  }

  public static int quickselect(int []data, int k){
    Random r = new Random();
    int i = 0;
    int j = data.length - 1;
    int pivIndex = r.nextInt(j - i) + i;
    while (pivIndex != k){
      pivIndex = partition(data, i, j);
      if (pivIndex == k) return data[pivIndex];
      if (pivIndex > k) j = pivIndex - 1;
      if (pivIndex < k) i = pivIndex + 1;
    }
    return data[pivIndex];
  }

  public static int partition(int[] data, int start, int end){
    if (data.length == 1) return 0;
    Random r = new Random();
    int pivIndex = r.nextInt(end - start) + start;
    int pivot = data[pivIndex];
    swap(data, start, pivIndex);
    int i = start + 1;
    int j = end;
    while (i != j){
      if (data[i] < pivot) i ++;
      else if (data[i] >= pivot){
        swap(data, i, j);
        j --;
      }
    }
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
