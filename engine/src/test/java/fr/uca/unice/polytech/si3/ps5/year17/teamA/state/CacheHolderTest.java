package fr.uca.unice.polytech.si3.ps5.year17.teama.engine.state;

import junit.framework.TestCase;

public class CacheHolderTest extends TestCase {

    public void testGetCacheById(){
        CacheHolder Caches = new CacheHolder();
        Cache c1 = new Cache(0,500);
        Cache c2 = new Cache(1,500);
        Cache c3 = new Cache(2,500);
        Caches.add(c1);
        Caches.add(c2);

        assertTrue(Caches.getCacheById(c1.getId()) == c1);
        assertTrue(Caches.getCacheById(c2.getId()) == c2);
        assertTrue(Caches.getCacheById(c3.getId()) == null);
    }

    public void testAddCache(){
        CacheHolder Caches = new CacheHolder();
        Cache c1 = new Cache(0,500);
        Cache c2 = new Cache(1,500);
        Cache c3 = new Cache(2,500);
        Caches.add(c1);
        Caches.add(c2);

        assertTrue(Caches.getCacheById(c1.getId()) == c1);
        assertTrue(Caches.getCacheById(c2.getId()) == c2);
        assertTrue(Caches.getCacheById(c3.getId()) == null);
        Caches.addCache(c3);
        assertTrue(Caches.getCacheById(c3.getId()) == c3);

    }
}
