package be.kdg.se3.processing.unit.domain;

import java.util.Date;

/**
 * Created by benniehelsen on 3/11/15.
 */
public class MessageDTO {
    private String centralId;
    private String delay;
    private String distanceToLoadingDock;
    private String shipId;
    private Date timestamp;

    public MessageDTO() {

    }

    public String getCentralId() {
        return centralId;
    }

    public String getDelay() {
        return delay;
    }

    public String getDistanceToLoadingDock() {
        return distanceToLoadingDock;
    }

    public String getShipId() {
        return shipId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setCentralId(String centralId) {
        this.centralId = centralId;
    }

    public void setDelay(String delay) {
        this.delay = delay;
    }

    public void setDistanceToLoadingDock(String distanceToLoadingDock) {
        this.distanceToLoadingDock = distanceToLoadingDock;
    }

    public void setShipId(String shipId) {
        this.shipId = shipId;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }


    @Override
    public String toString() {
        return "MessageDTO{" +
                "centralId='" + centralId + '\'' +
                ", delay='" + delay + '\'' +
                ", distanceToLoadingDock='" + distanceToLoadingDock + '\'' +
                ", shipId='" + shipId + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
