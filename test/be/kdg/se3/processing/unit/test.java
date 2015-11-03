package be.kdg.se3.processing.unit;

import be.kdg.se3.processing.unit.adapters.in.RabbitMQ;

/**
 * Created by benniehelsen on 3/11/15.
 */
public class test {
    public static void main(String[] args) {
        RabbitMQ messageBroker = new RabbitMQ();
        messageBroker.readMessagesFromQueue();
    }
}
