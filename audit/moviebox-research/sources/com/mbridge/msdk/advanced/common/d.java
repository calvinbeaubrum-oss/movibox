package com.mbridge.msdk.advanced.common;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.z;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f42812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f42813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f42814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f42815d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f42816e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f42817f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f42818g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f42819h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f42820i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f42821j;

    private d() {
    }

    public static d a() {
        return new d();
    }

    public final d a(String str) {
        this.f42812a = str;
        return this;
    }

    public final d a(boolean z11) {
        this.f42820i = z11;
        return this;
    }

    public final void a(int i11) {
        this.f42821j = i11;
    }

    public final d b(int i11) {
        this.f42819h = i11;
        return this;
    }

    public final d b(String str) {
        this.f42813b = str;
        return this;
    }

    public final String b() {
        StringBuilder sb2 = new StringBuilder();
        if (!TextUtils.isEmpty(this.f42813b)) {
            sb2.append("unit_id=");
            sb2.append(this.f42813b);
            sb2.append("&");
        }
        if (!TextUtils.isEmpty(this.f42814c)) {
            sb2.append("cid=");
            sb2.append(this.f42814c);
            sb2.append("&");
        }
        if (!TextUtils.isEmpty(this.f42815d)) {
            sb2.append("rid=");
            sb2.append(this.f42815d);
            sb2.append("&");
        }
        if (!TextUtils.isEmpty(this.f42816e)) {
            sb2.append("rid_n=");
            sb2.append(this.f42816e);
            sb2.append("&");
        }
        if (!TextUtils.isEmpty(this.f42817f)) {
            sb2.append("creative_id=");
            sb2.append(this.f42817f);
            sb2.append("&");
        }
        if (!TextUtils.isEmpty(this.f42818g)) {
            sb2.append("reason=");
            sb2.append(this.f42818g);
            sb2.append("&");
        }
        if (this.f42819h != 0) {
            sb2.append("result=");
            sb2.append(this.f42819h);
            sb2.append("&");
        }
        if (this.f42820i) {
            sb2.append("hb=1");
            sb2.append("&");
        }
        if (this.f42821j != 0) {
            sb2.append("close_type=");
            sb2.append(this.f42821j);
            sb2.append("&");
        }
        sb2.append("network_type=");
        sb2.append(z.l(com.mbridge.msdk.foundation.controller.c.m().c()));
        sb2.append("&");
        if (!TextUtils.isEmpty(this.f42812a)) {
            sb2.append("key=");
            sb2.append(this.f42812a);
        }
        return sb2.toString();
    }

    public final d c(String str) {
        this.f42814c = str;
        return this;
    }

    public final d d(String str) {
        this.f42815d = str;
        return this;
    }

    public final d e(String str) {
        this.f42817f = str;
        return this;
    }

    public final d f(String str) {
        this.f42818g = str;
        return this;
    }

    public final d g(String str) {
        this.f42816e = str;
        return this;
    }
}
