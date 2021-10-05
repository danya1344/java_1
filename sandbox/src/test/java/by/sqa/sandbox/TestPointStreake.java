package by.sqa.sandbox;

public class TestPointStreake {
    TestPoint  p1, p2;
    TestPointStreake (TestPoint  punkt1, TestPoint  punkt2) {
        this.p1 = punkt1;
        this.p2 = punkt2;
    }
    public TestPoint  mittelPunkt() {
        return new TestPoint  ((p1.getX()+p2.getX())/2, (p1.getY()+p2.getY())/2);
    }
    public double abstand() {
        return Math.sqrt(
                (p1.getX() - p2.getX()) *  (p1.getX() - p2.getX()) +
                        (p1.getY() - p2.getY()) *  (p1.getY() - p2.getY())
        );
    }
    static public void main (String args[]) {
        TestPointStreake s = new TestPointStreake (new TestPoint (0, 1.0), new TestPoint (2.0, -2.0));
        TestPoint  mp = s.mittelPunkt ();
        System.out.println ("Midpoint = (" + mp.getX() + "," + mp.getY() + ")");
        double as = s.abstand();
        System.out.println ("Length   = " + as);
    }
}

