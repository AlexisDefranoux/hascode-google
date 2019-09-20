package fr.uca.unice.polytech.si3.ps5.year17.teama.engine;

import fr.uca.unice.polytech.si3.ps5.year17.teama.engine.state.Cache;
import fr.uca.unice.polytech.si3.ps5.year17.teama.engine.state.Video;

import java.io.*;

public class OutPut {

    /**
     * Rempli le fichier output à partir du controller
     * @param controllerState la structure
     * @param f le path du fichier output
     * @throws IOException
     */
    public static void outPutFile(ControllerState controllerState, File f) throws IOException {

        FileWriter fr = new FileWriter(f);

        int nbCaches = 0;
        String fichier = "";

        for(Cache cache : controllerState.getCaches()){

            if(cache.getSizeCurrent() != 0){

                fichier = fichier + "\r\n" + cache.getId();
                nbCaches++;
                for(Video video : cache.getVideoholder()){
                    fichier = fichier + " " + video.getId();
                }
            }
        }

        fichier = nbCaches + fichier;
        fr.write(fichier);

        fr.flush();
        fr.close();

    }
}
