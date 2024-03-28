import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class FileGenerator {

  public void generate(int numbers, String name, int type) {
    if (type == 1) {
      //Unsorted files
      // Create a Random object for generating random numbers
      Random random = new Random();

      try (BufferedWriter writer = new BufferedWriter(new FileWriter(name))) {
        // Generate and write random numbers to the file
        for (int i = 0; i < numbers; i++) {
          int randomNumber = random.nextInt(10000); // Generates a number between 0 and 9999
          writer.write(randomNumber + " ");
        }
      } catch (IOException e) {
        System.out.println("An error occurred while writing to the file: " + e.getMessage());
      }
    }
    if (type == 2) {
      String smallLocation = "src/src/SmallFiles/";
      String mediumLocation = "src/src/MediumFiles/";
      String largeLocation = "src/src/LargeFiles/";
      FileToArray fileReader = new FileToArray();
      String tempName;

      //Sorted files
      for (int i = 1; i <= 30; i++) {
        tempName = name + i;
        //Small Files
        if (numbers == 10000) {
          Integer[] unsortedSmall = fileReader.FileArray(smallLocation + "smallFile" + i);
          Arrays.sort(unsortedSmall);

          try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempName))) {

            for (int k = 0; k < unsortedSmall.length; k++) {
              writer.write(unsortedSmall[k] + " ");
            }
          } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
          }
          //Medium Files
        } else if (numbers == 100000) {
          Integer[] unsortedMedium = fileReader.FileArray(mediumLocation + "mediumFile" + i);
          Arrays.sort(unsortedMedium);

          try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempName))) {

            for (int k = 0; k < unsortedMedium.length; k++) {
              writer.write(unsortedMedium[k] + " ");
            }
          } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
          }
          //Large Files
        } else if (numbers == 1000000) {
          Integer[] unsortedLarge = fileReader.FileArray(largeLocation + "largeFile" + i);
          Arrays.sort(unsortedLarge);

          try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempName))) {

            for (int k = 0; k < unsortedLarge.length; k++) {
              writer.write(unsortedLarge[k] + " ");
            }
          } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
          }
        }
      }
    }
    if (type == 3) {
      //Reverse-Sorted files
      String tempName;
      String sortedSmallLocation = "src/src/SortedSmallFiles/";
      String sortedMediumLocation = "src/src/SortedMediumFiles/";
      String sortedLargeLocation = "src/src/SortedLargeFiles/";
      FileToArray fileReader = new FileToArray();

      for (int i = 1; i <= 30; i++) {
        tempName = name + i;
        //Small Files
        if (numbers == 10000) {
          Integer[] sortedSmall = fileReader.FileArray(sortedSmallLocation + "smallSorted" + i);
          Collections.reverse(Arrays.asList(sortedSmall));

          try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempName))) {

            for (int k = 0; k < sortedSmall.length; k++) {
              writer.write(sortedSmall[k] + " ");
            }
          } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
          }
        }
          //Medium Files
          if (numbers == 100000) {
            Integer[] sortedMedium = fileReader.FileArray(sortedMediumLocation + "mediumSorted" + i);
            Collections.reverse(Arrays.asList(sortedMedium));

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempName))) {

              for (int k = 0; k < sortedMedium.length; k++) {
                writer.write(sortedMedium[k] + " ");
              }
            } catch (IOException e) {
              System.out.println("An error occurred while writing to the file: " + e.getMessage());
            }
        }
        if (numbers == 1000000) {
          Integer[] sortedLarge = fileReader.FileArray(sortedLargeLocation + "largeSorted" + i);
          Collections.reverse(Arrays.asList(sortedLarge));

          try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempName))) {

            for (int k = 0; k < sortedLarge.length; k++) {
              writer.write(sortedLarge[k] + " ");
            }
          } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
          }
        }

      }
    }
  }
}