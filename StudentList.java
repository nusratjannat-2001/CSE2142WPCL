import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


class StudentList {
    BufferedReader bufferReader;

    {
        try {
            bufferReader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(Constant.StudentList)
                    )
            );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String[] getStudentNames() throws IOException {

        return bufferReader.readLine().split(", ");
    }

    public void showStudentsName() {

        try {
            String[] studentNames = getStudentNames();
            for (String studentName : studentNames) {
                System.out.println(studentName);
            }
        } catch (Exception e) {

        }
    }

    public void showARandomStudent() {
        try {
            String[] studentNames = getStudentNames();

            // generating random int [0,length)
            Random random = new Random();
            int randomNumber = random.nextInt(studentNames.length);

            System.out.println(studentNames[randomNumber]);
        } catch (Exception e) {
        }
    }

    public void addAStudentNameInStudentList(String args[]) {

        try {
            Formatter formatter = new Formatter(new FileWriter(Constant.StudentList, true));

            String studentName = "";
            for (String arg: args) {
                if(arg != args[0]){
                    studentName = studentName + " " + arg;
                }
            }
            studentName = studentName.trim();

            formatter.format(", " + studentName);
            formatter.close();
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat(Constant.DateFormatString);
            String fullDate = dateFormat.format(date);
            System.out.println(Constant.SubmitDateString + fullDate);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void wordCount() {
        int count = 0;
        try {
            String[] studentNames = getStudentNames();

            for(String name : studentNames){
               String studentName[] =  name.split(" ");
               count  = count + studentName.length;
            }

            System.out.println(" word(s) found: " + count);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void question(String args[]) {

        try {
            String[] studentNames = getStudentNames();
            int length = studentNames.length;
            String student = args[1];
            System.out.println();

            for (int idx = 0; idx < length; idx++) {
                if (studentNames[idx].equals(student)) {
                    System.out.println(student + Constant.SearchSuccessMessage);
                    return;
                }
            }
            System.out.println(Constant.SearchFailedMessage);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

public class Main {


    public static void main(String[] args) {
        StudentList studentList = new StudentList();


        System.out.println(Constant.LoadingMessage);

        if(args.length >= 1) {


            //		Check arguments
            switch (args[0]) {
                case Constant.ShowAll:
                    studentList.showStudentsName();
                    break;
                case Constant.ShowRandom:
                    studentList.showARandomStudent();
                    break;
                case Constant.AddStudentName:
                    studentList.addAStudentNameInStudentList(args);
                    break;
                case Constant.StudentSearch:
                    studentList.question(args);
                    break;
                case Constant.StudentCount:
                    studentList.wordCount();
                    break;
                default:
                    System.out.println(Constant.WarningMessage);
                    System.out.println(Constant.GUIDE);
            }
        }else{
//            System.out.println(Constant.WarningMessage);
//            System.out.println(Constant.GUIDE);
        }

        System.out.println(Constant.LoadingSuccessMessage);

    }

}
