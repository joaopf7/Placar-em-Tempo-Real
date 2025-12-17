package com.exemplo.placar.messaging;

import com.exemplo.placar.realtime.SseBroadcasterService;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import redis.clients.jedis.Jedis;
@Startup
@Singleton
public class PlacarConsumer {

    @Inject
    private SseBroadcasterService broadcaster;

    public void iniciarConsumer() {
        try {
            Channel channel = RabbitMQConfig.getChannel();
            channel.queueDeclare(RabbitMQConfig.getQueue(), false, false, false, null);

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String mensagem = new String(delivery.getBody(), "UTF-8");
                System.out.println("RabbitMQ recebeu: " + mensagem);

                // 🔴 Redis continua (opcional)
                try (Jedis jedis = RedisConfig.getJedis()) {
                    jedis.publish(RedisConfig.getChannel(), mensagem);
                }

                // 🟢 SSE em tempo real
                broadcaster.broadcast(mensagem);
            };

            channel.basicConsume(RabbitMQConfig.getQueue(), true, deliverCallback, consumerTag -> {});

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
