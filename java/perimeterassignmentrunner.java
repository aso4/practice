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
                // System.out.println(l.get(0).getClass());
                totalLength += l.get(0).distance(l.get(l.size()-1));
            }
            totalLength += l.get(i).distance(l.get(i+1));
        }

        return totalLength/l.size(); // totalLength/l.size
    }

    public double getTotalLength(Shape s) {
        double totalLength = 0;
        List<Point> l = new ArrayList<Point>();
        for (Point p : s.getPoints()) {
            l.add(p);
        }

        for (int i = 0; i < l.size()-1; i++) {
            if (i == 0) {
                totalLength += l.get(0).distance(l.get(l.size()-1));
            }
            totalLength += l.get(i).distance(l.get(i+1));
        }

        return totalLength;
    }

    public double getLargestSide(Shape s) {
        double largestSide = 0;
        List<Point> l = new ArrayList<Point>();
        for (Point p : s.getPoints()) {
            l.add(p);
        }
        largestSide = l.get(0).distance(l.get(l.size()-1));
        // System.out.println("largestSide: " + largestSide);
        // System.out.println("l.size: " + l.size());
        for (int i = 0; i < l.size()-1; i++) {
            // System.out.println("i: " + i);
            if (largestSide < l.get(i).distance(l.get(i+1))) {
                largestSide = l.get(i).distance(l.get(i+1));
                // System.out.println("new largestSide: " + largestSide);
            }

        }
        return largestSide;
    }

    public double getLargestX(Shape s) {
        double largestX = 0.0;
        for (Point p : s.getPoints()) {
            if (p.getX() > largestX) {
                largestX = p.getX();
            }
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        double largestPerimeter = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
             FileResource fr = new FileResource(f);
             Shape fileShape = new Shape(fr);
             if (getTotalLength(fileShape) > largestPerimeter) {
                 largestPerimeter = getTotalLength(fileShape);
             }
             System.out.println("perimeter " + f.getName() + ": " + getTotalLength(fileShape));
        }
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        double largestPerimeter = 0;
        File temp = null;

        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
             FileResource fr = new FileResource(f);
             Shape fileShape = new Shape(fr);
             if (getAverageLength(fileShape)*getNumPoints(fileShape) > largestPerimeter) {
                 temp = f;
             }
        }

        return temp.getName();
    }

    public void testPerimeterMultipleFiles() {
        // Put code here
        System.out.println(getLargestPerimeterMultipleFiles());
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        System.out.println(getFileWithLargestPerimeter());
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
        FileResource f1 = new FileResource("datatest4.txt");
        Shape temp1 = new Shape(f1);
        System.out.println("1. " + getTotalLength(temp1));

        FileResource f2 = new FileResource("datatest1.txt");
        Shape tempShape = new Shape(f2);
        System.out.println("2. " + getAverageLength(tempShape));

        FileResource f3 = new FileResource("datatest4.txt");
        Shape temp3 = new Shape(f3);
        System.out.println("3. " + getLargestSide(temp3));

        // FileResource f4 = new FileResource("datatest4.txt");
        // Shape temp4 = new Shape(f4);
        // System.out.println("4. " + getLargestSide(temp4));
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
