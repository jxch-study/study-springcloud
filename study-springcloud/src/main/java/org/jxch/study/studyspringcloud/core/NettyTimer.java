package org.jxch.study.studyspringcloud.core;

import io.netty.util.HashedWheelTimer;
import io.netty.util.TimerTask;

import java.util.concurrent.TimeUnit;

public class NettyTimer {

    private final HashedWheelTimer timer;

    public NettyTimer(int tickDuration, int ticksPerWheel) {
        timer = new HashedWheelTimer(r -> new Thread(r,"HashedWheelTimer " + r.hashCode()),
                tickDuration, TimeUnit.MILLISECONDS, ticksPerWheel);
    }

    public void addTask(TimerTask task, long delay, TimeUnit unit) {
        timer.newTimeout(task, delay, unit);
    }

    public void addTimerTask(TimerTask task, long duration, TimeUnit unit) {
        timer.newTimeout((timeout) -> {
            task.run(timeout);
            addTimerTask(task, duration, unit);
        }, duration, unit);
    }

    public void stop() {
        timer.stop();
    }

}
