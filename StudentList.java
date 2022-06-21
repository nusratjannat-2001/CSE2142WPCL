import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {
		//check argiments
		if(args[0].length()<=1)
		{
			System.out.println(constant.WrongInput);
		}

        if (args[0].equals(constant.ShowAll)) {
            System.out.println(constant.LoadingMessage);
            try {
                String[] split = getStrings();
                for (String j : split) {
                    System.out.println(j);
                }
            }
            catch (Exception e) {
            }
            System.out.println(constant.LoadedData);
        }
        else if (args[0].equals(constant.ShowRandom)) {
            System.out.println(constant.LoadingMessage);
            try {
                String[] split = getStrings();
                Random random = new Random();
                int nextInt = random.nextInt();
                System.out.println(split[nextInt]);
            }
            catch (Exception e) {
            }
            System.out.println(constant.LoadedData);
        }
        else if (args[0].contains(constant.AddEntry)) {
            System.out.println(constant.LoadingMessage);
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

            System.out.println(constant.LoadedData);
        }
        else if (args[0].contains(constant.FindEntry)) {
            System.out.println(constant.LoadingMessage);
            try {
                String[] split = getStrings();
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
            System.out.println(constant.LoadedData);
        }
        else if (args[0].contains(constant.ShowCount)) {
            System.out.println(constant.LoadingMessage);
            try {
              String[] Names=getStrings();
              boolean in_word=true;
              int count=0;
              for(String word:Names){
                  count++;
              }
                System.out.println(count + " word(s) found ");
            }
            catch (Exception e) {
            }
            System.out.println(constant.LoadedData);
        }
		else{
			System.out.println(constant.WrongInput);
		}
		
    }

    private static String[] getStrings() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("students.txt")));
        String line = bufferedReader.readLine();
        return line.split(constant.StudentEntryDelimiter);
	}
}
