public class Driver {

  public static void main(String[] args) {
    FileToArray fileReader = new FileToArray();
    String smallLocation = "src/src/SmallFiles/";
    String mediumLocation = "src/src/MediumFiles/";
    String largeLocation = "src/src/LargeFiles/";
    double quickSortTime = 0;
    double mergeSortTime = 0;
    double heapSortTime = 0;

    //Unsorted small files
    for(int i = 1; i <= 30; i++) {
      Integer[] integers = fileReader.FileArray(smallLocation + "smallFile" + i);
      double startTime = System.nanoTime();
      //Start QuickSort with integers array
      double endTime = System.nanoTime();
      quickSortTime += (endTime - startTime);
      startTime = System.nanoTime();
      //Start MergeSort with integers array
      endTime = System.nanoTime();
      mergeSortTime += (endTime - startTime);
      startTime = System.nanoTime();
      //Start HeapSort with integers array
      endTime = System.nanoTime();
      heapSortTime += (endTime - startTime);
    }
    //Calculates average time for each algorithm over 30 small unsorted files
    quickSortTime = quickSortTime/30;
    mergeSortTime = mergeSortTime/30;
    heapSortTime = heapSortTime/30;

  }
}
