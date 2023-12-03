import java.io.FileReader;
import java.io.BufferedReader;

public class Main {
  public static void main(String[] args) {
    try {
      BufferedReader br = new BufferedReader(new FileReader("../input.txt"));
      int sum = 0;

      // Go through the file, one line at a time
      for (String line; (line = br.readLine()) != null;) {

        // MAX and MIN values used to make sure we selected first and last digit
        int leftIndex = Integer.MAX_VALUE, rightIndex = Integer.MIN_VALUE;

        char[] chars = line.toCharArray();
        for (int i = 0, j = line.length() - 1; i != line.length() && j != -1; i++, j--) {

          if (Character.isDigit(chars[i])) {
            leftIndex = leftIndex == Integer.MAX_VALUE ? i : Math.min(i, leftIndex);
          }

          if (Character.isDigit(chars[j])) {
            rightIndex = rightIndex == Integer.MIN_VALUE ? j : Math.max(j, rightIndex);
          }

          // If both indexes have moved, no need to check rest of string
          if (rightIndex != Integer.MIN_VALUE && leftIndex != Integer.MAX_VALUE) {
            break;
          }
        }

        System.out.println(chars);
        System.out.println("" + chars[leftIndex] + chars[rightIndex] + "\n");
        sum += Integer.parseInt("" + chars[leftIndex] + chars[rightIndex]);
      }
      System.out.println("SUM = " + sum);
      br.close();

    } catch (Exception e) {
      // TODO: handle Exception
      e.printStackTrace();
    }

  }
}
