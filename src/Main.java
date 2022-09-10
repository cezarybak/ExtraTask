import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("./src/mockData.txt"))) {
            int counter = 0;

            File file = new File("./src/outputData.txt");
            BufferedWriter output = new BufferedWriter(new FileWriter(file));

            while (scanner.hasNextLine()) {
                String text;
                text = scanner.nextLine().trim();
                counter++;

                String[] nums = text.split("\\D+");
                
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i].equals("")) {
                        continue;
                    } else if (Integer.parseInt(nums[i]) >= 10) {
                        output.write(text);
                        output.newLine();
                        System.out.println(String.format("Row: %s, Value: %s", counter, text));
                        break;
                    }
                }

            }
            scanner.close();
            output.close();
        } catch (IOException e) {
            System.out.println("Something has gone wrong!");
            e.printStackTrace();
        }
    }
}