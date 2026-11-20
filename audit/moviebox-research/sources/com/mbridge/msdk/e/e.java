package com.mbridge.msdk.e;

import java.io.Serializable;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class e implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f43855a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private JSONObject f43858d;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private h f43863i;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f43856b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f43857c = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f43861g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f43862h = 604800000;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f43864j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f43865k = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f43860f = System.currentTimeMillis();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f43859e = UUID.randomUUID().toString();

    public e(String str) {
        this.f43855a = str;
    }

    public final String a() {
        return this.f43855a;
    }

    public final void a(int i11) {
        this.f43856b = i11;
    }

    public final void a(long j11) {
        this.f43860f = j11;
    }

    public final void a(h hVar) {
        this.f43863i = hVar;
    }

    public final void a(String str) {
        this.f43859e = str;
    }

    public final void a(JSONObject jSONObject) {
        this.f43858d = jSONObject;
    }

    public final void a(boolean z11) {
        this.f43865k = z11;
    }

    public final int b() {
        return this.f43856b;
    }

    public final void b(int i11) {
        this.f43857c = i11;
    }

    public final void b(long j11) {
        this.f43861g = j11;
    }

    public final int c() {
        return this.f43857c;
    }

    public final void c(long j11) {
        this.f43862h = j11;
    }

    public final JSONObject d() {
        JSONObject jSONObject = this.f43858d;
        if (jSONObject != null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        this.f43858d = jSONObject2;
        return jSONObject2;
    }

    public final String e() {
        return this.f43859e;
    }

    public final long f() {
        return this.f43860f;
    }

    public final long g() {
        return this.f43861g;
    }

    public final long h() {
        return this.f43862h;
    }

    public final h i() {
        return this.f43863i;
    }

    public final boolean j() {
        return this.f43864j;
    }

    public final boolean k() {
        return this.f43865k;
    }
}
