package sample;

/**
 * Created by lytte on 6/29/2016.
 * not default :P
 */

public class CircleandT {
    static double radius = 40;

    public static double randomizeRadians() {
        double rando = (360 * Math.random());
        return Math.toRadians(rando);
    }

    public static double[][] getPoints() {
        double dummy[][];
        dummy = new double[3][2];
        boolean noEscape;
        do {
            for (int i = 0; i <= 2; i++) {
                //cycles through to assign x and y values
                double rando = randomizeRadians(); //calls randomizeRadians and changes the value of radians
                dummy[i][0] = radius * (Math.cos(rando)); //x value
                dummy[i][1] = radius * (Math.sin(rando)); //y value
            }
            noEscape = pointsCheck(dummy); //calls a method to determine if
                                            // all/a point is redundant
        }while(noEscape);
        //implement
        return dummy;

    }

    public static boolean pointsCheck(double check[][]) {
        int cycle = 0; //used in while loop
        int cycleP = 1; //used in while loop
        while (cycleP < check.length) {
            //cycles through the given array to check for redundant points
            double cSqred, cpSqred;
            // note, to use with a large number of points more efficiently, create nested for loop
            cSqred = (check[cycle][0] * check[cycle][0]);
            cpSqred = (check[cycleP][1] * check[cycleP][1]);
            if (cSqred + cpSqred == Math.pow(radius, 2)) {
                //Formula explanation: if x^2 in cycle + y^2 in cycleP equals the Radius^2
                //Then the points are redundant.
                //Thus it returns true, for redundant.
                return true;
            }
            cycle++;
            cycleP++;
        }
    return false; //returns that no points are redundant.
    }

    public static double[] degrees(double[][] evalPoints) {
        //continue the statement using
        //the cos formula
        double angle, angle2, angle3, side1, side2, side3;
        //below is the formula for Triangle angles
        double distanceL1 = Math.sqrt((Math.pow((evalPoints[1][0]) - (evalPoints[0][0]),2)) +
                (Math.pow((evalPoints[1][1]) - (evalPoints[0][1]),2)));
        //Creates the sides from the point's distance
        double distanceL2 = Math.sqrt((Math.pow((evalPoints[2][0]) - (evalPoints[1][0]),2)) +
                (Math.pow((evalPoints[2][1]) - (evalPoints[1][1]),2)));
        //Same as above
        double distanceL3 =   Math.sqrt((Math.pow((evalPoints[0][0]) - (evalPoints[2][0]),2)) +
                (Math.pow((evalPoints[0][1]) - (evalPoints[2][1]),2)));

        side1 = (distanceL1);
        side2 = (distanceL2);
        side3 = (distanceL3);
        double[] evalDegrees = new double[3];
        double[] evalAngles = new double[3];

        evalDegrees[0] = Math.pow(side1, 2); // sides 1-3 squared
        evalDegrees[1] = Math.pow(side2, 2); //
        evalDegrees[2] = Math.pow(side3, 2); //

        evalAngles[0] = ((evalDegrees[1] + evalDegrees[2]) - evalDegrees[0]) /  (2 * side2 * side3);
        evalAngles[1] = ((evalDegrees[0] + evalDegrees[2]) - evalDegrees[1]) / (2 *  side3 * side1);
        evalAngles[2] = ((evalDegrees[0] + evalDegrees[1]) - evalDegrees[2]) / (2 *  side1 * side2);
        for(int i = 0; i <= 2; i++) {
            evalAngles[i] = Math.toDegrees(Math.acos(evalAngles[i]));
        }
        return evalAngles; //the above initializes evalDegrees, map:
        // distanceL1-3 >> sides1-3 >> evalDegrees >> evalAngles >>
    }

    public static String[] toStringTri() {
        double[][] output = getPoints();
        double degreesOutput[] = degrees(output);
        String[] combined = new String[2];
        combined[0] = ("the points are as follows: " + getCombined(output));
        combined[1] = ("" + getCombinedangles(degreesOutput));
        return combined;
    }
    public static String getCombinedangles(double[] degreesOutput) {
            int first = degreesOutput.length - 1;
            String conCat = "The angles are in the order of points: ";
        for (int i = 0; i <= first; i++ ) {
            conCat += (("Point :" + (i + 1) + "\t" + degreesOutput[i] + "\t"));
        }
        return conCat;
    }

    public static String getCombined(double[][] output) {
        String combined = "";
        int first = output.length - 1;
        for(int i = 0; i <= first; i++) {
            combined += ("\t" + "x" + i + ":" + output[i][0] + "\t" + "y" + i + ": " + output[i][1]);
        }
        return combined;
    }
}
