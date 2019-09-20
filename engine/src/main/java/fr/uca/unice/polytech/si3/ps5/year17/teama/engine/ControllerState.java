package fr.uca.unice.polytech.si3.ps5.year17.teama.engine;

import fr.uca.unice.polytech.si3.ps5.year17.teama.engine.state.CacheHolder;
import fr.uca.unice.polytech.si3.ps5.year17.teama.engine.state.EndPoint;
import fr.uca.unice.polytech.si3.ps5.year17.teama.engine.state.VideoHolder;

import java.util.ArrayList;

public class ControllerState {

    private ArrayList<EndPoint> endPoints = new ArrayList<EndPoint>();
    private VideoHolder videoHolder = new VideoHolder();
    private CacheHolder caches = new CacheHolder();

    public ControllerState(){}

    public ControllerState(ArrayList<EndPoint> endPoints) {
        this.endPoints = endPoints;
    }

    public VideoHolder getVideoHolder() {return videoHolder; }

    public void setVideoHolder(VideoHolder videoHolder) {this.videoHolder = videoHolder; }

    public ArrayList<EndPoint> getEndPoints() {
        return endPoints;
    }

    public CacheHolder getCaches() {
        return caches;
    }

    public void setCaches(CacheHolder caches) {
        this.caches = caches;
    }

    public void setEndPoints(ArrayList<EndPoint> endPoints) {
        this.endPoints = endPoints;
    }

    /**
     * Retourne le endpoint en fonction du id passé en paramètre
     * @param idEndPoint
     * @return endpoint si trouvé, sinon null
     */
    public EndPoint getEndPoint(int  idEndPoint){
        for(EndPoint endPoint1 : endPoints ){
            if(endPoint1.getId() == idEndPoint){
                return endPoint1;
            }
        }
        return null;
    }
}
