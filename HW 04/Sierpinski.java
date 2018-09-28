/**
 * Name : Hector Herrera
 * PennKey : Hectorh
 * Recitation : 216
 * 
 * Execution: java Sierpinski
 * 
 * This will produce a Sierpinski Triangle using recursion of random shades
 * of blue
 */

public class Sierpinski {
    public static void main(String [] args) {
       //triangle(.5, .5, Math.sqrt(3) * .5);
        
        int numLevels = Integer.parseInt(args[0]);
        sierpinski(numLevels, .5, .5, Math.sqrt(3) * .5);
    }
    
    /*
     * Description: draws an equilateral triangle given a point
     * Input: it takes in a side length and two coordinates as doubles
     * Output: an equilateral triangle 
     */
    public static void triangle(double sideLength, double xTop, double yTop) {
        //set the color to q random shade of blue
        double color = 100 + Math.random() * 156;
        int color1 = (int) color;
        PennDraw.setPenColor(60, color1, 200);
        
        //find the other two coordinates
        double xRight = xTop - .5 * sideLength;
        double yRight = yTop - Math.sqrt(3) * .5 * sideLength;
        double xLeft = xTop + .5 * sideLength;
        double yLeft = yTop - Math.sqrt(3) * .5 * sideLength;
        
        //draws the triangle
        PennDraw.filledPolygon(xTop, yTop, xRight, yRight, xLeft, yLeft);   
    }
    
    /*
     * Description: this function will do the recursion using the triangle
     *              function for an end result of the sierpinski triangle
     * Input: it inputs numLevels, the size of the triangle as an int
     *        and the x and y coordinate as doubles.
     * Output: it outputs an int followed by a double representing 
     *         the recursion of numLevels and size
     */
    public static int sierpinski(int numLevels, double size, 
                                 double xTop, double yTop) {
        //System.out.print(numLevels + " ");
        //System.out.println(size);
        
        //the triangle that is going to be called
        triangle(1 * size, xTop, yTop);
        
        int temp = numLevels;
        
        //base case that will do the recursion
        if (numLevels <=  1) {
        } else {
            numLevels = sierpinski(temp - 1, size / 2, //right triangle
                                   xTop + .5 * size, yTop); 
            numLevels = sierpinski(temp - 1, size / 2, //left triangle
                                   xTop - .5 * size, yTop); 
            numLevels = sierpinski(temp - 1, size * .5, //bottom triangle
                                   xTop, yTop - Math.sqrt(3) / 2 * size);
        }
        return numLevels;
    }
}