package com.google.common.util.concurrent;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface v extends ScheduledExecutorService, u {
    @Override // java.util.concurrent.ScheduledExecutorService
    t<?> schedule(Runnable runnable, long j11, TimeUnit timeUnit);

    @Override // java.util.concurrent.ScheduledExecutorService
    t<?> scheduleWithFixedDelay(Runnable runnable, long j11, long j12, TimeUnit timeUnit);
}
