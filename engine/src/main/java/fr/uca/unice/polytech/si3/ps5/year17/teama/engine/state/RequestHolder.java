package fr.uca.unice.polytech.si3.ps5.year17.teama.engine.state;

import java.util.*;

public class RequestHolder extends ArrayList<Request> {

    public RequestHolder() { }

    /**
     * Trouve si le endpoint à demandé cette vidép
     * @param video la video
     * @return boolean true si vidéo trouvé, sinon false
     */
    public boolean isRequested(Video video) {
        for (Request req : this) {
            if (req.getVideo().equals(video) ) {
                return true;
            }
        }
        return false;
    }
}
