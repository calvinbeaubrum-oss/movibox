package com.applovin.impl;

import android.content.Context;
import android.util.SparseArray;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i6 implements de {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i5.a f19629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SparseArray f19630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int[] f19631c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f19632d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f19633e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f19634f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f19635g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f19636h;

    public i6(Context context, o8 o8Var) {
        this(new v5.a(context), o8Var);
    }

    public i6(i5.a aVar, o8 o8Var) {
        this.f19629a = aVar;
        SparseArray sparseArrayA = a(aVar, o8Var);
        this.f19630b = sparseArrayA;
        this.f19631c = new int[sparseArrayA.size()];
        for (int i11 = 0; i11 < this.f19630b.size(); i11++) {
            this.f19631c[i11] = this.f19630b.keyAt(i11);
        }
        this.f19632d = C.TIME_UNSET;
        this.f19633e = C.TIME_UNSET;
        this.f19634f = C.TIME_UNSET;
        this.f19635g = -3.4028235E38f;
        this.f19636h = -3.4028235E38f;
    }

    private static SparseArray a(i5.a aVar, o8 o8Var) {
        SparseArray sparseArray = new SparseArray();
        try {
            sparseArray.put(0, (de) Class.forName("com.applovin.exoplayer2.source.dash.DashMediaSource$Factory").asSubclass(de.class).getConstructor(i5.a.class).newInstance(aVar));
        } catch (Exception unused) {
        }
        try {
            sparseArray.put(1, (de) Class.forName("com.applovin.exoplayer2.source.smoothstreaming.SsMediaSource$Factory").asSubclass(de.class).getConstructor(i5.a.class).newInstance(aVar));
        } catch (Exception unused2) {
        }
        try {
            sparseArray.put(2, (de) Class.forName("com.applovin.exoplayer2.source.hls.HlsMediaSource$Factory").asSubclass(de.class).getConstructor(i5.a.class).newInstance(aVar));
        } catch (Exception unused3) {
        }
        try {
            sparseArray.put(3, (de) Class.forName("com.applovin.exoplayer2.source.rtsp.RtspMediaSource$Factory").asSubclass(de.class).getConstructor(new Class[0]).newInstance(new Object[0]));
        } catch (Exception unused4) {
        }
        sparseArray.put(4, new bi.b(aVar, o8Var));
        return sparseArray;
    }
}
