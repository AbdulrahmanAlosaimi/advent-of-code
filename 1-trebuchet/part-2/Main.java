import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
  public static void main(String[] args) {
    try {
      BufferedReader br = new BufferedReader(new FileReader("../input.txt"));

      String[] numbers = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
      int sum = 0;

      for (String line; (line = br.readLine()) != null;) {
        System.out.println(line);
        boolean foundLeft = false, foundRight = false;
        int leftDigit = 0, rightDigit = 0;
        for (int i = 0, j = line.length() - 1; i < line.length(); i++, j--) {

          if (foundLeft && foundRight) {
            System.out.println("Found both digits\nDIGITS: " + leftDigit + "\t" + rightDigit);
            System.out.println(leftDigit + rightDigit);
            System.out.println();
            sum += (leftDigit + rightDigit);
            // TODO: Logic for both digits found
            break;
          }
          if (!foundLeft && Character.isDigit(line.charAt(i))) {
            System.out.println("Digit at char: " + i + ", Digit: " + line.charAt(i) + "\n");
            foundLeft = true;
            leftDigit = Integer.parseInt("" + line.charAt(i)) * 10;
            // TODO: Logic for sum
          }
          if (!foundRight && Character.isDigit(line.charAt(j))) {
            System.out.println("Last Digit at char " + j + ", Digit: " + line.charAt(j) + "\n");
            foundRight = true;
            rightDigit = Integer.parseInt("" + line.charAt(j));
          }
          for (int k = 0; k < numbers.length; k++) {
            if (!foundLeft && (i + numbers[k].length() < line.length())) {
              if (line.substring(i, numbers[k].length() + i).equalsIgnoreCase(numbers[k]) && !foundLeft) {
                System.out.println("Found: " + numbers[k] + "\n");
                foundLeft = true;
                leftDigit = (k + 1) * 10;
                // TODO: Logic for sum
              }
            }
            if (0 <= j - numbers[k].length()) {
              // System.err.println(line.substring(j - numbers[k].length(), j + 1));
              if (!foundRight && line.substring(j - (numbers[k].length() - 1), j + 1)
                  .equalsIgnoreCase(numbers[k])) {
                System.out.println("Last found: " + numbers[k] + "\n");
                foundRight = true;
                rightDigit = k + 1;
              }
            }

            // TODO: Logic for finding last digit (right)
          }
        }
      }
      System.out.println("SUM = " + sum);
      br.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
