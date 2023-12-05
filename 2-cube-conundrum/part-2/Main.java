import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
  public static void main(String[] args) {
    try {
      BufferedReader br = new BufferedReader(new FileReader("../input.txt"));

      int sum = 0;

      for (String line; (line = br.readLine()) != null;) {

        int redCubes = -1, greenCubes = -1, blueCubes = -1;

        int gameNum = Integer.parseInt(line.split(":")[0].split(" ")[1]);
        String[] gameRounds = line.split(":")[1].split(";");

        for (int i = 0; i < gameRounds.length; i++) {

          String[] selection = gameRounds[i].split(",");

          for (int j = 0; j < selection.length; j++) {

            if (selection[j].trim().split(" ")[1].equalsIgnoreCase("red")) {
              redCubes = Math.max(redCubes, Integer.parseInt(selection[j].trim().split(" ")[0]));
            }

            if (selection[j].trim().split(" ")[1].equalsIgnoreCase("green")) {
              greenCubes = Math.max(greenCubes, Integer.parseInt(selection[j].trim().split(" ")[0]));
            }

            if (selection[j].trim().split(" ")[1].equalsIgnoreCase("blue")) {
              blueCubes = Math.max(blueCubes, Integer.parseInt(selection[j].trim().split(" ")[0]));
            }
          }

        }

        System.out.println("Game: " + gameNum + "\nRGB: " + redCubes + "\t" + greenCubes + "\t" + blueCubes
            + "\nMultiplied: " + (redCubes * greenCubes * blueCubes));
        System.out.println("SUM BEFORE: " + sum);
        sum += (redCubes * greenCubes * blueCubes);
        System.out.println("SUM AFTER: " + sum + "\n");

      }

      System.out.println("SUM = " + sum);

      br.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
