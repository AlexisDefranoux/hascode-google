package fr.uca.unice.polytech.si3.ps5.year17.teama;

import fr.uca.unice.polytech.si3.ps5.year17.teama.engine.ControllerState;
import fr.uca.unice.polytech.si3.ps5.year17.teama.engine.InputSplitter;
import fr.uca.unice.polytech.si3.ps5.year17.teama.engine.Score;
import fr.uca.unice.polytech.si3.ps5.year17.teama.engine.state.Cache;
import fr.uca.unice.polytech.si3.ps5.year17.teama.engine.state.CacheHolder;
import junit.framework.TestCase;
import org.junit.Ignore;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class ScoreTest extends TestCase{

    @Ignore
    public void testScoreFile() {
        String pathDataIn = Paths.get("..").toAbsolutePath().toString();
        File file = new File(pathDataIn,"data");
        file = new File(file,"test.in");

        ControllerState controllerState = new ControllerState();
        try {
            controllerState = InputSplitter.Lecture(controllerState, file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        CacheHolder caches = controllerState.getCaches();

        for(Cache cache: caches){
            if(cache.getId()==0){
                cache.addVideoHolder(controllerState.getVideoHolder().getVideo(2));
            }else if(cache.getId()==1){
                cache.addVideoHolder(controllerState.getVideoHolder().getVideo(3));
                cache.addVideoHolder(controllerState.getVideoHolder().getVideo(1));
            }else if(cache.getId()==2){
                cache.addVideoHolder(controllerState.getVideoHolder().getVideo(0));
                cache.addVideoHolder(controllerState.getVideoHolder().getVideo(1));
            }
        }

        try {
            String pathScoreOut = "";
            assertEquals(462500,(int) Score.scoreFile(controllerState, null));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}