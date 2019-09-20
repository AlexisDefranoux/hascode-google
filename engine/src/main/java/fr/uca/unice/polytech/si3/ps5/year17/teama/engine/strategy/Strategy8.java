package fr.uca.unice.polytech.si3.ps5.year17.teama.engine.strategy;

import fr.uca.unice.polytech.si3.ps5.year17.teama.engine.ControllerState;
import fr.uca.unice.polytech.si3.ps5.year17.teama.engine.state.*;

import java.util.*;

/**
 * Commence par le endpoint qui à le plus de reqête totals, prend le cache le plus efficace, prends la requete la plus demandé
 */
public class Strategy8 extends Strategy {

    public Strategy8(ControllerState controllerState) {
        super(controllerState);
        main();
    }

    protected void main() {

        sortEndpointByNbRequestTotal();
        ArrayList<Cache> cachesTrier;
        ArrayList<Video> videosTrier;

        for (EndPoint endPoint : endPoints) {

            cachesTrier = sortByValuesCache(endPoint.getCacheConnected());

            videosTrier = sortVideosBySizeAndNbRequest(endPoint.getRequestHolder());

            for(Video video : videosTrier){

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
