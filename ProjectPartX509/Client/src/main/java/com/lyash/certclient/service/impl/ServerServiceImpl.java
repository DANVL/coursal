package com.lyash.certclient.service.impl;

import com.lyash.certclient.service.ServerService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServerServiceImpl implements ServerService {

    public ServerServiceImpl() {
        javax.net.ssl.HttpsURLConnection
                .setDefaultHostnameVerifier((hostname, sslSession) -> hostname.equals("localhost"));
    }

    @Override
    public String getInfo() {
        System.setProperty("javax.net.ssl.keyStore", "/STUDIES/CoursalMatSpring/WORK/Project part" +
                "/ProjectPartX509/keystores/clientkeystore.p12");
        System.setProperty("javax.net.ssl.keyStorePassword", "password");
        System.setProperty("javax.net.ssl.trustStore", "/STUDIES/CoursalMatSpring/WORK/Project part/" +
                "ProjectPartX509/keystores/clienttruststore.p12");
        System.setProperty("javax.net.ssl.trustStorePassword", "password");

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://localhost:8080/api/info", String.class);
    }
}
