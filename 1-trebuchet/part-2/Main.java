import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
  public static void main(String[] args) {
    try {
      BufferedReader br = new BufferedReader(new FileReader("../input.txt"));

      String[] numbers = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
      for (String line; (line = br.readLine()) != null;) {
        System.out.println(line);
        boolean foundLeft = false, foundRight = false;
        for (int i = 0, j = line.length() - 1; i < line.length(); i++, j--) {

          // TODO: Logic for finding last digit (right)

          if (foundLeft && foundRight) {
            // TODO: Logic for both digits found
          }
          if (Character.isDigit(line.charAt(i)) && !foundLeft) {
            System.out.println("Digit at char: " + i + ", Digit: " + line.charAt(i) + "\n");
            foundLeft = true;
            // TODO: Logic for sum
            break;
          }
          if (!foundLeft) {
            for (int k = 0; k < numbers.length; k++) {
              if (i + numbers[k].length() < line.length() && !foundLeft) {
                if (line.substring(i, numbers[k].length() + i).equalsIgnoreCase(numbers[k]) && !foundLeft) {
                  System.out.println("Found: " + numbers[k] + "\n");
                  foundLeft = true;
                  // TODO: Logic for sum
                  break;
                }
              }
            }
          }
        }
      }
      br.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
