package org.jxch.study.studyspringcloud.core;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

class NettyTimerTest {

    @Test
    void addTask() throws InterruptedException {
        NettyTimer nettyTimer = new NettyTimer(1, 7);
        nettyTimer.addTimerTask((timeout) -> System.out.println("Hello World!"), 1, TimeUnit.SECONDS);
        Thread.currentThread().join();
    }

    @Test
    void stop() {
    }
}