package be.kdg.se3.processing.unit.adapters.in;

import be.kdg.se3.processing.unit.domain.MessageDTO;
import com.rabbitmq.client.*;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/**
 * Make a connection with the domain broker RabbitMQ and get messages from a queue
 * @author benniehelsen
 */
public class RabbitMQ {
    private final static String QUEUE_NAME = "messagebroker";
    private final static String HOST = "localhost";
    private static Connection connection;

    public RabbitMQ() {
        this.init();
    }

    private void init() {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost(HOST);
            this.connection = factory.newConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
    }

    public void readMessagesFromQueue() {
        this.readMessagesFromQueue(this.QUEUE_NAME);
    }

    public void readMessagesFromQueue(String queue) {
        Channel channel = null;
        try {
            channel = this.connection.createChannel();
            channel.queueDeclare(queue, false, false, false, null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");

                Reader reader = new StringReader(message);


                MessageDTO messageDTO = null;
                try {


                  messageDTO= (MessageDTO) Unmarshaller.unmarshal(MessageDTO.class, reader);
                } catch (MarshalException | ValidationException e) {
                    e.printStackTrace();
                }

                System.out.println(messageDTO.toString());

            /*    System.out.println(" [x] Received '" + messageDTO.get() + "' '" + messageDTO.getTimestamp() + "' '"
                    + messageDTO.getDelay() + "' '" + messageDTO.getDistancetoloadingdock() + "' '" + messageDTO.getShipid() + "'");
            */
            }
        };

        try {
            channel.basicConsume(queue, true, consumer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
