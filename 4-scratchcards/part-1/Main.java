import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Scanner;

import java.io.FileReader;

public class Main {

  public static void main(String[] args) {
    try {

      BufferedReader br = new BufferedReader(new FileReader("../input.txt"));

      int sum = 0;

      for (String line; (line = br.readLine()) != null;) {
        int winSum = 0;

        // Scannig one int at a time
        Scanner deckScanner = new Scanner(line.substring(41).trim());

        // Scanning winning deck to insert in array in ascending order for easier search
        Scanner winningCardsScanner = new Scanner(line.substring(0, 40).trim().split(": ")[1].trim());
        int[] winningCards = new int[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
        winningCards = sortArray(winningCardsScanner, winningCards);

        while (deckScanner.hasNextInt()) {
          if (searchArray(deckScanner.nextInt(), winningCards)) {
            winSum = winSum == 0 ? 1 : winSum * 2;
          }
        }
        sum += winSum;
      }
      System.out.println("SUM = " + sum);
      br.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static int[] sortArray(Scanner input, int[] array) {
    while (array[9] == -1) {
      int current = input.nextInt();
      for (int i = 0; i < array.length; i++) {
        if (array[i] == -1) {
          array[i] = current;
          break;
        } else if (current < array[i]) {
          for (int j = array.length - 1; j > i; j--) {
            array[j] = array[j - 1];
          }
          array[i] = current;
          break;
        }
      }
    }
    System.out.println("DONE SORTING INPUT: \tFirst: " + array[0] + ", Last: " + array[9] + "\n");
    return array;

  }

  public static boolean searchArray(int num, int[] sortedAr) {
    if (sortedAr.length == 1) {
      System.out.println(num);
      return sortedAr[0] == num ? true : false;
    }
    if (sortedAr[(int) (sortedAr.length / 2)] == num) {
      return true;
    }
    if (sortedAr[(int) (sortedAr.length / 2)] > num) {
      return searchArray(num, Arrays.copyOfRange(sortedAr, 0, (int) (sortedAr.length / 2)));
    }
    if (sortedAr[(int) (sortedAr.length / 2)] < num) {
      return searchArray(num, Arrays.copyOfRange(sortedAr, (int) (sortedAr.length / 2), sortedAr.length));
    }
    return false;
  }
}
