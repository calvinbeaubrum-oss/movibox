package com.mbridge.msdk.e;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, m> f43903b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f43904a;

    private m(String str, Context context, w wVar) {
        k kVar = new k(str, this);
        this.f43904a = kVar;
        kVar.a(context);
        kVar.a(wVar);
    }

    public static m a(String str, Context context, w wVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ConcurrentHashMap<String, m> concurrentHashMap = f43903b;
        m mVar = concurrentHashMap.get(str);
        if (!y.a(mVar)) {
            return mVar;
        }
        m mVar2 = new m(str, context, wVar);
        concurrentHashMap.put(str, mVar2);
        return mVar2;
    }

    private boolean b(e eVar) {
        try {
            return c(eVar);
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(e eVar) {
        if (y.a(eVar) || TextUtils.isEmpty(eVar.a())) {
            return false;
        }
        return this.f43904a.a(eVar);
    }

    public static m[] d() {
        ConcurrentHashMap<String, m> concurrentHashMap = f43903b;
        m[] mVarArr = new m[concurrentHashMap.size()];
        try {
            Iterator<Map.Entry<String, m>> it = concurrentHashMap.entrySet().iterator();
            int i11 = 0;
            while (it.hasNext()) {
                mVarArr[i11] = it.next().getValue();
                i11++;
            }
        } catch (Exception e11) {
            if (a.f43738a) {
                Log.e("TrackManager", "getAllTrackManager error", e11);
            }
        }
        return mVarArr;
    }

    public final String a() {
        if (!(!this.f43904a.r())) {
            return this.f43904a.a();
        }
        if (a.f43738a) {
            Log.e("TrackManager", "MBridgeTrackManager is already running");
        }
        return this.f43904a.b();
    }

    public final void a(final e eVar) {
        if (this.f43904a.r()) {
            boolean z11 = a.f43738a;
            return;
        }
        try {
            this.f43904a.i().a(new Runnable() { // from class: com.mbridge.msdk.e.m.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (m.this.c(eVar)) {
                        m.this.f43904a.h().a(eVar);
                        eVar.c(m.this.f43904a.d().f43959f);
                        JSONObject jSONObjectD = eVar.d();
                        if (jSONObjectD != null) {
                            try {
                                jSONObjectD.put("session_id", m.this.b());
                                long[] jArrG = m.this.g();
                                jSONObjectD.put("track_time", jArrG[0]);
                                jSONObjectD.put("track_count", jArrG[1]);
                            } catch (JSONException e11) {
                                e11.printStackTrace();
                            }
                            eVar.a(jSONObjectD);
                        }
                        m.this.f43904a.h().b(eVar);
                    }
                }
            });
        } catch (Exception e11) {
            if (a.f43738a) {
                Log.e("TrackManager", "trackEvent error", e11);
            }
        }
    }

    public final void a(JSONObject jSONObject) {
        this.f43904a.a(jSONObject);
    }

    public final boolean a(String str) {
        return b(new e(str));
    }

    public final String b() {
        return this.f43904a.b();
    }

    public final String c() {
        return this.f43904a.c();
    }

    public final void e() {
        try {
            this.f43904a.i().a(new Runnable() { // from class: com.mbridge.msdk.e.m.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        t.a().c();
                        m.this.f43904a.o().b();
                    } catch (Exception e11) {
                        if (a.f43738a) {
                            Log.e("TrackManager", "flush error", e11);
                        }
                    }
                }
            });
        } catch (Exception e11) {
            if (a.f43738a) {
                Log.e("TrackManager", "flush error", e11);
            }
        }
    }

    public final JSONObject f() {
        return this.f43904a.f();
    }

    public final long[] g() {
        return this.f43904a.h().a();
    }
}
