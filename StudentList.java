import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {

//		Check arguments
        if (args[0].equals("a")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("students.txt")));
                String line = bufferedReader.readLine();
                String split[] = line.split(",");
                for (String j : split) {
                    System.out.println(j);
                }
            }
            catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        }
        else if (args[0].equals("r")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("students.txt")));
                String r = bufferedReader.readLine();
                System.out.println(r);
                String split[] = r.split(",");
                Random random = new Random();
                int nextInt = random.nextInt();
                System.out.println(split[nextInt]);
            }
            catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        }
        else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(
                        new FileWriter("students.txt", true));
                String substring = args[0].substring(1);
                Date date = new Date();
                String fullDate = "dd/mm/yyyy-hh:mm:ss a";
                DateFormat dateFormat = new SimpleDateFormat(fullDate);
                String format = dateFormat.format(date);
                bufferedWriter.write(", " + substring + "\nList last updated on " + format);
                bufferedWriter.close();
            }
            catch (Exception e) {
            }

            System.out.println("Data Loaded.");
        }
        else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("students.txt")));
                String line = bufferedReader.readLine();
                String split[] = line.split(",");
                boolean done = false;
                String substring = args[0].substring(1);
                for (int idx = 0; idx < split.length && !done; idx++) {
                    if (split[idx].equals(substring)) {
                        System.out.println("We found it!");
                        done = true;
                    }
                }
            }
            catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        }
        else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader s = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("students.txt")));
                String D = s.readLine();
                char charArray[] = D.toCharArray();
                boolean inputWord = false;
                int count = 0;
                for (char c : charArray) {
                    if (c == ' ') {
                        if (!inputWord) {
                            count++;
                            inputWord = true;
                        }
                        else {
                            inputWord = false;
                        }
                    }
                }
                System.out.println(count + " word(s) found " + charArray.length);
            }
            catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        }
    }
}
