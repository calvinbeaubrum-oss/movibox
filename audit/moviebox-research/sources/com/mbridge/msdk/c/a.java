package com.mbridge.msdk.c;

import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f42891e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f42892f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f42893g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f42887a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f42888b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f42889c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f42890d = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f42894h = 0;

    public static a a(String str) {
        Exception e11;
        a aVar;
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar = new a();
            try {
                aVar.f42891e = jSONObject.optString("http_domain", com.mbridge.msdk.foundation.same.net.g.d.f().f44630g);
                aVar.f42892f = jSONObject.optString("tcp_domain", com.mbridge.msdk.foundation.same.net.g.d.f().f44634k);
                aVar.f42893g = jSONObject.optInt("tcp_port", com.mbridge.msdk.foundation.same.net.g.d.f().f44638o);
                aVar.f42894h = jSONObject.optInt("type", 0);
                int i11 = 1;
                int iOptInt = jSONObject.optInt("batch_size", 1);
                if (iOptInt >= 1) {
                    i11 = iOptInt;
                }
                aVar.f42887a = i11;
                aVar.f42889c = jSONObject.optInt("duration", 0);
                aVar.f42888b = jSONObject.optInt("disable", 0);
                aVar.f42890d = jSONObject.optInt("e_t_l", 0);
            } catch (Exception e12) {
                e11 = e12;
                e11.printStackTrace();
            }
        } catch (Exception e13) {
            e11 = e13;
            aVar = null;
        }
        return aVar;
    }

    public final int a() {
        return this.f42887a;
    }

    public final int b() {
        return this.f42888b;
    }

    public final int c() {
        return this.f42889c;
    }

    public final int d() {
        return this.f42890d;
    }

    public final String e() {
        return this.f42891e;
    }

    public final String f() {
        return this.f42892f;
    }

    public final int g() {
        return this.f42893g;
    }

    public final int h() {
        return this.f42894h;
    }
}
