package com.cloud.tmc.integration.defaultImpl;

import android.content.Context;
import com.cloud.tmc.integration.proxy.PerformanceProxy;
import com.cloud.tmc.kernel.proxy.perf.IPerformanceAndErrorTracker;
import xc.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TmcPerformanceAndErrorTracker implements IPerformanceAndErrorTracker {
    @Override // com.cloud.tmc.kernel.proxy.perf.IPerformanceAndErrorTracker
    public void sendErr(Context context, a aVar) {
    }

    @Override // com.cloud.tmc.kernel.proxy.perf.IPerformanceAndErrorTracker
    public void sendPerf(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(str2);
    }

    @Override // com.cloud.tmc.kernel.proxy.perf.IPerformanceAndErrorTracker
    public void sendPerfStageLog(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(str2);
        ((PerformanceProxy) tc.a.a(PerformanceProxy.class)).sendPerfStageLog(str, str2);
    }

    @Override // com.cloud.tmc.kernel.proxy.perf.IPerformanceAndErrorTracker
    public void sendPerfV2(String str) {
        ((PerformanceProxy) tc.a.a(PerformanceProxy.class)).sendPerfV2(str);
    }
}
