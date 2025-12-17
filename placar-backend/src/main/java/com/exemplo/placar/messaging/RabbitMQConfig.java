package com.exemplo.placar.messaging;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitMQConfig {

    private static final String HOST = "localhost"; // ou IP do servidor RabbitMQ
    private static final String QUEUE = "placarQueue";

    public static Channel getChannel() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST);
        Connection connection = factory.newConnection();
        return connection.createChannel();
    }

    public static String getQueue() {
        return QUEUE;
    }
}
