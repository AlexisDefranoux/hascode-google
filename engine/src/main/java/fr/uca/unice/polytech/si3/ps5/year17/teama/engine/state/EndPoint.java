package fr.uca.unice.polytech.si3.ps5.year17.teama.engine.state;

import java.util.*;

public class EndPoint {

    private int id;
    //objet Cache + latence par rapport à endpoint
    private HashMap<Cache,Integer> cacheConnected = new HashMap<>();
    private RequestHolder requestHolder = new RequestHolder();
    private HashMap<Video, Integer> timeToAccesVideo;
    private int latenceToDataCenter;
    private int nbRequestTotal;

    public EndPoint(int id, int latenceToDataCenter){
        this.id = id;
        this.latenceToDataCenter = latenceToDataCenter;
        this.nbRequestTotal = 0;
        timeToAccesVideo = new HashMap<>();
    }

    public int getNbRequestTotal() {
        return nbRequestTotal;
    }

    public void setId(int id) {this.id = id; }


    public void setCacheConnected(HashMap<Cache, Integer> cacheConnected) {
        this.cacheConnected = cacheConnected;
    }

    public void setRequestHolder(RequestHolder requestHolder) {
        this.requestHolder = requestHolder;
        initTimeToAccesVideo();
    }

    private void initTimeToAccesVideo(){
        for(Request request : requestHolder){
            timeToAccesVideo.put(request.getVideo(),latenceToDataCenter);
        }
    }
    public HashMap<Video, Integer> getTimeToAccesVideo() {
        return timeToAccesVideo;
    }

    public void setTimeToAccesVideo(HashMap<Video, Integer> timeToAccesVideo) {
        this.timeToAccesVideo = timeToAccesVideo;
    }

    public int getLatenceToDataCenter() {
        return latenceToDataCenter;
    }

    public void setLatenceToDataCenter(int latenceToDataCenter) {
        this.latenceToDataCenter = latenceToDataCenter;
    }

    public int getId() {
        return id;
    }

    public HashMap<Cache, Integer> getCacheConnected() {
        return cacheConnected;
    }

    public RequestHolder getRequestHolder() {
        return requestHolder;
    }

    public void addRequest(Request request){
        requestHolder.add(request);
        nbRequestTotal += request.getNbRequestByEndPoint();
        timeToAccesVideo.put(request.getVideo(),latenceToDataCenter);

    }

    /**
     * Donne le temps gagné pour acceder à la vidéo depuis ce endpoint
     * @param video la vidéo à accéder
     * @return le temps sauvé
     */
    public int getTimeSave(Video video){

        int latenceMin = latenceToDataCenter;

        for(Cache cache : cacheConnected.keySet()){
            if(cacheConnected.get(cache) < latenceMin){
                if(cache.getVideoholder().contains(video)){
                    latenceMin = cacheConnected.get(cache);
                }
            }
        }
        return latenceToDataCenter - latenceMin;
    }

    /**
     * Donne la latence minimum pour accéder à une vidéo depuis ce endpoint
     * @param video la vidéo à accéder
     * @return la latence minimum
     */
    public int getCacheToAcces(Video video){

        int latenceMin = latenceToDataCenter;

        for(Cache cache : cacheConnected.keySet()){
            if(cacheConnected.get(cache) < latenceMin){
                if(cache.getVideoholder().contains(video)){
                    latenceMin = cacheConnected.get(cache);
                }
            }
        }
        return latenceMin;
    }

    /**
     * Retourne une hashmap du temps gagné pour chaque vidéo sur un cache donné
     * @param latence la vidéo à accéder
     * @return une TreeMap de vidéo et de temps gagné
     */
    public void getRequestTimeSave(int latence, HashMap<Video, Integer> sortedOnKeysMap){
        int latenceCurr,
                timeSave;

        for(Request request : requestHolder){
            try{
                latenceCurr = timeToAccesVideo.get(request.getVideo());

                if (latenceCurr > latence) {
                    timeSave = ((latenceCurr - latence) / request.getVideo().getSize()) * request.getNbRequestByEndPoint();
                    if (!sortedOnKeysMap.containsKey(request.getVideo())) {
                        sortedOnKeysMap.put(request.getVideo(), timeSave);
                    } else {
                        timeSave += sortedOnKeysMap.get(request.getVideo());
                        sortedOnKeysMap.replace(request.getVideo(), timeSave);
                    }
                }
            }catch (NullPointerException e){

            }
        }
    }
}
