
// JDK 17.0.10

package Misc;

public class Utils {
    public enum validations {
        vInt,
        vLong,
        vFloat,
        vDouble
    }
    
    public static String getLine(String message, validations val){
        System.out.print(message);
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        switch(val){
            case vInt:
                if (scanner.hasNextInt()){
                    return scanner.nextLine().trim();
                } else return "";
            case vLong:
                if (scanner.hasNextLong()){
                    return scanner.nextLine().trim();
                } else return "";
            case vFloat:
                if (scanner.hasNextFloat()){
                    return scanner.nextLine().trim();
                } else return "";
            case vDouble:
                if (scanner.hasNextDouble()){
                    return scanner.nextLine().trim();
                } else return "";
            default:
                return scanner.nextLine();
        }
    }
    
    public static String getLine(String message){
        System.out.print(message);
        return (new java.util.Scanner(System.in)).nextLine();
    }
}
