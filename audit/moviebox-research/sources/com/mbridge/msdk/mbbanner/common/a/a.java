package com.mbridge.msdk.mbbanner.common.a;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.z;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f45248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f45249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f45250c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f45251d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f45252e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f45253f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f45254g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f45255h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f45256i;

    private a() {
    }

    public static a a() {
        return new a();
    }

    public final a a(int i11) {
        this.f45255h = i11;
        return this;
    }

    public final a a(String str) {
        this.f45248a = str;
        return this;
    }

    public final a a(boolean z11) {
        this.f45256i = z11;
        return this;
    }

    public final a b(String str) {
        this.f45249b = str;
        return this;
    }

    public final String b() {
        StringBuilder sb2 = new StringBuilder();
        if (!TextUtils.isEmpty(this.f45249b)) {
            sb2.append("unit_id=");
            sb2.append(this.f45249b);
            sb2.append("&");
        }
        if (!TextUtils.isEmpty(this.f45250c)) {
            sb2.append("cid=");
            sb2.append(this.f45250c);
            sb2.append("&");
        }
        if (!TextUtils.isEmpty(this.f45251d)) {
            sb2.append("rid=");
            sb2.append(this.f45251d);
            sb2.append("&");
        }
        if (!TextUtils.isEmpty(this.f45252e)) {
            sb2.append("rid_n=");
            sb2.append(this.f45252e);
            sb2.append("&");
        }
        if (!TextUtils.isEmpty(this.f45253f)) {
            sb2.append("creative_id=");
            sb2.append(this.f45253f);
            sb2.append("&");
        }
        if (!TextUtils.isEmpty(this.f45254g)) {
            sb2.append("reason=");
            sb2.append(this.f45254g);
            sb2.append("&");
        }
        if (this.f45255h != 0) {
            sb2.append("result=");
            sb2.append(this.f45255h);
            sb2.append("&");
        }
        if (this.f45256i) {
            sb2.append("hb=1");
            sb2.append("&");
        }
        sb2.append("network_type=");
        sb2.append(z.l(com.mbridge.msdk.foundation.controller.c.m().c()));
        sb2.append("&");
        if (!TextUtils.isEmpty(this.f45248a)) {
            sb2.append("key=");
            sb2.append(this.f45248a);
        }
        return sb2.toString();
    }

    public final a c(String str) {
        this.f45250c = str;
        return this;
    }

    public final a d(String str) {
        this.f45251d = str;
        return this;
    }

    public final a e(String str) {
        this.f45252e = str;
        return this;
    }

    public final a f(String str) {
        this.f45253f = str;
        return this;
    }

    public final a g(String str) {
        this.f45254g = str;
        return this;
    }
}
