package fr.uca.unice.polytech.si3.ps5.year17.teama.engine.state;

import java.util.Objects;

public class Request {
    private Video video;
    private EndPoint endPoint;
    private int nbRequestByEndPoint;

    public Request(Video video, EndPoint endPoint, int nbRequestByEndPoint){
        this.video = video;
        this.endPoint = endPoint;
        this.nbRequestByEndPoint = nbRequestByEndPoint;
    }

    public int getNbRequestByEndPoint() {
        return nbRequestByEndPoint;
    }

    public void setNbRequestByEndPoint(int nbRequestByEndPoint) {
        this.nbRequestByEndPoint = nbRequestByEndPoint;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public EndPoint getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(EndPoint endPoint) {
        this.endPoint = endPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return Objects.equals(video, request.video) && Objects.equals(endPoint, request.endPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(video, endPoint);
    }
}
