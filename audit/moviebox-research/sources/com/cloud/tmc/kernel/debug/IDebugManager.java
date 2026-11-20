package com.cloud.tmc.kernel.debug;

import hc.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface IDebugManager {
    void addObserver(Object obj, a aVar);

    void notifyObserver();

    void removeObserver(Object obj);
}
