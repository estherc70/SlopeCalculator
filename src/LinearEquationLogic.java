import java.util.Scanner;
public class LinearEquationLogic {
    private String coord1;
    private String coord2;
    private Scanner scan;
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private double x;
    private int counter;




    LinearEquationLogic() {
        scan = new Scanner(System.in);
        counter = 0;
    }




    public void start() {
        if (counter == 0) {
            welcome();
        }
        System.out.println();
        askingUserForCoordinate();
        stringToInt();
        System.out.println();
        LinearEquation linearEquation = new LinearEquation(x1,y1,x2,y2);
        linearEquation.lineInfo();
        System.out.println();
        if (x1 != x2) {
            askingforCoord();
            System.out.println();
            linearEquation.coordinateForX(x);
        }


        System.out.println();
        newCoord();
        System.out.println();
    }


    private void welcome() {
        System.out.println("Welcome to linear equation calculator!");
    }


    private void askingforCoord() {
        System.out.print("Enter a value for x: ");
        x = scan.nextDouble();
        scan.nextLine();


    }




    private void askingUserForCoordinate() {
        System.out.print("Enter coordinate 1: ");
        coord1 = scan.nextLine();
        System.out.print("Enter coordinate 2: ");
        coord2 = scan.nextLine();
    }




    private void stringToInt() {
        int idx1 = coord1.indexOf(",");
        int idx2 = coord2.indexOf(",");
        x1 = Integer.parseInt(coord1.substring(1,idx1));
        y1 = Integer.parseInt(coord1.substring(idx1 + 1, coord1.length()-1));
        x2 = Integer.parseInt(coord2.substring(1,idx2));
        y2 = Integer.parseInt(coord2.substring(idx2 + 1, coord2.length()-1));
    }






    private void newCoord() {
        System.out.print("Would you like to enter another pair of coordinate? y/n: ");
        String newCoord = scan.nextLine();
        counter += 1;
        if (newCoord.equals("y")) {
            start();
        }
        else {
            System.out.println("Thank you for using linear equation calculator!");
        }


    }
















}

