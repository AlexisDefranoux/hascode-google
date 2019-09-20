package fr.uca.unice.polytech.si3.ps5.year17.teama.engine;

import fr.uca.unice.polytech.si3.ps5.year17.teama.engine.state.EndPoint;
import fr.uca.unice.polytech.si3.ps5.year17.teama.engine.state.Request;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Score {

    /**
     * Met le score dans un fichier score
     * @param controllerState la structure
     * @param f le path du fichier score
     * @return le temps sauvé par la stratégie
     * @throws IOException
     */
    public static float scoreFile(ControllerState controllerState, File f) throws IOException {
        float timeSave = 0,
                nbRequestTotal = 0;

        for(EndPoint endPoint : controllerState.getEndPoints()){

            for(Request request : endPoint.getRequestHolder()){
                nbRequestTotal += (float) request.getNbRequestByEndPoint();
                timeSave += endPoint.getTimeSave(request.getVideo()) * request.getNbRequestByEndPoint();
            }
        }
        timeSave = (timeSave / nbRequestTotal) * 1000;

        if(f != null){

            FileWriter fr = new FileWriter(f);
            fr.write(((int)timeSave)+"");
            fr.flush();
            fr.close();
        }
        return timeSave;
    }
}
