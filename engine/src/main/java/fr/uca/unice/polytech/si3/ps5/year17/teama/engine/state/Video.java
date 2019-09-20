package fr.uca.unice.polytech.si3.ps5.year17.teama.engine.state;

import java.util.Objects;

public class Video {
    private int id;
    private int size;
    private int nbRequestTotal;

    public Video(int id, int size){
        this.id = id;
        this.size = size;
        this.nbRequestTotal = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Video video = (Video) o;
        return id == video.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNbRequestTotal() {
        return nbRequestTotal;
    }

    public void setNbRequestTotal(int nbRequestTotal) {
        this.nbRequestTotal = nbRequestTotal;
    }
}
