package fr.uca.unice.polytech.si3.ps5.year17.teama.engine.strategy;

import fr.uca.unice.polytech.si3.ps5.year17.teama.engine.ControllerState;
import fr.uca.unice.polytech.si3.ps5.year17.teama.engine.state.*;

import java.util.*;

public abstract class Strategy {

    protected ControllerState controllerState;
    protected VideoHolder videos;
    protected ArrayList<EndPoint> endPoints;
    protected CacheHolder caches;

    Strategy(ControllerState controllerStrate) {
        this.controllerState = controllerStrate;
        this.endPoints = controllerState.getEndPoints();
        this.videos = controllerState.getVideoHolder();
        this.caches = controllerState.getCaches();
    }

    protected abstract void main();

    /**
     * Trie la liste des vidéos du plus grand nombre de requete au plus petit
     */
    public void sortVideoByTotalRequest() {
        videos.sort(Comparator.comparing(Video::getNbRequestTotal));
        Collections.reverse(videos);
    }

    /**
     * Trie la liste des requêtes de ce endpoint par la requête la plus demandé à la moins demandé.
     * @param endPoint le endpoint
     */
    public void bestRequestByEndPoint(EndPoint endPoint) {
        endPoint.getRequestHolder().sort(Comparator.comparing(Request::getNbRequestByEndPoint));
        Collections.reverse(endPoint.getRequestHolder());
    }

    /**
     * Trie la liste des vidéos du plus grand nombre de requete au plus petit
     */
    public void sortEndpointByNbRequestTotal() {
        endPoints.sort(Comparator.comparing(EndPoint::getNbRequestTotal));
        Collections.reverse(endPoints);
    }

    /**
     * Crée une arraylist de cache trié par la latence la moins forte à la latence la plus forte
     * @param map la map de caches connecté à un endpoint
     * @return l'arraylist de cache trié
     */
    public static ArrayList<Cache> sortByValuesCache(HashMap<Cache, Integer> map) {

        ArrayList<Integer> latence = new ArrayList<>();
        ArrayList<Cache> objectsSorted = new ArrayList<>();

        int i;

        for(Map.Entry<Cache, Integer> entry : map.entrySet()) {
            i=0;

            while (latence.size() > i && latence.get(i) < entry.getValue() ) {
                i++;
            }
            objectsSorted.add(i, entry.getKey());
            latence.add(i, entry.getValue());
        }
        return objectsSorted;
    }

    public static ArrayList<Video> sortByValuesVideo(HashMap<Video, Float> map) {

        ArrayList<Float> ratio = new ArrayList<>();
        ArrayList<Video> objectsSorted = new ArrayList<>();

        int i;

        for(Map.Entry<Video, Float> entry : map.entrySet()) {
            i=0;

            while (ratio.size() > i && ratio.get(i) < entry.getValue() ) {
                i++;
            }
            objectsSorted.add(i, entry.getKey());
            ratio.add(i, entry.getValue());
        }
        return objectsSorted;
    }

    ArrayList<Video> sortVideosBySizeAndNbRequest(RequestHolder requestHolder) {
        HashMap<Video, Float> videos = new HashMap<>();
        float ratio;
        for (Request request : requestHolder) {
            ratio = (float) request.getVideo().getSize() / (float) request.getVideo().getNbRequestTotal();
            videos.put(request.getVideo(), ratio);
        }
        return sortByValuesVideo(videos);
    }
}
