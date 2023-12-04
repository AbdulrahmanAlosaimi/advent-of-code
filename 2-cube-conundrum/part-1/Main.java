import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
  public static void main(String[] args) {
    try {
      BufferedReader br = new BufferedReader(new FileReader("../input.txt"));

      int sum = 0;
      int redMax = 12, greenMax = 13, blueMax = 14;

      for (String line; (line = br.readLine()) != null;) {

        int gameNum = Integer.parseInt(line.split(":")[0].split(" ")[1]);
        String[] gameRounds = line.split(":")[1].split(";");

        boolean valid = true;
        for (int i = 0; valid && i < gameRounds.length; i++) {

          String[] selection = gameRounds[i].split(",");

          for (int j = 0; valid && j < selection.length; j++) {

            System.out.println(selection[j].trim().split(" ")[1]);
            System.out.println(Integer.parseInt(selection[j].trim().split(" ")[0]));

            if (selection[j].trim().split(" ")[1].equalsIgnoreCase("red")
                && Integer.parseInt(selection[j].trim().split(" ")[0]) > redMax) {
              System.out.println("OVER RED: " + selection[j].trim().split(" ")[0] + " MAX: " + redMax + "\nGAMENUM: "
                  + gameNum + "\n\n");
              sum += gameNum;
              valid = false;
              break;
            }

            if (selection[j].trim().split(" ")[1].equalsIgnoreCase("green")
                && Integer.parseInt(selection[j].trim().split(" ")[0]) > greenMax) {
              System.out.println("OVER GREEN: " + selection[j].trim().split(" ")[0] + " MAX: " + greenMax
                  + "\nGAMENUM: " + gameNum + "\n\n");
              sum += gameNum;
              valid = false;
              break;
            }

            if (selection[j].trim().split(" ")[1].equalsIgnoreCase("blue")
                && Integer.parseInt(selection[j].trim().split(" ")[0]) > blueMax) {
              System.out.println("OVER BLUE: " + selection[j].trim().split(" ")[0] + " MAX: " + blueMax + "\nGAMENUM: "
                  + gameNum + "\n\n");
              sum += gameNum;
              valid = false;
              break;
            }
          }
          System.out.println();
        }
        System.out.println("\n");
      }
      System.out.println("SUM = " + sum);
      br.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
