package fr.uca.unice.polytech.si3.ps5.year17.teama.engine.state;

import java.util.ArrayList;


public class VideoHolder extends ArrayList<Video> {

    public VideoHolder(){
    }

    public boolean addVideo(Video video){
        if(this.contains(video)) return false;
        return this.add(video);
    }

    /**
     * Récupère la vidéo en fonction de son id
     * @param idVideo
     * @return retourne la vidéo si trouvé, sinon retourne null
     */
    public Video getVideo(int idVideo){
        for(Video video : this){
            if(video.getId() == idVideo)
                return video;
        }
        return null;
    }
}
