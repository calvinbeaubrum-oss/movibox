package com.cloud.tmc.miniapp.performanceanalyse;

import android.os.Bundle;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class PerformanceTrackNoop implements PerformanceAnalyseProxy {
    @Override // com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy
    public void record(String str, c cVar, String str2) {
    }

    @Override // com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy
    public void record(String str, c cVar, String str2, Bundle bundle) {
    }

    @Override // com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy
    public void recordForAd(String str, String str2, String str3, Bundle bundle) {
    }

    @Override // com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy
    public void recordForCommon(String str, String str2, Bundle bundle) {
    }
}
