package fr.uca.unice.polytech.si3.ps5.year17.teama.engine;

import fr.uca.unice.polytech.si3.ps5.year17.teama.engine.strategy.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class Main
{
    public static void main( String[] args ) throws IOException {

        int idStrategy = Integer.parseInt(args[0]);
        String pathDataIn = args[1];
        String pathDataOut = args[2];
        String pathScoreOut = args[3];

        File file = new File(pathDataIn);
        File fileDataOut = new File(pathDataOut);
        File fileScoreOut = new File(pathScoreOut);

        ControllerState controllerState = new ControllerState();
        controllerState = InputSplitter.Lecture(controllerState, file);

        useStrategy(idStrategy, controllerState);
        OutPut.outPutFile(controllerState, fileDataOut);
        int score = (int) Score.scoreFile(controllerState, fileScoreOut);

        System.out.println("Strategie "+ idStrategy +" fait un score de : " + score);
    }

    public static Strategy useStrategy(int idStrategy, ControllerState controllerState){
        Strategy strategy;
        switch (idStrategy){
            case 1 :
                strategy = new Strategy1(controllerState);
                break;
            case 2 :
                strategy = new Strategy2(controllerState);
                break;
            case 3 :
                strategy = new Strategy3(controllerState);
                break;
            case 4 :
                strategy = new Strategy4(controllerState);
                break;
            case 5 :
                strategy = new Strategy5(controllerState);
                break;
            case 6 :
                strategy = new Strategy6(controllerState);
                   break;
            case 7 :
                strategy = new Strategy7(controllerState);
                break;
            case 8 :
                strategy = new Strategy8(controllerState);
                break;
            default:
                strategy = new Strategy1(controllerState);
                System.out.println("Erreur: id stragegy introuvable.");
                break;
        }
        return strategy;
    }

}
