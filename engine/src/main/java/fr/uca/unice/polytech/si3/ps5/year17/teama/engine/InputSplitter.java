package fr.uca.unice.polytech.si3.ps5.year17.teama.engine;

import fr.uca.unice.polytech.si3.ps5.year17.teama.engine.state.*;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;


public class InputSplitter {

    private static BufferedReader br;

    private static int nbVideo;
    private static int nbEndpoint;
    private static int nbDescri;
    private static int nbCache;
    private static int tailleCache;

    /**
     * Fonction permettant la lecture du fichier d'entrée et son decoupage afin de cree les objets Caches, Endpoint, Request, et Video
     *
     * @param file Fichier d'entrée Google
     * @throws IOException
     */
    public static ControllerState Lecture(ControllerState controllerState, File file) throws IOException {
        //Lecture du fichier
        FileReader fr = new FileReader(file);
        br = new BufferedReader(fr);

        //Recuperation des infos (nb de cache, endpoint, nb de videos, ...)
        String ligne = br.readLine();
        getInfos(ligne);

        //Recuperation de l'id des videos et de leurs taille
        ligne = br.readLine();
        controllerState.setVideoHolder(getAllVideo(ligne));

        //Recuperation de la latence de chacuns des utilisateurs par rapport a chaque caches
        getLatence(br, controllerState);

        //Recuperation des requetes pour chaque video, pour chaque utilisateurs
        getRequestVideo(br, controllerState);
        fr.close();

        return controllerState;
    }

    /**
     * Fonction permettant la recuperation des informations (nombre de videos, nombre de endpoints, ...)
     *
     * @param ligne Ligne du fichier necessaire
     * @throws IOException
     */
    private static void getInfos(String ligne) throws IOException {
        String[] info = ligne.split(" ");
        nbVideo = Integer.parseInt(info[0]);
        nbEndpoint = Integer.parseInt(info[1]);
        nbDescri = Integer.parseInt(info[2]);
        nbCache = Integer.parseInt(info[3]);
        tailleCache = Integer.parseInt(info[4]);
    }

    /**
     * Fonction permettant d'ajouter les video (id & taille) a la liste de video
     *
     * @param ligne
     * @throws IOException
     */
    private static VideoHolder getAllVideo(String ligne) throws IOException {
        String[] vid = ligne.split(" ");
        VideoHolder videoHolder = new VideoHolder();
        for (int i = 0; i < vid.length; i++) {
            videoHolder.add(new Video(i, Integer.parseInt(vid[i])));
        }
        return videoHolder;
    }

    /**
     * Fonction donnant la latence de chacun des Endpoint par rapports aux caches, et au serveur.
     *
     * @param br liste d'entrée
     * @return liste d'entrée (sur la bonne ligne pour la suite)
     * @throws IOException
     */
    private static void getLatence(BufferedReader br,ControllerState controllerState) throws IOException {

        CacheHolder caches = controllerState.getCaches();
        HashMap<EndPoint,Integer> endPoints;

        for (int i = 0; i < nbEndpoint; i++) {
            String ligne = br.readLine();
            String[] latPoint = ligne.split(" ");

            int latServ = Integer.parseInt(latPoint[0]);
            int coCache = Integer.parseInt(latPoint[1]);

            EndPoint endpoint = new EndPoint(i, latServ);
            HashMap cacheConnected = endpoint.getCacheConnected();

            for (int j = 0; j < coCache; j++) {
                ligne = br.readLine();
                latPoint = ligne.split(" ");
                Cache cache = new Cache(Integer.parseInt(latPoint[0]),tailleCache);

                if(caches.addCache(cache)){
                    endPoints = new HashMap<EndPoint,Integer> ();
                    cacheConnected.put(cache, Integer.parseInt(latPoint[1]));
                }else{
                    cache = caches.getCacheById(Integer.parseInt(latPoint[0]));
                    endPoints = cache.getEndPoints();
                    cacheConnected.put(cache, Integer.parseInt(latPoint[1]));
                }
                endPoints.put(endpoint,Integer.parseInt(latPoint[1]));
                cache.setEndPoints(endPoints);
            }

            controllerState.getEndPoints().add(endpoint);
        }
    }

    /**
     * Fonction donnant le nombre de requête pour une video, pour chaque endpoint
     *
     * @param br liste d'entrée
     * @throws IOException
     */
    private static void getRequestVideo(BufferedReader br, ControllerState controllerState) throws IOException {
        String ligne = br.readLine();
        Video video;
        EndPoint endPoint;
        int nbRequest;

        while (ligne != null) {

            String[] splitLigne = ligne.split(" ");

            video = controllerState.getVideoHolder().getVideo(Integer.parseInt(splitLigne[0]));
            endPoint = controllerState.getEndPoint(Integer.parseInt(splitLigne[1]));
            nbRequest = Integer.parseInt(splitLigne[2]);

            video.setNbRequestTotal(video.getNbRequestTotal() + nbRequest);
            Request req = new Request(video, endPoint, nbRequest);
            endPoint.addRequest(req);

            ligne = br.readLine();
        }

    }

}


