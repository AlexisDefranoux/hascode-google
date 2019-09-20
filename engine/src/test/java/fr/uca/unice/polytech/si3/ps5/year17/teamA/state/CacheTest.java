package fr.uca.unice.polytech.si3.ps5.year17.teama.engine.state;

import junit.framework.TestCase;

public class CacheTest  extends TestCase {

    public void testAddVideoHolder() {
        Video v1 = new Video(0,50);
        Cache c = new Cache(0,250);
        //Ajout d'une video
        c.addVideoHolder(v1);
        assertTrue(c.getSizeCurrent() == 50);
        //Ajout d'une video jusqu'au max size
        Video v2 = new Video(0,200);
        c.addVideoHolder(v2);
        assertTrue(c.getSizeMax() == c.getSizeCurrent());
        //Ajout d'une video jusqu'au depassement du max size
        Video v3 = new Video(0,50);
        c.addVideoHolder(v3);
        assertTrue(c.getSizeMax() == c.getSizeCurrent());
    }

    public void testEquals(){
        Cache c1 = new Cache(0,500);
        Cache c2 = new Cache(1,500);
        Cache c3 = null;

        assertTrue(c1.equals(c1));
        assertTrue((c1.equals(c2)) == false);
        assertTrue((c1.equals(c3)) == false );
    }
}