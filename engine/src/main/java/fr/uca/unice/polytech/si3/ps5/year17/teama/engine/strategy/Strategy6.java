package fr.uca.unice.polytech.si3.ps5.year17.teama.engine.strategy;

import fr.uca.unice.polytech.si3.ps5.year17.teama.engine.ControllerState;
import fr.uca.unice.polytech.si3.ps5.year17.teama.engine.state.*;

import java.util.*;

/**
 * Met les vidéos les plus demandées par endPoint dans le cache le plus proche. Si plein second plus proche
 */
public class Strategy6 extends Strategy {

    public Strategy6(ControllerState controllerState) {
        super(controllerState);
        main();
    }
    protected void main() {

        sortVideoByTotalRequest();
        ArrayList<Cache> cachesTrier;

        for(EndPoint endPoint: endPoints){

            cachesTrier = sortByValuesCache(endPoint.getCacheConnected());

            for(Video video : videos){

                if(endPoint.getRequestHolder().isRequested(video)){

                    for(Cache cache : cachesTrier) {

                        if (!cache.getVideoholder().contains(video)) {
                            if(cache.addVideoHolder(video))
                                break;
                        }else
                            break;
                    }
                }
            }
        }
    }
}
