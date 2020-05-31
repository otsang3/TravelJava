import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    Plane plane;

    @Before
    public void setUp(){
        plane = new Plane(PlaneType.AIRBUSA350);
    }

    @Test
    public void canGetPlaneType(){
        assertEquals(PlaneType.AIRBUSA350, plane.getType());
    }

    @Test
    public void canGetPlaneCapacity(){
        assertEquals(366, plane.getCapacity());
    }
}
