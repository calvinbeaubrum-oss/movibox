package com.applovin.impl.mediation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.applovin.impl.ge;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdWaterfallInfo;
import com.applovin.mediation.MaxNetworkResponseInfo;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class MaxAdWaterfallInfoImpl implements MaxAdWaterfallInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ge f20671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f20672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f20673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f20674d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f20675e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f20676f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f20677g;

    public MaxAdWaterfallInfoImpl(ge geVar, long j11, List<MaxNetworkResponseInfo> list, String str) {
        this(geVar, geVar.Y(), geVar.Z(), j11, list, geVar.X(), str);
    }

    public MaxAdWaterfallInfoImpl(@Nullable ge geVar, String str, String str2, long j11, List<MaxNetworkResponseInfo> list, List<String> list2, String str3) {
        this.f20671a = geVar;
        this.f20672b = str;
        this.f20673c = str2;
        this.f20674d = list;
        this.f20675e = j11;
        this.f20676f = list2;
        this.f20677g = str3;
    }

    @Override // com.applovin.mediation.MaxAdWaterfallInfo
    public long getLatencyMillis() {
        return this.f20675e;
    }

    @Override // com.applovin.mediation.MaxAdWaterfallInfo
    public MaxAd getLoadedAd() {
        return this.f20671a;
    }

    public String getMCode() {
        return this.f20677g;
    }

    @Override // com.applovin.mediation.MaxAdWaterfallInfo
    public String getName() {
        return this.f20672b;
    }

    @Override // com.applovin.mediation.MaxAdWaterfallInfo
    public List<MaxNetworkResponseInfo> getNetworkResponses() {
        return this.f20674d;
    }

    public List<String> getPostbackUrls() {
        return this.f20676f;
    }

    @Override // com.applovin.mediation.MaxAdWaterfallInfo
    public String getTestName() {
        return this.f20673c;
    }

    @NonNull
    public String toString() {
        return "MaxAdWaterfallInfo{name=" + this.f20672b + ", testName=" + this.f20673c + ", networkResponses=" + this.f20674d + ", latencyMillis=" + this.f20675e + '}';
    }
}
