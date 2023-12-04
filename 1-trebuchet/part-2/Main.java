import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
  public static void main(String[] args) {
    try {

      BufferedReader br = new BufferedReader(new FileReader("../input.txt"));

      String[] numbers = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

      int sum = 0;

      // used for debugging
      int lineCount = 1;

      for (String line; (line = br.readLine()) != null;) {
        // used for debugging
        System.out.println(line);

        // to know when to sum
        boolean foundLeft = false, foundRight = false;
        int leftDigit = 0, rightDigit = 0;

        for (int i = 0, j = line.length() - 1; i < line.length(); i++, j--) {

          // found digit for left digit
          if (!foundLeft && Character.isDigit(line.charAt(i))) {
            System.out.println("Digit at char: " + i + ", Digit: " + line.charAt(i) + "\n");
            foundLeft = true;

            // value of left digit (multiplied by 10)
            leftDigit = Integer.parseInt("" + line.charAt(i)) * 10;
            if (foundLeft && foundRight) {
              continue;
            }
          }

          if (!foundRight && Character.isDigit(line.charAt(j))) {
            System.out.println("Last Digit at char " + j + ", Digit: " + line.charAt(j) + "\n");
            foundRight = true;

            // value of right digit
            rightDigit = Integer.parseInt("" + line.charAt(j));
            if (foundLeft && foundRight) {
              continue;
            }
          }
          for (int k = 0; k < numbers.length; k++) {

            // checking whether the line is big enough for the number string
            if (!foundLeft && (i + numbers[k].length() < line.length())) {

              if (line.substring(i, numbers[k].length() + i).equalsIgnoreCase(numbers[k]) && !foundLeft) {

                // used for debugging
                System.out.println("Found: " + numbers[k] + "\n");
                foundLeft = true;

                // left digit value is k + 1
                // k is index of number string, for ex: "one" index is 0)
                leftDigit = (k + 1) * 10;
                if (foundLeft && foundRight) {
                  break;
                }
              }
            }
            // ensuring we don't go below index 0
            if (0 <= j - numbers[k].length()) {
              if (!foundRight && line.substring(j - (numbers[k].length() - 1), j + 1)
                  .equalsIgnoreCase(numbers[k])) {

                // used for debugging
                System.out.println("Last found: " + numbers[k] + "\n");

                foundRight = true;
                rightDigit = k + 1;
                if (foundLeft && foundRight) {
                  break;
                }
              }
            }
          }
        }
        if (foundLeft && foundRight) {
          System.out.println("Found both digits\nDIGITS: " + leftDigit + "\t" + rightDigit);
          System.out.println(leftDigit + rightDigit);
          System.out.println("Sum before: " + sum);
          sum += (leftDigit + rightDigit);
          System.out.println("Sum after: " + sum + "\nJust finished line number: " + lineCount + "\n");
        }
        // used for debugging
        lineCount++;
      }
      System.out.println("SUM = " + sum);
      br.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
