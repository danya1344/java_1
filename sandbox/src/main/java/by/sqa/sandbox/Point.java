package by.sqa.sandbox;

public class Point {
    public static void main(String[] args) {

        PointData P = new PointData(0, 1, 2, -2);
        System.out.println("point distance =" + distance(P));
    }
    public static double distance (@org.jetbrains.annotations.NotNull PointData P) {
        return Math.sqrt((P.p3-P.p1)*(P.p3-P.p1)+(P.p4-P.p2)*(P.p4-P.p2));
    }
}

