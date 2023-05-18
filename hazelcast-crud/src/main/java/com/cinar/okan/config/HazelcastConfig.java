package com.cinar.okan.config;


import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.ClientNetworkConfig;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration


public class HazelcastConfig {



//@Bean gerekli. Şuan yml dosyası bu işlevi görüyor.
    public HazelcastInstance hazelcastInstance() {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.setNetworkConfig(new ClientNetworkConfig().addAddress("localhost:5701"));
        return HazelcastClient.newHazelcastClient(clientConfig);
    }




}

