//package fr.uca.unice.polytech.si3.ps5.year17.teama.engine.state;
//
//import junit.framework.TestCase;
//
//import static org.junit.Assert.*;
//
//public class RequestHolderTest extends TestCase {
//
//    public void testIsRequested(){
//        RequestHolder Req = new RequestHolder();
//        Video v1 = new Video(0,50);
//        EndPoint e1 = new EndPoint(0,500);
//        Request r1 = new Request(v1,e1,500);
//
//        Req.add(0,r1);
//        e1.setRequestHolder(Req);
//        assertTrue(Req.isRequested(0,0));
//        assertFalse(Req.isRequested(1,2));
//    }
//}