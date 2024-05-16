
import Misc.Utils;


// JDK 17.0.10

public class StudentList {
    private static String[] studentNames;
    private static double[] studentGrades;

    @SuppressWarnings("empty-statement")
    private static int initStudents(){
        int arrSize = 0;
        String inp;
        
//        do {
//            if (!(inp = Utils.getLine("Enter number of students: ", Utils.validations.vInt)).isEmpty())
//                arrSize = Integer.parseInt(inp);
//        } while (arrSize <= 0);
        
        while ((inp = Utils.getLine("Enter number of students: ", Utils.validations.vInt)).isEmpty() || (arrSize = Integer.parseInt(inp)) <= 0);
                
        studentNames = new String[arrSize];
        studentGrades = new double[arrSize];

        // Fill studentGrades with random values
        for (int i = 0; i < arrSize; i++){
            studentGrades[i] = ((int)(Math.random() * 37)) * 0.25 + 1; // Math.random() returns [0, 1) (0 inclusive, 1 exclusive)
            // By mulitplying [0, 1) by 37 -> [0, 37) and truncating the decimal part, we get [0, 36], multiply this by 0.25: [0, 9], offset by 1: [1, 10]
            while ((studentNames[i] = Utils.getLine("Enter name for student #" + (i + 1) + "\n", Utils.validations.vDefault)).isBlank());
        }

        return arrSize;
    }

    private static void sortStudents(int size){
        // Selectionsort
        for (int i = 0; i < size-1; i++){
            int maxInd = i;
            for (int j = i + 1; j < size; j++)
                if (studentGrades[j] > studentGrades[maxInd])
                    maxInd = j;

            // Swapping both grade and name
            double tGrade = studentGrades[maxInd];
            studentGrades[maxInd] = studentGrades[i];
            studentGrades[i] = tGrade;

            String tName = studentNames[maxInd];
            studentNames[maxInd] = studentNames[i];
            studentNames[i] = tName;
        }

        System.out.println("After sorting:\n" + "-".repeat(50));

        // Post sort printing
        printStudents(size);
    }

    private static void printStudents(int size){
        for (int i = 0; i < size; i++){
            System.out.println("Name: " + studentNames[i]);
            System.out.println("Score: " + studentGrades[i]);
            System.out.print("Academic ability: ");
            if (studentGrades[i] >= 7.5)
                System.out.println("Excellent");
            else if (studentGrades[i] >= 6.5)
                System.out.println("Good");
            else if (studentGrades[i] >= 5)
                System.out.println("Average");
            else 
                System.out.println("Weak");
            System.out.println();
        }

    }

    private static double getAverage(int size){
        double sumGrade = 0;
        for (final double grade : studentGrades){
            sumGrade += grade;
        }

        return sumGrade / size;
    }

    private static String normalizeName(String name){ // name is a copy of a reference to a String object in memory
        // Quite confusing because name initially points to an element in studentNames, after the line below it points to a modified copy instead
        name = name.trim(); // Remove leading and trailing whitespaces
        name = name.replaceAll("[-+.,/;:\"'_=!@#$%^&*()\\[\\]]", "");
        name = name.replaceAll("\\s+", " "); // Remove redundant spaces
        String[] words = name.split("[\\s]"); // Split by space

        // System.out.println(name);

        for (int i = 0; i < words.length; i++){
            // Capitalizing the words individually
            // left-inclusive, right-exclusive
            if (!words[i].isBlank())
                words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
        }

        return String.join(" ", words);
    }

    public static void main(String[] args){
        int arrSize = initStudents();
        
        // Applying normalization to all names
        for (int i = 0; i < arrSize; i++){
            studentNames[i] = normalizeName(studentNames[i]); // Replace references
        }

        System.out.println();
        printStudents(arrSize);

        sortStudents(arrSize);
        
        // Student with highest score 
        System.out.println("-".repeat(50) + "\nStudent with highest score:");
        printStudents(1); // SHOULD ONLY BE CALLED AFTER SORTING

        System.out.println("-".repeat(50) + "\nGrade average: " + getAverage(arrSize));

    }
}
