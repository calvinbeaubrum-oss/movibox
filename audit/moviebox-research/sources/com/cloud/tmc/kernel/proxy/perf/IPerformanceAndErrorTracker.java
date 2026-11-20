package com.cloud.tmc.kernel.proxy.perf;

import android.content.Context;
import xc.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface IPerformanceAndErrorTracker {
    void sendErr(Context context, a aVar);

    void sendPerf(String str, String str2);

    void sendPerfStageLog(String str, String str2);

    void sendPerfV2(String str);
}
