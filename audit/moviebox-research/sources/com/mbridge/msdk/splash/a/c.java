package com.mbridge.msdk.splash.a;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.z;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f46956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f46957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f46958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f46959d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f46960e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f46961f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f46962g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f46963h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f46964i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f46965j;

    private c() {
    }

    public static c a() {
        return new c();
    }

    public final c a(String str) {
        this.f46956a = str;
        return this;
    }

    public final c a(boolean z11) {
        this.f46964i = z11;
        return this;
    }

    public final void a(int i11) {
        this.f46965j = i11;
    }

    public final c b(int i11) {
        this.f46963h = i11;
        return this;
    }

    public final c b(String str) {
        this.f46957b = str;
        return this;
    }

    public final String b() {
        StringBuilder sb2 = new StringBuilder();
        if (!TextUtils.isEmpty(this.f46957b)) {
            sb2.append("unit_id=");
            sb2.append(this.f46957b);
            sb2.append("&");
        }
        if (!TextUtils.isEmpty(this.f46958c)) {
            sb2.append("cid=");
            sb2.append(this.f46958c);
            sb2.append("&");
        }
        if (!TextUtils.isEmpty(this.f46959d)) {
            sb2.append("rid=");
            sb2.append(this.f46959d);
            sb2.append("&");
        }
        if (!TextUtils.isEmpty(this.f46960e)) {
            sb2.append("rid_n=");
            sb2.append(this.f46960e);
            sb2.append("&");
        }
        if (!TextUtils.isEmpty(this.f46961f)) {
            sb2.append("creative_id=");
            sb2.append(this.f46961f);
            sb2.append("&");
        }
        if (!TextUtils.isEmpty(this.f46962g)) {
            sb2.append("reason=");
            sb2.append(this.f46962g);
            sb2.append("&");
        }
        if (this.f46963h != 0) {
            sb2.append("result=");
            sb2.append(this.f46963h);
            sb2.append("&");
        }
        if (this.f46964i) {
            sb2.append("hb=1");
            sb2.append("&");
        }
        if (this.f46965j != 0) {
            sb2.append("close_type=");
            sb2.append(this.f46965j);
            sb2.append("&");
        }
        sb2.append("network_type=");
        sb2.append(z.l(com.mbridge.msdk.foundation.controller.c.m().c()));
        sb2.append("&");
        if (!TextUtils.isEmpty(this.f46956a)) {
            sb2.append("key=");
            sb2.append(this.f46956a);
        }
        return sb2.toString();
    }

    public final c c(String str) {
        this.f46958c = str;
        return this;
    }

    public final c d(String str) {
        this.f46959d = str;
        return this;
    }

    public final c e(String str) {
        this.f46961f = str;
        return this;
    }

    public final c f(String str) {
        this.f46962g = str;
        return this;
    }

    public final c g(String str) {
        this.f46960e = str;
        return this;
    }
}
