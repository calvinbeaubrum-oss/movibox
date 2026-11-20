package com.cloud.tmc.kernel.engine;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface EngineRouterManager {
    EngineRouter get(long j11);

    EngineRouter getByWorkerId(String str);

    EngineRouter remove(EngineRouter engineRouter);
}
