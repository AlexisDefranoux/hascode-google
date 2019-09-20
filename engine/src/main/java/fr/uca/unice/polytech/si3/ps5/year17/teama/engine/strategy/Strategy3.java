package fr.uca.unice.polytech.si3.ps5.year17.teama.engine.strategy;

import fr.uca.unice.polytech.si3.ps5.year17.teama.engine.ControllerState;
import fr.uca.unice.polytech.si3.ps5.year17.teama.engine.state.Cache;

/**
 * Rempli tous les caches avec la vidéo de la première requête, puis avec la seconde requête, etc..
 */
public class Strategy3 extends Strategy {

    public Strategy3(ControllerState controllerState){
        super(controllerState);
        main();
    }

    protected void main(){

        int i = 0;

        for (Cache cache : controllerState.getCaches()){

            if(videos.size()==i)
                break;

            while(cache.addVideoHolder(videos.getVideo(i))){
                i++;
                if(videos.size()==i)
                    break;
            }
        }
    }
}