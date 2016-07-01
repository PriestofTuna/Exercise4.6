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

    public static double[][] getPoints() { //was getPointX
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
                //Formula explanation: if xe2 in cycle + ye2 in cycleP equals the Radius
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
        double angle, angle2, angle3;
        //below is the formula for Triangle angles, used instead of holding the angles, as this is reusable.
        double distanceL1 = ((Math.pow(evalPoints[1][0], 2)) - (Math.pow(evalPoints[0][0], 2)) /
                ((Math.pow(evalPoints[0][1], 2)) - (Math.pow(evalPoints[1][1], 2))));
        double distanceL2 = ((Math.pow(evalPoints[2][0], 2)) - (Math.pow(evalPoints[1][0], 2)) /
            ((Math.pow(evalPoints[2][1], 2)) - (Math.pow(evalPoints[1][1], 2))));
        double distanceL3 = ((Math.pow(evalPoints[0][0], 2)) - (Math.pow(evalPoints[2][0], 2)) /
        ((Math.pow(evalPoints[0][1], 2)) - (Math.pow(evalPoints[2][1], 2))));

        angle2 = Math.tan(distanceL1 / distanceL2);
        angle3 = Math.tan(distanceL2 / distanceL3);
        angle = 180 - (Math.abs(angle2) + Math.abs(angle3));
        double[] evalDegrees = new double[3];
        evalDegrees[0] = angle;
        evalDegrees[1] = angle2;
        evalDegrees[2] = angle3;
        return evalDegrees;
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
            String conCat = "";
        for (int i = 0; i <= first; i++ ) {
            conCat += (("The angles are in order of points " + "\t" + degreesOutput[i]));
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
