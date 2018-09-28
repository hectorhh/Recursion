/**
 * Name : Hector Herrera
 * PennKey : Hectorh
 * Recitation : 216
 * 
 * Execution: java Art
 * 
 * This will produce a flower with text saying "WILL YOU BE MY VALENTINE?"
 */
public class Art { 
    public static void main(String [] args) {
        //set the background to black
        PennDraw.clear(PennDraw.BLACK);
        
        //draw the stem
        PennDraw.setPenRadius(.02);
        PennDraw.setPenColor(PennDraw.GREEN);
        PennDraw.line(.5, 0, .5, .5);
        
        //draw the flower pot
        PennDraw.setPenColor(PennDraw.BLUE);
        PennDraw.filledPolygon(.4, 0, .6, 0, .75, .15, .25, .15);
        
        //include text
        PennDraw.setPenColor(255, 0, 0);
        PennDraw.text(.33, .95, "WILL YOU BE");
        PennDraw.text(.7, .95, "MY VALENTINE?");
        
        //calls the recursion
        int depth = Integer.parseInt(args[0]);
        draw(depth, .5, .5, .65);
    }
    /*
     * Description: draws a purple square given coordinates and a radius
     * Input: two double coordinates as the center of the square and a double 
     *        radius
     * Output: it draws a square
     */
    public static void square(double x, double y, double radius) {
        //chooses a random shade of purple
        double color1 = 100 + Math.random() * 156;
        int color = (int) color1;
        PennDraw.setPenColor(color, 0, color);
        
        //draws the square
        PennDraw.filledSquare(x, y, radius);  
    }
    /*
     * Description: this function will do the recursion by using the square 
     *              function 
     * Input: the depth as an integer, the scale as a double and coordinates 
     *        as doubles
     * Output: it will retrun an int of depth that can be used for recursion
     */
    public static int draw(int depth, double scale, double x, double y) {
         int temp = depth;
         square(x, y, .4 * scale);
         
         //base case
         if (depth <= 1) {
         } else {
             depth = draw(temp - 1, scale / 2, x + scale / 3, y); //right square
             depth = draw(temp - 1, scale / 2, x - scale / 3, y); //left square
             depth = draw(temp - 1, scale / 2, x, y + scale / 3); //top square
             depth = draw(temp - 1, scale / 2, x, y - scale / 3); //bottom square
         }
         return depth;
    }
}