import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Driver {

  public static void main(String[] args) {
    FileToArray fileReader = new FileToArray();
    int milliConversion = 1000000;
    String smallLocation = "src/src/SmallFiles/";
    String mediumLocation = "src/src/MediumFiles/";
    String largeLocation = "src/src/LargeFiles/";
    String sortedSmallLocation = "src/src/SortedSmallFiles/";
    double[] quickSortTime = new double[30];
    double[] mergeSortTime = new double[30];
    double[] heapSortTime = new double[30];
    QuickSort qsort = new QuickSort();
    MergeSort msort = new MergeSort();

    //Unsorted small files
    for(int i = 1; i <= 30; i++) {
      Integer[] integers = fileReader.FileArray(smallLocation + "smallFile" + i);

      //QuickSort
      double startTime = System.currentTimeMillis();
      //Start QuickSort with integers array:
      qsort.quickSort(integers, 0, integers.length-1);
      double endTime = System.currentTimeMillis();
      //Store time for quicksort in the correct array position
      quickSortTime[i-1] = (endTime - startTime);

      //MergeSort
      startTime = System.currentTimeMillis();
      //Start MergeSort with integers array
      msort.mergeSort(integers, 0, integers.length-1);
      endTime = System.currentTimeMillis();
      //Store time for mergesort in the correct array position
      mergeSortTime[i-1] = (endTime - startTime);

      //HeapSort
      startTime = System.currentTimeMillis();
      //Start HeapSort with integers array
      endTime = System.currentTimeMillis();
      //Store time for heapsort in the correct array position
      heapSortTime[i-1] = (endTime - startTime);
    }
    //Transfer times to results file
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("Results.txt"))) {
        writer.write("Times for small file size:\n");
        writer.write("   QuickSort: ");
        for(int i = 0; i < 30; i++) {
          writer.write(quickSortTime[i] + " ");
        }
        writer.write("\n   MergeSort: ");
        for(int i = 0; i < 30; i++) {
          writer.write(mergeSortTime[i] + " ");
        }
        writer.write("\n   HeapSort: ");
        for (int i = 0; i < 30; i++) {
          writer.write(heapSortTime[i] + " ");
        }
    } catch (IOException e) {
      System.out.println("An error occurred while writing to the file: " + e.getMessage());
    }

  }
}
