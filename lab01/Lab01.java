package lab01;

// JDK 17.0.10

public class Lab01 {
    
    public static void main(String[] args) {
        java.util.Scanner scanner;

        outer:
        while (true){
            do{
                scanner = new java.util.Scanner(System.in);
                System.out.print("*".repeat(8) + " Menu " + "*".repeat(8) + "\n"
                                + "1. Solve quadratic\n"
                                + "2. Calculate monthly electric bill\n"
                                + "3. Exit\n"
                                + "Enter choice: "); 
            } while (!scanner.hasNextInt());

            int choice = scanner.nextInt();

            // System.out.println(choice);

            // JDK 12+
//            switch(choice){
//            case 1 -> validateQuadratic();
//            case 2 -> validateElectricBill();
//            case 3 -> {
//                System.out.println("Exiting");
//                break outer;
//                }
//            default -> System.out.println("INVALID INPUT");
//            } 
            
            switch(choice){
            case 1:
                Quadratic.validateQuadratic();
                break;
            case 2:
                ElectricUsage.validateElectricBill();
                break;
            case 3:
                System.out.println("Exiting");
                break outer;
            default:
                System.out.println("INVALID INPUT");
            }
        }   

        scanner.close();
    }
    
}
