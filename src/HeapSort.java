public class HeapSort {

  /**
   *
   * @param integers the array to be heapSorted
   */
  public void heapSort(Integer[] integers) {
    int n = integers.length;

    //Build Heap
    for(int i = n/2 + 1; i >= 0; i--) {
      heapify(integers, n, i);
    }

    //Element extraction
    for(int i = n - 1; i >= 0; i--) {
      int temp = integers[0];
      integers[0] = integers[i];
      integers[i] = temp;

      heapify(integers, i, 0);
    }
  }

  /**
   *
   * @param array the array to be heapified
   * @param n the length of array
   * @param i the root of the heap
   */
  private void heapify(Integer[] array, int n, int i) {
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    //If left child is larger than root
    if(left < n && array[left] > array[largest]) {
      largest = left;
    }
    //If right child is larger than current largest
    if(right < n && array[right] > array[largest]) {
      largest = right;
    }
    //If largest isn't the root
    if(largest != i) {
      int swap = array[i];
      array[i] = array[largest];
      array[largest] = swap;

      heapify(array, n, largest);
    }
  }

  //Used for testing
  private static void printArray(Integer[] array) {
    int n = array.length;
    for(int i = 0; i < n; ++i) {
      System.out.print(array[i] + " ");
    }
    System.out.println();
  }
  /**
  public static void main(String args[]) {
    String smallLocation = "src/src/SmallFiles/";
    String mediumLocation = "src/src/MediumFiles/";
    String largeLocation = "src/src/LargeFiles/";
    FileToArray fileReader = new FileToArray();

    Integer[] array = fileReader.FileArray(mediumLocation + "mediumFile" + 1);
    int n = array.length;

    HeapSort ob = new HeapSort();
    ob.heapSort(array);

    System.out.println("Sorted array is");
    printArray(array);
  }
   **/
}
