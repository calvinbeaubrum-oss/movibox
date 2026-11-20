package com.mbridge.msdk.e;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.cloud.tmc.integration.core.TmcEngineFactory;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static x f43887a = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static String f43888o = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f43889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final m f43890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f43891d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private w f43892e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private JSONObject f43893f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<String> f43894g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<String> f43895h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile c f43896i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile l f43897j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile d f43898k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile j f43899l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private volatile r f43900m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private volatile boolean f43901n = true;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private n f43902p;

    public k(String str, m mVar) {
        this.f43889b = str;
        this.f43890c = mVar;
    }

    public final String a() {
        if (!y.a((Object) this.f43891d) && !y.a(this.f43892e)) {
            try {
                o().a();
                this.f43901n = false;
                if (TextUtils.isEmpty(f43888o)) {
                    f43888o = UUID.randomUUID().toString();
                }
                if (!y.a(f43887a)) {
                    try {
                        f43887a.a(b(), this.f43889b, this.f43890c);
                        t.a().b();
                    } catch (Exception e11) {
                        if (a.f43738a) {
                            Log.e("TrackManager", "track manager start exception", e11);
                        }
                    }
                }
                return f43888o;
            } catch (Exception e12) {
                if (a.f43738a) {
                    Log.e("TrackManager", "start error", e12);
                }
                this.f43901n = true;
            }
        }
        return "";
    }

    public final void a(Context context) {
        this.f43891d = context;
    }

    public final void a(w wVar) {
        this.f43892e = wVar;
    }

    public final void a(JSONObject jSONObject) {
        this.f43893f = jSONObject;
    }

    public final boolean a(e eVar) {
        if (y.a(eVar)) {
            return false;
        }
        f fVar = d().f43963j;
        if (y.b(fVar)) {
            try {
                return fVar.a(eVar);
            } catch (Exception e11) {
                if (a.f43738a) {
                    Log.e("TrackManager", "event filter apply exception", e11);
                }
            }
        }
        String strA = eVar.a();
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        List<String> list = this.f43895h;
        if (list != null) {
            try {
                return !list.contains(strA);
            } catch (Exception e12) {
                if (a.f43738a) {
                    Log.e("TrackManager", "disallowTrackEventNames contains exception", e12);
                }
            }
        }
        List<String> list2 = this.f43894g;
        if (list2 != null) {
            try {
                return list2.contains(strA);
            } catch (Exception e13) {
                if (a.f43738a) {
                    Log.e("TrackManager", "allowTrackEventNames contains exception", e13);
                }
            }
        }
        return true;
    }

    public final String b() {
        if (!TextUtils.isEmpty(f43888o)) {
            return f43888o;
        }
        String string = UUID.randomUUID().toString();
        f43888o = string;
        return string;
    }

    public final String c() {
        return this.f43889b;
    }

    public final w d() {
        w wVar = this.f43892e;
        if (wVar != null) {
            return wVar;
        }
        w wVarA = new w.a().a();
        this.f43892e = wVarA;
        return wVarA;
    }

    public final Context e() {
        return this.f43891d;
    }

    public final JSONObject f() {
        JSONObject jSONObject = this.f43893f;
        if (jSONObject != null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        this.f43893f = jSONObject2;
        return jSONObject2;
    }

    public final c g() {
        if (y.a(this.f43896i)) {
            synchronized (k.class) {
                try {
                    if (y.a(this.f43896i)) {
                        this.f43896i = new c(new b(this.f43891d, TextUtils.isEmpty(this.f43889b) ? String.format("track_manager_%s.db", TmcEngineFactory.ENGINE_TYPE_DEFAULT) : String.format("track_manager_%s.db", this.f43889b), "event_table"), "event_table");
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return this.f43896i;
    }

    public final l h() {
        if (y.a(this.f43897j)) {
            synchronized (k.class) {
                try {
                    if (y.a(this.f43897j)) {
                        this.f43897j = new p(new g(g(), o(), i()));
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return this.f43897j;
    }

    public final j i() {
        if (y.a(this.f43899l)) {
            synchronized (k.class) {
                try {
                    if (y.a(this.f43899l)) {
                        this.f43899l = new j();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return this.f43899l;
    }

    public final d j() {
        if (y.a(this.f43898k)) {
            this.f43898k = d().f43961h;
        }
        return this.f43898k;
    }

    public final m k() {
        return this.f43890c;
    }

    public final int l() {
        if (d().f43954a < 0) {
            return 50;
        }
        return d().f43954a;
    }

    public final int m() {
        return Math.max(d().f43955b, 0);
    }

    public final int n() {
        return Math.max(d().f43958e, 0);
    }

    public final r o() {
        if (y.a(this.f43900m)) {
            synchronized (k.class) {
                try {
                    if (y.a(this.f43900m)) {
                        this.f43900m = new r(this);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return this.f43900m;
    }

    public final boolean p() throws IllegalStateException {
        if (y.a(d())) {
            throw new IllegalStateException("config can not be null");
        }
        if (y.a(j())) {
            throw new IllegalStateException("decorate can not be null");
        }
        if (y.a(d().f43962i)) {
            throw new IllegalStateException("responseHandler can not be null");
        }
        if (y.a(d().f43960g) || y.a(d().f43960g.c())) {
            throw new IllegalStateException("networkStackConfig or stack can not be null");
        }
        if (TextUtils.isEmpty(d().f43960g.b())) {
            throw new IllegalStateException("report url is null");
        }
        return true;
    }

    public final n q() {
        if (y.a(this.f43902p)) {
            synchronized (k.class) {
                try {
                    if (y.a(this.f43902p)) {
                        this.f43902p = new n(d().f43957d <= 0 ? 2 : d().f43957d, d().f43960g, d().f43962i, d().f43956c);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return this.f43902p;
    }

    public final boolean r() {
        return this.f43901n;
    }
}
