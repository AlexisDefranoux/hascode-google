package fr.uca.unice.polytech.si3.ps5.year17.teama.engine.state;

import java.util.HashMap;
import java.util.Objects;

public class Cache {

    private int id;
    private int sizeMax;
    private int sizeCurrent;

    private VideoHolder videoholder = new VideoHolder();
    private HashMap<EndPoint,Integer> endPoints = new HashMap<>();

    public Cache(int id, int sizeMax){
        this.id = id;
        this.sizeMax = sizeMax;
        this.sizeCurrent = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSizeMax() {
        return sizeMax;
    }

    public void setSizeMax(int sizeMax) {
        this.sizeMax = sizeMax;
    }

    public int getSizeCurrent() {
        return sizeCurrent;
    }

    public void setSizeCurrent(int sizeCurrent) {
        this.sizeCurrent = sizeCurrent;
    }

    public VideoHolder getVideoholder() {
        return videoholder;
    }

    public void setVideoholder(VideoHolder videoholder) {
        this.videoholder = videoholder;
    }

    public HashMap<EndPoint,Integer> getEndPoints() {
        return endPoints;
    }

    public void setEndPoints(HashMap<EndPoint,Integer> endPoints) {
        this.endPoints = endPoints;
    }

    /**
     * Ajoute une vidéo dans le cache
     * @param video à ajouter au cache
     * @return boolean si ajouté ou pas
     */
    public boolean addVideoHolder(Video video){
        if(sizeCurrent + video.getSize() <= sizeMax ){
            sizeCurrent += video.getSize();
            videoholder.addVideo(video);
            return true;
        }
        return false;
    }

    public void sendToEndpoint(Video video){

        for(EndPoint endPoint : endPoints.keySet()){
            endPoint.getTimeToAccesVideo().replace(video,endPoints.get(endPoint));
        }
    }

    /**
     * Compare le cache 1 avec le cache 2
     * @param o
     * @return boolean true si égale, false si différent
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cache cache = (Cache) o;
        return id == cache.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
