package com.applovin.impl;

import com.applovin.mediation.MaxError;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class yj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zj f24676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f24677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f24678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f24679d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MaxError f24680e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f24681f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f24682g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f24683h;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(yj yjVar);
    }

    private yj(zj zjVar, com.applovin.impl.mediation.g gVar, String str, MaxError maxError, long j11, long j12) {
        this(zjVar, str, maxError, j11, j12, gVar != null ? gVar.i() : null, gVar != null ? gVar.b() : null, false);
    }

    private yj(zj zjVar, String str, MaxError maxError, long j11, long j12, String str2, String str3, boolean z11) {
        this.f24676a = zjVar;
        this.f24679d = str;
        this.f24680e = maxError;
        this.f24681f = j11;
        this.f24682g = j12;
        this.f24677b = str2;
        this.f24678c = str3;
        this.f24683h = z11;
    }

    public static yj a(yj yjVar) {
        return new yj(yjVar.f(), yjVar.e(), yjVar.c(), yjVar.f24681f, yjVar.f24682g, yjVar.d(), yjVar.a(), true);
    }

    public static yj a(zj zjVar, com.applovin.impl.mediation.g gVar, MaxError maxError, long j11, long j12) {
        if (zjVar != null) {
            return new yj(zjVar, gVar, null, maxError, j11, j12);
        }
        throw new IllegalArgumentException("No spec specified");
    }

    public static yj a(zj zjVar, com.applovin.impl.mediation.g gVar, String str, long j11, long j12) {
        if (zjVar == null) {
            throw new IllegalArgumentException("No spec specified");
        }
        if (gVar != null) {
            return new yj(zjVar, gVar, str, null, j11, j12);
        }
        throw new IllegalArgumentException("No adapterWrapper specified");
    }

    public static yj a(zj zjVar, MaxError maxError) {
        return a(zjVar, (com.applovin.impl.mediation.g) null, maxError, -1L, -1L);
    }

    public String a() {
        return this.f24678c;
    }

    public long b() {
        return this.f24682g;
    }

    public MaxError c() {
        return this.f24680e;
    }

    public String d() {
        return this.f24677b;
    }

    public String e() {
        return this.f24679d;
    }

    public zj f() {
        return this.f24676a;
    }

    public boolean g() {
        return this.f24683h;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SignalCollectionResult{mSignalProviderSpec=");
        sb2.append(this.f24676a);
        sb2.append(", mSdkVersion='");
        sb2.append(this.f24677b);
        sb2.append('\'');
        sb2.append(", mAdapterVersion='");
        sb2.append(this.f24678c);
        sb2.append('\'');
        sb2.append(", mSignalDataLength='");
        String str = this.f24679d;
        sb2.append(str != null ? str.length() : 0);
        sb2.append('\'');
        sb2.append(", mErrorMessage=");
        MaxError maxError = this.f24680e;
        sb2.append(maxError != null ? maxError.getMessage() : "");
        sb2.append('}');
        return sb2.toString();
    }
}
