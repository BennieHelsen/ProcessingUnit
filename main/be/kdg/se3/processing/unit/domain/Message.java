package be.kdg.se3.processing.unit.domain;

import java.util.Date;

/**
 * Created by benniehelsen on 3/11/15.
 */
public class Message {
    private final String centralId;
    private final String delay;
    private final String distanceToLoadingDock;
    private final String shipId;
    private Date timestamp;

    public Message(MessageDTO messageDTO) {
        this.centralId = messageDTO.getCentralId();
        this.delay = messageDTO.getDelay();
        this.distanceToLoadingDock = messageDTO.getDistanceToLoadingDock();
        this.shipId = messageDTO.getShipId();
        this.timestamp = messageDTO.getTimestamp();
    }
}
