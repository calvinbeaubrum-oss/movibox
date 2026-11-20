package br;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import athena.a0;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14374a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14375b = 100;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f14376c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14377d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f14378e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f14379f = 100;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f14380g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f14381h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f14382i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f14383j = 30000;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f14384k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f14385l;

    public int a() {
        return this.f14382i;
    }

    public void b(int i11) {
        this.f14382i = i11;
    }

    public void c(long j11) {
        this.f14384k = j11;
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f14379f = jSONObject.getInt("gmax");
            this.f14378e = jSONObject.getInt("gmin");
            this.f14381h = jSONObject.getInt("mi");
            this.f14377d = jSONObject.getInt("nf");
            this.f14376c = jSONObject.getLong("pd");
            this.f14383j = jSONObject.getLong("se");
            this.f14375b = jSONObject.getInt("urhash");
            this.f14384k = jSONObject.getInt("frq");
            this.f14374a = jSONObject.optInt("ct", 0);
            this.f14385l = jSONObject.optInt("pr", 0);
        } catch (Exception e11) {
            a0.c(Log.getStackTraceString(e11));
        }
    }

    public long e() {
        return this.f14384k;
    }

    public void f(int i11) {
        this.f14379f = i11;
    }

    public void g(long j11) {
        this.f14376c = j11;
    }

    public int h() {
        return this.f14379f;
    }

    public void i(int i11) {
        this.f14378e = i11;
    }

    public void j(long j11) {
        this.f14380g = j11;
    }

    public int k() {
        return this.f14378e;
    }

    public void l(int i11) {
        this.f14381h = i11;
    }

    public void m(long j11) {
        this.f14383j = j11;
    }

    public int n() {
        return this.f14381h;
    }

    public void o(int i11) {
        this.f14377d = i11;
    }

    public int p() {
        return this.f14377d;
    }

    public void q(int i11) {
        this.f14385l = i11;
    }

    public int r() {
        return this.f14385l;
    }

    public void s(int i11) {
        this.f14374a = i11;
    }

    public long t() {
        long j11 = this.f14376c;
        try {
            if (!g.H()) {
                return j11;
            }
            return d.c(ws.a.a(), "debug.athena.push_during", this.f14376c).longValue();
        } catch (Exception e11) {
            a0.c("SystemPropertiesProxy.getLong " + e11.getMessage());
            return j11;
        }
    }

    @NonNull
    public String toString() {
        return "TidConfig { pushTime=" + this.f14380g + ", pushDuration=" + this.f14376c + ", maxCachedItems=" + this.f14381h + ", cachedItems=" + this.f14382i + ", netWorkFlag=" + this.f14377d + '}';
    }

    public void u(int i11) {
        this.f14375b = i11;
    }

    public long v() {
        return this.f14380g;
    }

    public long w() {
        return this.f14383j;
    }

    public int x() {
        return this.f14375b;
    }

    public String y() {
        try {
            return new JSONObject().put("gmax", this.f14379f).put("gmin", this.f14378e).put("mi", this.f14381h).put("nf", this.f14377d).put("pd", t()).put("se", this.f14383j).put("urhash", this.f14375b).put("frq", this.f14384k).put("ct", this.f14374a).put("pr", this.f14385l).toString();
        } catch (Exception e11) {
            a0.c(Log.getStackTraceString(e11));
            return null;
        }
    }
}
