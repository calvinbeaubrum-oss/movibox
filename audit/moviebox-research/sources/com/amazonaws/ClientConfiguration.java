package com.amazonaws;

import com.amazonaws.retry.PredefinedRetryPolicies;
import com.amazonaws.retry.RetryPolicy;
import com.amazonaws.util.VersionInfoUtils;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import javax.net.ssl.TrustManager;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ClientConfiguration {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f15617u = VersionInfoUtils.b();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final RetryPolicy f15618v = PredefinedRetryPolicies.f15905b;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f15620b;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f15635q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f15619a = f15617u;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f15621c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RetryPolicy f15622d = f15618v;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Protocol f15623e = Protocol.HTTPS;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f15624f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f15625g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f15626h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f15627i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Deprecated
    public String f15628j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Deprecated
    public String f15629k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f15630l = 10;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f15631m = DefaultLoadControl.DEFAULT_MIN_BUFFER_MS;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f15632n = DefaultLoadControl.DEFAULT_MIN_BUFFER_MS;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f15633o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f15634p = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public TrustManager f15636r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f15637s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f15638t = false;

    public int a() {
        return this.f15632n;
    }

    public int b() {
        return this.f15621c;
    }

    public Protocol c() {
        return this.f15623e;
    }

    public RetryPolicy d() {
        return this.f15622d;
    }

    public String e() {
        return this.f15635q;
    }

    public int f() {
        return this.f15631m;
    }

    public TrustManager g() {
        return this.f15636r;
    }

    public String h() {
        return this.f15619a;
    }

    public String i() {
        return this.f15620b;
    }

    public boolean j() {
        return this.f15637s;
    }

    public boolean k() {
        return this.f15638t;
    }
}
