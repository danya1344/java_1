package by.sqa.sandbox;

public class PointData {
    public double a;
    public double b;
    public double distance;

    public PointData(double a, double b) {
        this.a = a;
        this.b = b;
    }
    public double distance() {
        return (this.a - this.b);
    }
}
