package lab01;

// JDK 17.0.10

import Misc.Utils;

public class ElectricUsage {
    
    private static long getBill(long _usage){
        return _usage * 1000 + ((_usage > 50)? (_usage - 50) * 200 : 0);
    }
    
    public static boolean validateElectricBill(){
        String inp;
        long usage = 0;
        
        if (!(inp = Utils.getLine("Monthly electric usage: ", Utils.validations.vLong)).isEmpty()){
            usage = Long.parseLong(inp);
        }
        if (usage < 0) {
            System.out.println("Invalid input");
            return false;
        }
            
        System.out.printf("Bill: %d\n", lab01.ElectricUsage.getBill(usage));
        return true;
    }
    
    public static void main(String[] args){
       while (!validateElectricBill());
    }
}

//        Scanner scanner = new Scanner(System.in); 
//            System.out.print("Monthly electric usage: ");
//            if (scanner.hasNextInt())
//                usage = scanner.nextInt();
//            try {
//                usage = Long.parseLong(Misc.Utils.getLine("Monthly electric usage: "));
//            } catch (NumberFormatException e){
//                System.out.println("Invalid input");
//            }