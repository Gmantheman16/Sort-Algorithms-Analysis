
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class FileToArray {

    public Integer[] FileArray(String name) {

          List<Integer> numberList = new ArrayList<>();

          try (Scanner scanner = new Scanner(new File(name))) {
            scanner.useDelimiter("\\s+"); // Use whitespace as the delimiter

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


