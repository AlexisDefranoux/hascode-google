package fr.uca.unice.polytech.si3.ps5.year17.teama.visualiser;

import java.io.*;


public class Main {

    private String pathDataIn;
    private String pathResult;
    private String [] pathDataOut;
    private String [] pathScoreOut;
    private String pathNewStript;

    private int nbcaches;
    private int [][] tab;
    private int maxcache;
    private int [] sizevideos;
    private int nbfile;

    Main(String[] args) throws IOException {

        pathDataIn = args[0];
        pathDataOut = args[1].split(";");
        pathScoreOut = args[2].split(";");
        pathResult = args[3];
        pathNewStript = args[4];

        nbfile = Math.min(pathDataOut.length, pathScoreOut.length);
        String pathStructScriptR = "src/main/java/fr/uca/unice/polytech/si3/ps5/year17/teama/visualiser/structurescript/scriptStruct.r";

        //structure du script
        BufferedReader scriptscore = new BufferedReader(new FileReader(new File(pathStructScriptR)));

        //On cree le ficher script.r
        BufferedWriter myscriptscore = new BufferedWriter(new FileWriter(new File(pathNewStript + "/script.r")));

        if (nbfile==0) {
            myscriptscore.close();
            return;
        }

        //On explore tout le fichier et on remplace
        String line = scriptscore.readLine();
        while (line != null) {
            line = line.replaceFirst("<score>", renplaceScoreTime(false));
            line = line.replaceFirst("<time>", renplaceScoreTime(true));
            line = line.replaceFirst("<pourc>", replacePourc());
            line = line.replaceFirst("<nbstrat>", String.valueOf(nbfile));
            line = line.replaceFirst("<label>", replaceLabel());
            line = line.replaceFirst("<path>", "'" + pathNewStript + "'");
            myscriptscore.write(line+ "\n");
            line = scriptscore.readLine();
        }

        myscriptscore.flush();
        myscriptscore.close();
        scriptscore.close();
    }

    private String replacePourc() throws IOException {
        String s = "c(";
        for (int i=0; i<nbfile-1; i++) {
            s += takePourc(i) + ", ";
        }
        return s + takePourc(nbfile-1) + ")";
    }

    private int takePourc(int id) throws IOException {
        //fichier de sortie
        BufferedReader output = new BufferedReader(new FileReader(new File(pathDataOut[id])));

        //fichier data.in
        BufferedReader datain = new BufferedReader(new FileReader(new File(pathDataIn)));
        String[] line1 = datain.readLine().split(" ");
        maxcache = Integer.parseInt(line1[line1.length -1]);
        int nbvideos = Integer.parseInt(line1[0]);

        sizevideos = new int [nbvideos];
        String[] line2 = datain.readLine().split(" ");
        for (int i=0; i<nbvideos; i++)
            sizevideos[i] = Integer.parseInt(line2[i]);

        datain.close();

        mydata(output); //on enregistre la data dans tab
        int [] videos = getDataVideos(); //la taille de toutes les vidéos pour chaque cache
        int [] prop = getProportion(); //l'utilisation de chaque cache en %

        if(nbcaches == 0) {
            return 0;
        }

        int dataallvideos=0;
        for (int i=0; i<nbcaches; i++)
            dataallvideos += 100*videos[i];

        int dataallcaches = maxcache * nbcaches;

        return dataallvideos/dataallcaches;
    }

    /**
     * Donne le string qui va remplacer <label> dans scriptscore.r
     * @return
     */
    private String replaceLabel() {
        String s = "c(";
        for (int i=1; i< nbfile; i++)
            s += "'Strategie " + i + "', ";
        s += "'Strategie " + (nbfile) + "')";
        return s;
    }

    /**
     * Si time est vrai : donne le temps pour chaque strategie a partir des fichiers
     * Si time est faux : donne le score pour chaque strategie a partir des fichiers
     * @param time
     * @return
     * @throws IOException
     */
    private String renplaceScoreTime(boolean time) throws IOException {
        String s ="c(";

        double [] individualscore = new double[nbfile];
        BufferedReader timebr = new BufferedReader(new FileReader(new File(pathResult)));
        for (int j=0; j < nbfile; j++) {
            if (time) {
                String line = timebr.readLine();
                while (!line.contains("\"score\" : "))
                    line = timebr.readLine();
                String[] strings = line.split(" ");
                line = (strings[strings.length - 1]).replaceAll(",", "");
                individualscore[j] = Double.parseDouble(line);

            } else {
                BufferedReader scorebr = new BufferedReader(new FileReader(new File(pathScoreOut[j])));
                individualscore[j] = Integer.parseInt(scorebr.readLine());
            }
        }



        double [] individualscore2 = (double[])individualscore.clone();
        for (int j=0; j<nbfile-1; j++)
            s += individualscore2[j] + ", ";

        s += individualscore[nbfile-1] + ")";

        return s;
    }

    /**
     * Enregistre les donnees du fichier output dans l'attribut tab
     * @param output
     * @throws IOException
     */
    private void mydata (BufferedReader output) throws IOException {
        String line = output.readLine();
        nbcaches = Integer.parseInt(line);
        tab = new int[nbcaches][1000];
        for (int i=0;i<nbcaches;i++)
            for (int j=0;j<1000;j++)
                tab[i][j] = -1;
        int compt = 0;
        line = output.readLine();
        while (line != null) {
            String[] list = line.split(" ");
            int length = list.length;
            for (int compt2 = 1; compt2 < length; compt2++) {
                int value = Integer.parseInt(list[compt2]);
                tab[compt][compt2-1] = value;
            }
            line = output.readLine();
            compt++;
        }

    }

    private int [] getDataVideos() {
        int [] datavideos = new int[nbcaches];
        for (int i=0; i<nbcaches; i++) {
            int counter = 0;
            while (tab[i][counter] != -1) {
                int size = sizevideos[tab[i][counter]];
                datavideos[i] += size;
                counter++;
            }
        }
        return datavideos;
    }

    private int [] getProportion() {
        int [] proportion = getDataVideos();
        for (int i=0; i<nbcaches; i++) {
            proportion[i] *= 100;
            proportion[i] /= maxcache;
        }
        return proportion;
    }

    public static void main( String[] args ) throws IOException {
        new Main(args);
    }
}
