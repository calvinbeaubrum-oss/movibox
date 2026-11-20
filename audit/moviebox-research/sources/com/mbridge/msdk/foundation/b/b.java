package com.mbridge.msdk.foundation.b;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.x;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CopyOnWriteArrayList<CampaignEx> f43999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f44000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f44001c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f44002d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f44003e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f44004f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f44005g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f44006h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f44007i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f44008j;

    public final long a() {
        return this.f44008j;
    }

    public final void a(int i11) {
        this.f44003e = i11;
    }

    public final void a(long j11) {
        this.f44008j = j11;
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strA = x.a(str);
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        try {
            double d11 = Double.parseDouble(strA);
            if (d11 <= 0.0d) {
                return;
            }
            this.f44000b = d11;
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
        this.f43999a = copyOnWriteArrayList;
    }

    public final CopyOnWriteArrayList<CampaignEx> b() {
        return this.f43999a;
    }

    public final void b(int i11) {
        this.f44005g = i11;
    }

    public final void b(long j11) {
        this.f44006h = j11;
    }

    public final void b(String str) {
        this.f44001c = str;
    }

    public final double c() {
        return this.f44000b;
    }

    public final void c(long j11) {
        this.f44004f = j11;
    }

    public final void c(String str) {
        this.f44002d = str;
    }

    public final String d() {
        return this.f44001c;
    }

    public final void d(String str) {
        this.f44007i = str;
    }

    public final String e() {
        return this.f44002d;
    }

    public final int f() {
        return this.f44003e;
    }

    public final int g() {
        return this.f44005g;
    }

    public final long h() {
        return this.f44006h;
    }
}
