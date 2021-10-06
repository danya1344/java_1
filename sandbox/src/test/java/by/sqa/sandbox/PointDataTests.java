package by.sqa.sandbox;

import org.testng.annotations.Test;

public class PointDataTests {
    @Test
    public void testDistance() {
        PointData p = new PointData(14, 7);
        assert p.distance() == 7;
    }
}



