package fr.uca.unice.polytech.si3.ps5.year17.teama.engine.strategy;

import fr.uca.unice.polytech.si3.ps5.year17.teama.engine.ControllerState;
import fr.uca.unice.polytech.si3.ps5.year17.teama.engine.state.*;

import java.util.*;

/**
 * Met les vidéos les plus demandé par tout le monde dans le cache le plus proche pour chacun des endpoints.
 */
public class Strategy5 extends Strategy {

    public Strategy5(ControllerState controllerState) {
        super(controllerState);
        main();
    }

    @Override
    protected void main() {

        ArrayList<Cache> cachesTrier;

        for(EndPoint endPoint: endPoints){

            bestRequestByEndPoint(endPoint);

            for(Request request : endPoint.getRequestHolder()){

                cachesTrier = sortByValuesCache(endPoint.getCacheConnected());

                for(Cache cache : cachesTrier) {
                    if (!cache.getVideoholder().contains(request.getVideo())) {
                        if(cache.addVideoHolder(request.getVideo()))
                            break;
                    }else
                        break;
                }
            }
        }
    }
}

