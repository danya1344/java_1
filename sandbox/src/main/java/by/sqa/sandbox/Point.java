package by.sqa.sandbox;

public class Point {
    public static void main(String[] args) {

        Pointdata P = new Pointdata(0, 1, 2, -2);
        System.out.println("points distance =" + distance(P));
    }
    public static double distance (Pointdata P){
        return Math.sqrt((P.p3-P.p1)*(P.p3-P.p1)+(P.p4-P.p2)*(P.p4-P.p2));
    }
}

