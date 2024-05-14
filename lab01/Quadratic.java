package lab01;

// JDK 17.0.10

import Misc.Utils;

public class Quadratic {
    
    private static void solveQuad(double a, double b, double c){
        double delt = (b * b) - (4 * a * c);

        if (delt < 0){
            System.out.println("Complex solution");
        } else if (delt == 0) {
            System.out.printf("Single solution : %g\n", (-b) / (2 * a));
        } else {
            System.out.printf("Solution #1: %g\nSolution #2: %g\n", (-b - Math.sqrt(delt)) / (2 * a), (-b + Math.sqrt(delt)) / (2 * a));
        }
    }
    
    public static boolean validateQuadratic(){
        double a = .0d, b = Double.NaN, c = Double.NaN;
        String inp;
        
        if (!(inp = Utils.getLine("a = ", Utils.validations.vDouble)).isEmpty())
            a = Double.parseDouble(inp);
        
        if (!(inp = Utils.getLine("b = ", Utils.validations.vDouble)).isEmpty())
            b = Double.parseDouble(inp);
        
        if (!(inp = Utils.getLine("c = ", Utils.validations.vDouble)).isEmpty())
            c = Double.parseDouble(inp);
        
        
//        System.out.print("a = ");
//        if (scanner.hasNextDouble())
//            a = scanner.nextDouble();
//            
//        System.out.print("b = ");
//        if (scanner.hasNextDouble())
//            b = scanner.nextDouble();
//
//        System.out.print("c = ");
//        if (scanner.hasNextDouble())
//            c = scanner.nextDouble();

        if (a == .0 || Double.isNaN(a) || Double.isNaN(b) || Double.isNaN(c)) {
            System.out.println("\nInvalid coefficients");
            return false;
        }
        
        lab01.Quadratic.solveQuad(a, b, c);
        return true;
    }
    
    public static void main(String[] args){
        while (!validateQuadratic());
    }
}
