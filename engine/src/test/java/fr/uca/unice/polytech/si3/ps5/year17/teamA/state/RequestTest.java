package fr.uca.unice.polytech.si3.ps5.year17.teama.engine.state;

import junit.framework.TestCase;
import org.junit.Test;

public class RequestTest extends TestCase{

    @Test
    public void testEquals() {
        Video v1 = new Video (0,50);
        EndPoint end1 = new EndPoint(0,500);
        EndPoint end2 = new EndPoint(1,850);

        Request req1 = new Request(v1,end1,5);
        Request req2 = new Request (v1,end2,50);
        Request req3 = null;

        assertTrue(req1.equals(req1) == true);
        assertTrue(req1.equals(req2) == false);
        assertTrue(req1.equals(req3) == false);

    }
}