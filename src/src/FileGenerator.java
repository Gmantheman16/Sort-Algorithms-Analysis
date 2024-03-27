import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class FileGenerator {

  public void generate(int numbers, String name, int type) {
    if(type == 1) {
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
    if(type == 2) {
      //Sorted files
    }
    if(type == 3) {
      //Reverse-Sorted files
    }

    }
}
