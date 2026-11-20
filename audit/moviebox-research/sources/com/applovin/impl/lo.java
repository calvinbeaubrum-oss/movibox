package com.applovin.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class lo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f20487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f20488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f20489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f20490d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f20491e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f9 f20492f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f20493g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long[] f20494h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long[] f20495i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f20496j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final mo[] f20497k;

    public lo(int i11, int i12, long j11, long j12, long j13, f9 f9Var, int i13, mo[] moVarArr, int i14, long[] jArr, long[] jArr2) {
        this.f20487a = i11;
        this.f20488b = i12;
        this.f20489c = j11;
        this.f20490d = j12;
        this.f20491e = j13;
        this.f20492f = f9Var;
        this.f20493g = i13;
        this.f20497k = moVarArr;
        this.f20496j = i14;
        this.f20494h = jArr;
        this.f20495i = jArr2;
    }

    public mo a(int i11) {
        mo[] moVarArr = this.f20497k;
        if (moVarArr == null) {
            return null;
        }
        return moVarArr[i11];
    }
}
