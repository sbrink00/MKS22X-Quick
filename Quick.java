import java.util.Random;
public class Quick{
  public static void main(String[]args){
    int[] ary = new int[]{999,999,999,4,1,0,3,2,999,999,999};
    partition(ary, 0, ary.length - 1);
    System.out.println(intString(ary));
  }

  public static int quickselect(int []data, int k){
    Random r = new Random();
    int pivIndex = r.nextInt();
    int i = 0;
    int j = k.length() - 1;
    while (pivIndex != k){
      partition(data, i, k);

    }
  }

  public static int partition(int[] data, int start, int end){
    Random r = new Random();
    int pivIndex = r.nextInt(end - start) + start;
    int pivot = data[pivIndex];
    System.out.println(pivot);
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
