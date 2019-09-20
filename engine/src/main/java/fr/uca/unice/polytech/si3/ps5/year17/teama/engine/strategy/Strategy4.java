package fr.uca.unice.polytech.si3.ps5.year17.teama.engine.strategy;

import fr.uca.unice.polytech.si3.ps5.year17.teama.engine.ControllerState;
import fr.uca.unice.polytech.si3.ps5.year17.teama.engine.state.*;

/**
 * Rempli tous les caches avec la vidéo la plus demandé, puis avec la seconde vidéo, etc..
 */
public class Strategy4 extends Strategy {

    public Strategy4(ControllerState controllerState) {
        super(controllerState);
        main();
    }

    protected void main() {

        sortVideoByTotalRequest();
        int i = 0;

        for (Cache cache : controllerState.getCaches()){

            if(videos.size()==i)
                break;

            while(cache.addVideoHolder(videos.get(i))){
                i++;

                if(videos.size()==i)
                    break;
            }
        }
    }
}
