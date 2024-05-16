package lab01;

// JDK 17.0.10

import Misc.Utils;


public class Lab01 {
    
    public static void main(String[] args) {
        int choice;
        String inp;

        do{
            
            while ((inp = Misc.Utils.getLine("*".repeat(8) + " Menu " + "*".repeat(8) + "\n"
                                + "1. Solve quadratic\n"
                                + "2. Calculate monthly electric bill\n"
                                + "3. Exit\n"
                                + "Enter choice: ", Utils.validations.vInt)).isBlank() || (choice = Integer.parseInt(inp)) < 1);

            
            switch(choice){
            case 1:
                Quadratic.validateQuadratic();
                break;
            case 2:
                ElectricUsage.validateElectricBill();
                break;
            case 3:
                break;
            default:
                System.out.println("INVALID INPUT");
            }
        } while (choice != 3); 
    }
    
}
