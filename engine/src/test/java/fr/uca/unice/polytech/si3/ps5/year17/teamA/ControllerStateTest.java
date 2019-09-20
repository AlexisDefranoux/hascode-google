package fr.uca.unice.polytech.si3.ps5.year17.teama;

import fr.uca.unice.polytech.si3.ps5.year17.teama.engine.ControllerState;
import fr.uca.unice.polytech.si3.ps5.year17.teama.engine.state.EndPoint;
import junit.framework.TestCase;

import java.util.ArrayList;

public class ControllerStateTest extends TestCase {

    public void testGetEndPoint() {
        ArrayList<EndPoint> endPoints = new ArrayList<>();
        EndPoint e1 = new EndPoint(0,5000);
        EndPoint e2 = new EndPoint(1,5000);
        EndPoint e3 = new EndPoint(2,5000);
        endPoints.add(e1);
        endPoints.add(e2);

        ControllerState contro = new ControllerState(endPoints);
        assertTrue(contro.getEndPoint(e1.getId()) == e1);
        assertTrue(contro.getEndPoint(e2.getId()) == e2);
        assertTrue(contro.getEndPoint(e3.getId()) == null);

    }
}