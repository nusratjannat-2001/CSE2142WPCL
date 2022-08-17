public  class Constant {
    public static String StudentList = "students.txt";
    public static final String Exit = "-e";
    public static final String ShowAll = "-a";
    public static final String ShowRandom = "-r";
    public static final String AddStudentName = "+";
    public static final String StudentCount = "-c";
    public static final String StudentSearch = "?";
    public static String WarningMessage = "Wrong Input....";
    public static String LoadingMessage = "Loading data ...\n";
    public static String LoadingSuccessMessage = "\nData Loaded...";
    public static String SearchSuccessMessage = " is present in the list...!!!";
    public static String SearchFailedMessage = "The student is not in list...!!!";
    public static String GUIDE =

            "java Main \t choose from the option \t then press enter...\n"
            + "1. Students list                  " + Constant.ShowAll        +  "\n"
            + "2. Choose a random student        " + Constant.ShowRandom     +  "\n"
            + "3. See total number of students   " + Constant.StudentCount   +  "\n"
            + "4. Add a student name             " + Constant.AddStudentName +  " StudentName" +  "\n"
            + "5. Find a student                 " + Constant.StudentSearch  +  "\n"
            + "6. Exit                           " + Constant.Exit           +  "\n";

    public  static String DateFormatString = "dd/mm/yyyy-hh:mm:ss a";
    public  static String SubmitDateString = "List last updated on ";


}
