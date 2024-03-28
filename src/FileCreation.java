public class FileCreation {

  public static void main(String[] args) {
    //Creates FileGenerator object
    FileGenerator fileGen = new FileGenerator();
    //All paths to direct where files get generated into
    String smallLocation = "Sort-Algorithms-Analysis/src/SmallFiles/";
    String mediumLocation = "Sort-Algorithms-Analysis/src/MediumFiles/";
    String largeLocation = "Sort-Algorithms-Analysis/src/LargeFiles/";
    String smallSortedLocation = "Sort-Algorithms-Analysis/src/SortedSmallFiles/";
    String mediumSortedLocation = "Sort-Algorithms-Analysis/src/SortedMediumFiles/";
    String largeSortedLocation = "Sort-Algorithms-Analysis/src/SortedLargeFiles/";
    String smallReverseLocation = "Sort-Algorithms-Analysis/src/ReverseSmallFiles/";
    String mediumReverseLocation = "Sort-Algorithms-Analysis/src/ReverseMediumFiles/";
    String largeReverseLocation = "Sort-Algorithms-Analysis/src/ReverseLargeFiles/";


    //Generate unsorted files
    for(int i = 1; i <= 30; i++) {
      fileGen.generate(10000, smallLocation + "smallFile" + i, 1);
      fileGen.generate(100000, mediumLocation + "mediumFile" + i,1);
      fileGen.generate(1000000, largeLocation + "largeFile" + i,1);
    }

    //Generate sorted files from previously generated unsorted files
      fileGen.generate(10000, smallSortedLocation + "smallSorted", 2);
      fileGen.generate(100000, mediumSortedLocation + "mediumSorted", 2);
      fileGen.generate(1000000, largeSortedLocation + "largeSorted", 2);

    //Generate reverse-sorted files from previously generated sorted files
    fileGen.generate(10000, smallReverseLocation + "smallReverse", 3);
    fileGen.generate(100000, mediumReverseLocation + "mediumReverse", 3);
    fileGen.generate(1000000, largeReverseLocation + "largeReverse", 3);

  }
}
