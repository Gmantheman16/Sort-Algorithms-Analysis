import java.util.Arrays;

public class QuickSort {
  public void quickSort(Integer[] integers, int left, int right) {
    if(left >= right) {
      return;
    }
    int pivot = pivotSelection(integers, left, right);
    int[] partition = fatPartition(integers,left,right,pivot);

    quickSort(integers, left, partition[0] - 1);
    quickSort(integers, partition[1] + 1, right);

  }
  private int pivotSelection(Integer[] integers, int left, int right) {
    if(right - left > 101) {
      int[] values = {integers[left], integers[(left + right) / 2], integers[right-1]};
      Arrays.sort(values);
      return values[1];
    } else {
      return integers[left];
    }
  }

  private int[] fatPartition(Integer[] array, int left, int right, int pivot) {
    int i = left, less = left, greater = right;

    while(i <= greater) {
      if(array[i].compareTo(pivot) < 0) {
        swap(array, less++, i++);
      } else if(array[i].compareTo(pivot) > 0) {
        swap(array, i, greater--);
      } else {
        i++;
      }
    }
    return new int[] {less, greater};
  }

  private void swap(Integer[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  public static void printArray(Integer[] array) {
    for(int i : array) {
      System.out.print(i + " ");
    }
    System.out.println();
  }
/**
  public static void main(String[] args) {
    String smallLocation = "src/src/SmallFiles/";
    String mediumLocation = "src/src/MediumFiles/";
    String largeLocation = "src/src/LargeFiles/";
    QuickSort qs = new QuickSort();
    FileToArray fileReader = new FileToArray();
    Integer[] array = fileReader.FileArray(mediumLocation + "mediumFile" + 1);
    System.out.println("Original array:");
    printArray(array);

    qs.quickSort(array, 0, array.length - 1, 1);

    System.out.println("Sorted array:");
    printArray(array);
    System.out.println("Sorted array length: " + array.length);
  }
 **/
}
