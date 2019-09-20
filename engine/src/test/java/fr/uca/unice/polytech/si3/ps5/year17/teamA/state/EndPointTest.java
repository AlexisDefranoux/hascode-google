package fr.uca.unice.polytech.si3.ps5.year17.teama.engine.state;

import junit.framework.TestCase;

import java.util.HashMap;

public class EndPointTest extends TestCase{

    public void testAddEndPoint() {
        EndPoint e1 = new EndPoint(0,5000);
        Video v1 = new Video(0,500);
        Video v2 = new Video(1,500);
        Request r1 = new Request(v1,e1,500);
        Request r2 = new Request(v2,e1,500);

        e1.addRequest(r1);
        assertTrue(e1.getRequestHolder().size() == 1);
        assertTrue(e1.getRequestHolder().contains(r1));
        assertFalse(e1.getRequestHolder().contains(r2));

        e1.addRequest(r2);
        assertTrue(e1.getRequestHolder().size() == 2);
        assertTrue(e1.getRequestHolder().contains(r2));
    }

    public void testGetTimeSave() throws Exception {
        EndPoint end1 = new EndPoint(0,5000);
        Video v1 = new Video(0,750);
        Video v2 = new Video(1,750);
        Video v3 = new Video(3,750);
        Cache c1 = new Cache(0,1000);
        Cache c2 = new Cache (1,1000);
        Cache c3 = new Cache (2,1000);

        c1.addVideoHolder(v1);
        c2.addVideoHolder(v2);
        c3.addVideoHolder(v3);
        HashMap<Cache,Integer> connect = end1.getCacheConnected();
        connect.put(c1,1000);
        connect.put(c2,4500);
        connect.put(c3,5000);
        end1.setCacheConnected(connect);

        assertTrue(end1.getTimeSave(v1) == 4000);
        assertTrue(end1.getTimeSave(v2) == 500);
        assertTrue(end1.getTimeSave(v3) == 0);
    }

    public void testGetCacheToAcess() throws Exception {
        EndPoint end1 = new EndPoint(0,5000);
        Video v1 = new Video(0,450);
        Video v2 = new Video(1,450);
        Video v3 = new Video(3,450);
        Cache c1 = new Cache(0,1000);
        Cache c2 = new Cache (1,1000);
        Cache c3 = new Cache (2,1000);

        c1.addVideoHolder(v1);
        c1.addVideoHolder(v2);
        c2.addVideoHolder(v2);
        c3.addVideoHolder(v3);

        HashMap<Cache,Integer> connect = end1.getCacheConnected();
        connect.put(c1,1000);
        connect.put(c2,4500);
        connect.put(c3,5500);
        end1.setCacheConnected(connect);
        assertTrue(end1.getCacheToAcces(v1) == 1000);
        assertTrue(end1.getCacheToAcces(v2) == 1000);
        assertTrue(end1.getCacheToAcces(v3) == 5000);
    }

    /*public void testGetRequestTimeSave() throws Exception {
        EndPoint end1 = new EndPoint(0,5000);
        Video v1 = new Video(0,100);
        Video v2 = new Video(1,100);
        Video v3 = new Video(3,100);
        Cache c1 = new Cache(0,1000);
        Cache c2 = new Cache (1,1000);
        Cache c3 = new Cache (2,1000);
        Request r1 = new Request(v1, end1,500);
        Request r2 = new Request(v2, end1,500);
        Request r3 = new Request(v3, end1,500);
        RequestHolder requests = new RequestHolder();

        c2.addVideoHolder(v2);
        c3.addVideoHolder(v3);
        HashMap<Cache,Integer> connect = end1.getCacheConnected();
        connect.put(c1,1000);
        connect.put(c2,4500);
        connect.put(c3,5500);
        requests.add(r1);
        requests.add(r2);
        end1.setCacheConnected(connect);
        end1.setRequestHolder(requests);

        //Contain
        Map<Integer, Video> Vid = end1.getRequestTimeSave(1000);
        assertTrue(Vid.containsKey(v2));
        assertFalse(Vid.containsKey(v3));

        //Size
        assertTrue(Vid.size() == 2);

        //Size +
        requests.add(r3);
        end1.setRequestHolder(requests);
        Vid = end1.getRequestTimeSave(1000);
        assertTrue(Vid.size() == 3);

        //Values
        //assertTrue(Vid.get(v1) == (end1.getLatenceToDataCenter()-1000)/v1.getSize() * r1.getNbRequestByEndPoint());

    }*/

}