package by.sqa.sandbox;

import org.testng.annotations.Test;

public class PointTests {
    @Test
    public void testPoint() {
        PointData p = new PointData(15,5);
        assert p.distance == 10;
    }
}



