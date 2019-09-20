package fr.uca.unice.polytech.si3.ps5.year17.teama.engine.state;

import junit.framework.TestCase;

public class VideoHolderTest extends TestCase {

    public void testGetVideo(){
        VideoHolder videos = new VideoHolder();
        Video v1 = new Video(0,100);
        Video v2 = new Video(1,100);
        Video v3 = new Video (2,100);
        videos.add(v1);
        videos.add(v2);

        assertTrue(videos.getVideo(0) == v1);
        assertTrue(videos.getVideo(1) == v2);
        assertTrue(videos.getVideo(2) == null);
    }

}