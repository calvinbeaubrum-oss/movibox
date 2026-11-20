package com.mbridge.msdk.foundation.c;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.out.MBridgeIds;
import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f44023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f44024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f44025c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Throwable f44026d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CampaignEx f44027e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private MBridgeIds f44028f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f44029g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f44030h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f44031i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f44032j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f44033k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private HashMap<Object, Object> f44034l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f44035m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f44036n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f44037o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f44038p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f44039q;

    public b(int i11) {
        this.f44023a = i11;
        this.f44024b = a.b(i11);
    }

    public b(int i11, int i12, String str) {
        if (TextUtils.isEmpty(str)) {
            this.f44025c = a.a(i12);
        } else {
            a("his_reason", str);
            this.f44025c = str;
        }
        this.f44035m = i11;
        this.f44024b = a.b(i12);
    }

    public b(int i11, String str) {
        this.f44023a = i11;
        if (!TextUtils.isEmpty(str)) {
            a("his_reason", str);
        }
        this.f44025c = str;
        this.f44024b = a.b(i11);
    }

    public final int a() {
        return this.f44023a;
    }

    public final Object a(Object obj) {
        HashMap<Object, Object> map = this.f44034l;
        if (map != null && map.containsKey(obj)) {
            return this.f44034l.get(obj);
        }
        return null;
    }

    public final void a(int i11) {
        this.f44024b = i11;
    }

    public final void a(CampaignEx campaignEx) {
        this.f44027e = campaignEx;
    }

    public final void a(MBridgeIds mBridgeIds) {
        this.f44028f = mBridgeIds;
    }

    public final void a(Object obj, Object obj2) {
        if (this.f44034l == null) {
            this.f44034l = new HashMap<>();
        }
        this.f44034l.put(obj, obj2);
    }

    public final void a(String str) {
        this.f44025c = str;
    }

    public final void a(Throwable th2) {
        this.f44026d = th2;
    }

    public final void a(boolean z11) {
        this.f44031i = z11;
    }

    public final String b() {
        int i11;
        String strA = !TextUtils.isEmpty(this.f44025c) ? this.f44025c : "";
        if (TextUtils.isEmpty(strA) && (i11 = this.f44023a) != -1) {
            strA = a.a(i11);
        }
        Throwable th2 = this.f44026d;
        if (th2 == null) {
            return strA;
        }
        String message = th2.getMessage();
        if (TextUtils.isEmpty(message)) {
            return strA;
        }
        return strA + " # " + message;
    }

    public final void b(int i11) {
        this.f44032j = i11;
    }

    public final void b(String str) {
        this.f44033k = str;
    }

    public final void b(boolean z11) {
        this.f44039q = z11;
    }

    public final CampaignEx c() {
        return this.f44027e;
    }

    public final void c(String str) {
        this.f44036n = str;
    }

    public final MBridgeIds d() {
        if (this.f44028f == null) {
            this.f44028f = new MBridgeIds();
        }
        return this.f44028f;
    }

    public final void d(String str) {
        this.f44037o = str;
    }

    public final void e(String str) {
        this.f44038p = str;
    }

    public final boolean e() {
        return this.f44031i;
    }

    public final int f() {
        return this.f44024b;
    }

    public final int g() {
        return this.f44032j;
    }

    public final String h() {
        return this.f44033k;
    }

    public final int i() {
        return this.f44035m;
    }

    public final String j() {
        return this.f44036n;
    }

    public final String k() {
        return this.f44037o;
    }

    public final String l() {
        return this.f44038p;
    }

    public final boolean m() {
        return this.f44039q;
    }

    public final String toString() {
        return "MBFailureReason{errorCode=" + this.f44023a + ", errorSubType=" + this.f44024b + ", message='" + this.f44025c + "', cause=" + this.f44026d + ", campaign=" + this.f44027e + ", ids=" + this.f44028f + ", requestId='" + this.f44029g + "', localRequestId='" + this.f44030h + "', isHeaderBidding=" + this.f44031i + ", typeD=" + this.f44032j + ", reasonD='" + this.f44033k + "', extraMap=" + this.f44034l + ", serverErrorCode=" + this.f44035m + ", errorUrl='" + this.f44036n + "', serverErrorResponse='" + this.f44037o + "'}";
    }
}
