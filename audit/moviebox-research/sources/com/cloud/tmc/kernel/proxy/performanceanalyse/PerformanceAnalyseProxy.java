package com.cloud.tmc.kernel.proxy.performanceanalyse;

import android.os.Bundle;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@zb.c("com.cloud.tmc.miniapp.performanceanalyse.PerformanceTrackNoop")
public interface PerformanceAnalyseProxy {
    void record(String str, c cVar, String str2);

    void record(String str, c cVar, String str2, @Nullable Bundle bundle);

    void recordForAd(String str, String str2, String str3, @Nullable Bundle bundle);

    void recordForCommon(String str, String str2, @Nullable Bundle bundle);
}
