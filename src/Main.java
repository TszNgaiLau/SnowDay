import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> num = new ArrayList<>();
        try {
            File myFile = new File("src\\nums.txt");
            Scanner fileScanner = new Scanner(myFile);
            while (fileScanner.hasNext()) {
                String data = fileScanner.nextLine();
                String[] splitData = data.split(",");
                int sum = 0;
                for (String splitDatum : splitData) {
                    sum += Integer.parseInt(splitDatum);
                }
                num.add(sum);
            }
        } catch(IOException exception) {
            System.out.println(exception.getMessage());
        }
        for (int i = 0; i < num.size(); i++) {
            int min = num.get(i);
            int minIdx = i;
            for (int j = i; j < num.size(); j++) {
                if (min > num.get(j)) {
                    minIdx = j;
                    min = num.get(j);
                }
            }
            // three lines of code to swap
            int temp = num.get(i);
            num.set(i, num.get(minIdx));
            num.set(minIdx, temp);
        }
        System.out.println(num);
    }
}
