import edu.duke.*;
import java.io.File;
import java.util.*;

public class PerimeterAssignmentRunner {
    public int getNumPoints (Shape s) {
        int numPoints = 0;
        for (Point p : s.getPoints()) {
            numPoints++;
        }
        return numPoints;
    }

    public double getAverageLength(Shape s) {
        double totalLength = 0;
        List<Point> l = new ArrayList<Point>();
        for (Point p : s.getPoints()) {
            l.add(p);
            // System.out.println(p);
            // totalLength += s.getLastPoint().distance(p);
        }

        for (int i = 0; i < l.size()-1; i++) {
            if (i == 0) {
                System.out.println(l.get(0).getClass());
                totalLength += l.get(0).distance(l.get(l.size()-1));
            }
            totalLength += l.get(i).distance(l.get(i+1));
        }

        return totalLength/l.size();
    }

    public double getLargestSide(Shape s) {
        // Put code here
        return 0.0;
    }

    public double getLargestX(Shape s) {
        // Put code here
        return 0.0;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        return 0.0;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        return temp.getName();
    }

    public void testPerimeterMultipleFiles() {
        // Put code here
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        // double peri = getPerimeter(triangle);
        // System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public void testPerimeter() {
        // PerimeterAssignmentRunner p = new PerimeterAssignmentRunner();
        FileResource fr = new FileResource("example1.txt");
        Shape example1 = new Shape(fr);
        // triangle.addPoint(new Point(0,0));
        // triangle.addPoint(new Point(6,0));
        // triangle.addPoint(new Point(3,6));
        System.out.println(getAverageLength(example1));
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
