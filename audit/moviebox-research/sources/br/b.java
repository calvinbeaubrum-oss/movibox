package br;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import athena.a0;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14317a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f14320d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f14321e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f14323g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f14324h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f14325i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f14326j;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f14318b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14319c = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<a> f14322f = new CopyOnWriteArrayList();

    @Nullable
    public static b c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            b bVar = new b();
            bVar.f14318b = jSONObject.getLong("npt");
            bVar.f14319c = jSONObject.getInt("rt");
            bVar.f14320d = jSONObject.getLong("ver");
            bVar.f14321e = jSONObject.optInt("dim");
            bVar.f14324h = jSONObject.optString("url");
            bVar.f14323g = jSONObject.optString("opcode");
            bVar.f14325i = jSONObject.optInt("interval");
            bVar.f14326j = jSONObject.optInt("offline");
            return bVar;
        } catch (Exception e11) {
            a0.c(Log.getStackTraceString(e11));
            return null;
        }
    }

    public int a() {
        return this.f14317a;
    }

    public a b(long j11) {
        for (a aVar : this.f14322f) {
            if (aVar.d() == j11) {
                return aVar;
            }
        }
        return null;
    }

    public void d(int i11) {
        this.f14317a = i11;
    }

    public void e(a aVar) {
        this.f14322f.add(aVar);
    }

    public boolean f(long j11, int i11) {
        if (this.f14318b == -1 || j11 == -1) {
            return true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j12 = jCurrentTimeMillis - this.f14318b;
        if (Math.abs(j12) < j11) {
            return j12 >= 0 && this.f14319c < i11;
        }
        j(jCurrentTimeMillis);
        return true;
    }

    public int g() {
        return this.f14321e;
    }

    public a h(String str) {
        for (a aVar : this.f14322f) {
            if (TextUtils.equals(aVar.c(), str)) {
                return aVar;
            }
        }
        return null;
    }

    public void i(int i11) {
        this.f14321e = i11;
    }

    public void j(long j11) {
        this.f14318b = j11;
        this.f14319c = 0;
    }

    public int k() {
        return this.f14325i;
    }

    public void l(int i11) {
        this.f14325i = i11;
    }

    public void m(long j11) {
        this.f14320d = j11;
    }

    public void n(String str) {
        this.f14323g = str;
    }

    public int o() {
        return this.f14326j;
    }

    public void p(int i11) {
        this.f14326j = i11;
    }

    public void q(String str) {
        this.f14324h = str;
    }

    public String r() {
        return this.f14323g;
    }

    public void s(int i11) {
        this.f14319c = i11;
    }

    public int t() {
        return this.f14319c;
    }

    public String u() {
        return this.f14324h;
    }

    public long v() {
        if (d.m(this.f14322f)) {
            return 0L;
        }
        return this.f14322f.get(0).e().w();
    }

    public List<a> w() {
        return this.f14322f;
    }

    public long x() {
        return this.f14320d;
    }

    public boolean y() {
        return d.m(this.f14322f);
    }

    public String z() {
        try {
            return new JSONObject().put("npt", this.f14318b).put("rt", this.f14319c).put("ver", this.f14320d).put("dim", this.f14321e).put("url", this.f14324h).put("interval", this.f14325i).put("offline", this.f14326j).put("opcode", this.f14323g).toString();
        } catch (Exception e11) {
            a0.c(Log.getStackTraceString(e11));
            return null;
        }
    }
}
