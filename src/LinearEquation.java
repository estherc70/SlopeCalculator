public class LinearEquation {
    private int x1;
    private int x2;
    private int y1;
    private int y2;




    LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }




    public double distance() {
        return roundToHundredth(Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2)));
    }




    public double yIntercept() {
        return roundToHundredth(y1 - (slope() * x1));
    }
    public String slopeAsFraction() {
        int top = (y2-y1);
        int bottom = (x2-x1);
        if (bottom < 0) {
            Math.abs(bottom);
        }
        return top + "/" + bottom;
    }




    public double slope() {
        return roundToHundredth((double) (y2 - y1) /(x2-x1));
    }




    public String equation() {
        if (y2-y1 == 0) {
            return "y = " + (int) yIntercept();
        }
        else if (slope() == -1 && yIntercept() == 0 ) {
            return "y = -x";
        }
        else if (slope() == 1 && yIntercept() == 0 ) {
            return "y = x";
        }
        else if (slope() == -1 && yIntercept() < 0 ) {
            return "y = -x + " + Math.abs(yIntercept());
        }
        else if (slope() == 1 && yIntercept() < 0 ) {
            return "y = x + " + Math.abs(yIntercept());
        }
        else if (slope() == 1) {
            return "y = x + " + yIntercept();
        }
        else if (slope() == -1) {
            return "y = -x + " + yIntercept();
        }
        else if ((y2-y1)%( x2-x1) == 0 && yIntercept() == 0 ) {
            return "y = " + (y2-y1) / (x2-x1) + "x";
        }
        else if ((y2-y1)%( x2-x1) == 0 && yIntercept() > 0 ) {
            return "y = " + (y2-y1) / (x2-x1) + "x + " + yIntercept();
        }
        else if ((y2-y1)%( x2-x1) == 0 && yIntercept() < 0) {
            return "y = " + (y2 - y1) / (x2 - x1) + "x - " + Math.abs(yIntercept());
        }
        else if ((y2-y1) < 0 && (x2-x1) < 0 && yIntercept() < 0) {
            return "y = " + Math.abs(y2-y1) + "/" + Math.abs(x2-x1) + "x - " + Math.abs(yIntercept());
        }
        else if ((y2-y1) < 0 && (x2-x1) < 0 && yIntercept() > 0) {
            return "y = " + Math.abs(y2-y1) + "/" + Math.abs(x2-x1) + "x + " + yIntercept();
        }
        else if ((y2-y1) > 0 && (x2-x1) < 0) {
            return "y = -" +  Math.abs(y2-y1) + "/" + Math.abs(x2-x1) + "x + " + yIntercept();
        }
        else if (yIntercept() < 0) {
            return "y = " + slopeAsFraction() + "x - " + Math.abs(yIntercept());
        }
        else if (yIntercept() == 0) {
            return "y = " + slopeAsFraction() + "x";
        }
        else {
            return "y = " + slopeAsFraction() + "x + " + yIntercept();
        }


    }




    public String coordinateForX(double x) {
        double newYValue = (slope() * x + yIntercept());
        return "The point on the line is " + "(" + x + ", " + newYValue + ")";
    }


    public String lineInfo() {
        String info = "";
        if (x1 == x2) {
            System.out.println("These points are on a vertical line: " + x1);
        }
        else {
            info = "The two points are: (" + x1 + ", " + y1 + ")" + " and " + "(" + x2 + ", " + y2 + ")";
            info += "\nThe equation of the line between these points is: " + equation();
            info += "\nThe slope of the line is: " + slope();
            info += "\nThe y-intercept of the line is: " + yIntercept();
            info += "\nThe distance between these points is " + distance();
        }
        return info;


    }


    private double roundToHundredth(double num) {
        return Math.round(num * 100) /100.0;
    }






}
