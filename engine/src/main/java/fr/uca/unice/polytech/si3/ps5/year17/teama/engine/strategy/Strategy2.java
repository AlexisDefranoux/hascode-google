package fr.uca.unice.polytech.si3.ps5.year17.teama.engine.strategy;

import fr.uca.unice.polytech.si3.ps5.year17.teama.engine.ControllerState;
import fr.uca.unice.polytech.si3.ps5.year17.teama.engine.state.Cache;
import fr.uca.unice.polytech.si3.ps5.year17.teama.engine.state.Video;

import java.util.Random;

public class Strategy2 extends Strategy{

    /**
     * ajoute une vidéo random dans un cache random.
     */
    public Strategy2(ControllerState controllerState) {
        super(controllerState);
        main();
    }

    protected void main() {

        Random randomGenerator = new Random();

        while (videos.size() != 0) {
            Video video = videos.get(randomGenerator.nextInt(videos.size()));
            videos.remove(video);

            Cache cache = caches.get(randomGenerator.nextInt(caches.size()));
            cache.addVideoHolder(video);
        }
    }
}

