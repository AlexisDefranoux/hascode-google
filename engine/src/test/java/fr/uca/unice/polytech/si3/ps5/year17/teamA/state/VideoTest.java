package fr.uca.unice.polytech.si3.ps5.year17.teama.engine.state;

import junit.framework.TestCase;
import org.junit.Test;

public class VideoTest extends TestCase {

    @Test
    public void testEquals() {
        Video v1 = new Video (0,50);
        Video v4 = new Video (1,250);
        Video v5 = null;

        assertTrue(v1.equals(v1));
        assertTrue((v1.equals(v4)) == false);
        assertFalse(!v1.equals(v5) == false );
    }
}