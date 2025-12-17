package com.exemplo.placar.messaging;

import redis.clients.jedis.Jedis;

public class RedisConfig {

    private static final String HOST = "localhost"; // IP do servidor Redis
    private static final int PORT = 6379;
    private static final String CHANNEL = "placarChannel";

    public static Jedis getJedis() {
        return new Jedis(HOST, PORT);
    }

    public static String getChannel() {
        return CHANNEL;
    }
}
