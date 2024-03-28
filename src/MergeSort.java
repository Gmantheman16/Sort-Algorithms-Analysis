public class MergeSort {

  /**
   *
   * @param integers the array to be mergeSorted
   * @param left the position of the element furthest on the left
   * @param right the position of the element furthest on the right
   */
  public void mergeSort(Integer[] integers, int left, int right) {
    if(left < right) {

      int middle = (left + right) / 2;

      mergeSort(integers, left, middle);
      mergeSort(integers, middle + 1, right);

      merge(integers, left, middle, right);
    }
  }

  /**
   *
   * @param array the array to be merged
   * @param left the position of the element of array furthest to the left
   * @param middle the position of the middle element of array
   * @param right the position of the element of array furthest to the right
   */
  private void merge(Integer[] array, int left, int middle, int right) {
    //len1 = the length of the left subarray
    int len1 = middle - left + 1;
    //len2 = the length of the right subarray
    int len2 = right - middle;
    int i = 0, j = 0, k = left;

    Integer[] leftArray = new Integer[len1];
    Integer[] rightArray = new Integer[len2];

    //Copies left subarray of array into leftArray
    System.arraycopy(array, left, leftArray, 0, len1);
    //Copies right subarray of array into rightArray
    System.arraycopy(array, middle + 1, rightArray, 0, len2);

    //Merge leftArray and rightArray
    while(i < len1 && j < len2) {
      if(leftArray[i] <= rightArray[j]) {
        array[k] = leftArray[i];
        i++;
      } else {
        array[k] = rightArray[j];
        j++;
      }
      k++;
    }
    //If any elements are left in leftArray, copy into merged array
    while(i < len1) {
      array[k] = leftArray[i];
      i++;
      k++;
    }
    //If any elements are left in rightArray, copy into merged array
    while(j < len2) {
      array[k] = rightArray[j];
      j++;
      k++;
    }
  }

  //Used for testing
  static void printArray(Integer[] array) {
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
    FileToArray fileReader = new FileToArray();

    Integer[] array = fileReader.FileArray(mediumLocation + "mediumFile" + 1);

    System.out.println("Given Array");
    printArray(array);

    MergeSort ob = new MergeSort();
    ob.mergeSort(array, 0, array.length - 1);

    System.out.println("\nSorted array");
    printArray(array);
  }
 **/
}
