
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class FileToArray {

  /**
   *
   * @param name the name of the file to be converted into an array
   * @return the values that were in the given file in an Integer array
   */
    public Integer[] FileArray(String name) {

          List<Integer> numberList = new ArrayList<>();

          //Scans the file while using whitespace as the delimiter
          try (Scanner scanner = new Scanner(new File(name))) {
            scanner.useDelimiter("\\s+"); // Use whitespace as the delimiter

            //Adds the numbers scanned from the file into numberList until there are no numbers left
            while (scanner.hasNextInt()) {
              numberList.add(scanner.nextInt());
            }
          } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
          }

          // Convert ArrayList to array
      return numberList.toArray(new Integer[0]);
    }
}


