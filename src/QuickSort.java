import java.util.Arrays;

public class QuickSort {
  /**
   *
   * @param integers the array to be quickSorted
   * @param left the position of the leftmost element of the unsorted portion
   * @param right the position of the rightmost element of the unsorted portion
   */
  public void quickSort(int[] integers, int left, int right) {
    if(left >= right) {
      return;
    }
    //Finds the pivot
    int pivot = pivotSelection(integers, left, right);
    //Finds the partitions
    int[] partition = fatPartition(integers,left,right,pivot);

    //Recursively calls quicksort for the left subarray
    quickSort(integers, left, partition[0] - 1);
    //Recursively calls quicksort for the right subarray
    quickSort(integers, partition[1] + 1, right);

  }

  /**
   *
   * @param integers the array to have its pivot found
   * @param left the leftmost element's position of integers
   * @param right the rightmost element's position of integers
   * @return the median of the leftmost, rightmost, and middle value of integers
   */
  private int pivotSelection(int[] integers, int left, int right) {
    if(right - left > 101) {
      if(left >= right) {
        return left;
      }
      int[] values = {integers[left], integers[(left + right) / 2], integers[right]};
      Arrays.sort(values);
      return values[1];
    } else {
      return integers[left];
    }
  }

  /**
   *
   * @param array the array to have its partitions calculated
   * @param left  the position of the leftmost element in array
   * @param right the position of the rightmost element in array
   * @param pivot the pivot of array
   * @return array with left and right partition
   */
  private int[] fatPartition(int[] array, int left, int right, int pivot) {


    int i = left;
    int less = left;
    int greater = right;

    while(i <= greater) {
      //If array[i] is less than the pivot
      if(array[i] < pivot) {
        int temp = array[less];
        array[less++] = array[i];
        array[i++] = temp;

        //If array[i] is greater than the pivot
      } else if(array[i] > pivot) {
        int temp = array[i];
        array[i] = array[greater];
        array[greater--] = temp;

        //If array[i] is equal to the pivot
      } else {
        i++;
      }
    }
    return new int[] {less, greater};
  }

  //Used for testing
  public static void printArray(int[] array) {
    for(int i : array) {
      System.out.print(i + " ");
    }
    System.out.println();
  }
/**
  public static void main(String[] args) {
    String smallLocation = "src/SmallFiles/";
    String mediumLocation = "src/MediumFiles/";
    String largeLocation = "src/LargeFiles/";
    QuickSort qs = new QuickSort();
    FileToArray fileReader = new FileToArray();
    int[] array = fileReader.FileArray(mediumLocation + "mediumFile" + 1);
    System.out.println("Original array:");
    printArray(array);

    qs.quickSort(array, 0, array.length - 1);

    System.out.println("Sorted array:");
    printArray(array);
    System.out.println("Sorted array length: " + array.length);
  }
**/
}
