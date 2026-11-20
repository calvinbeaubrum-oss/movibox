package com.mbridge.msdk.c;

import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f43006f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f43007g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f43008h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f43001a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f43002b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f43003c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f43004d = 30;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f43005e = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f43009i = 0;

    public static d a(String str) {
        Exception e11;
        d dVar;
        try {
            JSONObject jSONObject = new JSONObject(str);
            dVar = new d();
            try {
                dVar.f43006f = jSONObject.optString("h_d", com.mbridge.msdk.foundation.same.net.g.d.f().f44628e);
                dVar.f43007g = jSONObject.optString("t_d", com.mbridge.msdk.foundation.same.net.g.d.f().f44633j);
                dVar.f43008h = jSONObject.optInt("t_p", com.mbridge.msdk.foundation.same.net.g.d.f().f44637n);
                dVar.f43009i = jSONObject.optInt("type", 1);
                dVar.f43004d = jSONObject.optInt("d_t", 30);
                dVar.f43003c = jSONObject.optInt("d_a", 0);
            } catch (Exception e12) {
                e11 = e12;
                e11.printStackTrace();
            }
        } catch (Exception e13) {
            e11 = e13;
            dVar = null;
        }
        return dVar;
    }

    public final int a() {
        return this.f43003c;
    }

    public final int b() {
        return this.f43004d;
    }

    public final String c() {
        return this.f43006f;
    }

    public final String d() {
        return this.f43007g;
    }

    public final int e() {
        return this.f43008h;
    }
}
