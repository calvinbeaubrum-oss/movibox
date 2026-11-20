package com.cloud.tmc.kernel.proxy.performanceanalyse;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface ICommunicationTimeProxy {
    void clear(String str);

    int getTotalNum(String str);

    long getTotalTime(String str);

    void plusNum(String str, int i11);

    void plusTime(String str, long j11);
}
