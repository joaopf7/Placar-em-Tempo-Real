package com.exemplo.placar.messaging;

import com.rabbitmq.client.Channel;

import redis.clients.jedis.Jedis;

public class PlacarProducer {

    public void enviarAtualizacao(String mensagem) {
        try {
            // RabbitMQ
            Channel channel = RabbitMQConfig.getChannel();
            channel.queueDeclare(RabbitMQConfig.getQueue(), false, false, false, null);
            channel.basicPublish("", RabbitMQConfig.getQueue(), null, mensagem.getBytes());
            channel.close();

            // Redis (pub/sub)
            try (Jedis jedis = RedisConfig.getJedis()) {
                jedis.publish(RedisConfig.getChannel(), mensagem);
            }

            System.out.println("Mensagem enviada: " + mensagem);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
