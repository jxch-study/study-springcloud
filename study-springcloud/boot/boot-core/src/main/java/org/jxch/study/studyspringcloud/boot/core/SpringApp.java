package org.jxch.study.studyspringcloud.boot.core;

import org.springframework.boot.web.server.WebServer;
import org.springframework.lang.NonNull;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import java.util.Map;

public class SpringApp {
    public static void run(Class<?> app, String[] args) {
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(app);
        applicationContext.refresh();

        WebServer webServer = getWebServer(applicationContext);
        webServer.start();
    }

    @NonNull
    private static WebServer getWebServer(@NonNull AnnotationConfigWebApplicationContext applicationContext) {
        Map<String, WebServer> webServers = applicationContext.getBeansOfType(WebServer.class);

        if (webServers.isEmpty()) {
            throw new NullPointerException("请引入WebServer的依赖，如Tomcat");
        } else if (webServers.size() > 1) {
            throw new IllegalArgumentException("只能保留一个WebServer");
        }

        return webServers.values().stream().findFirst().get();
    }
}
