public class MergeSort {

  public void mergeSort(Integer[] integers, int left, int right) {
    if(left < right) {

      int middle = (left + right) / 2;

      mergeSort(integers, left, middle);
      mergeSort(integers, middle + 1, right);

      merge(integers, left, middle, right);
    }
  }

  private void merge(Integer[] array, int left, int middle, int right) {
    int len1 = middle - left + 1;
    int len2 = right - middle;
    int i = 0, j = 0, k = left;

    Integer[] leftArray = new Integer[len1];
    Integer[] rightArray = new Integer[len2];

    System.arraycopy(array, left, leftArray, 0, len1);
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
