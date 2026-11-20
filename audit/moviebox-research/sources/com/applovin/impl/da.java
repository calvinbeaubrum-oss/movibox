package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class da {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f18398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f18399b = new HashMap();

    public da(com.applovin.impl.sdk.j jVar) {
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f18398a = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        try {
            this.f18398a.b(uj.f23609z, c().toString());
        } catch (Throwable th2) {
            this.f18398a.J();
            if (com.applovin.impl.sdk.n.a()) {
                this.f18398a.J().a("GlobalStatsManager", "Unable to save stats", th2);
            }
        }
    }

    private void f() {
        this.f18398a.j0().a(new Runnable() { // from class: com.applovin.impl.cv
            @Override // java.lang.Runnable
            public final void run() {
                this.f18311a.d();
            }
        }, tm.b.OTHER);
    }

    public long a(ca caVar, long j11) {
        long jLongValue;
        synchronized (this.f18399b) {
            try {
                Long l11 = (Long) this.f18399b.get(caVar.b());
                if (l11 == null) {
                    l11 = 0L;
                }
                jLongValue = l11.longValue() + j11;
                this.f18399b.put(caVar.b(), Long.valueOf(jLongValue));
            } catch (Throwable th2) {
                throw th2;
            }
        }
        f();
        return jLongValue;
    }

    public void a() {
        synchronized (this.f18399b) {
            this.f18399b.clear();
        }
        f();
    }

    public void a(ca caVar) {
        synchronized (this.f18399b) {
            this.f18399b.remove(caVar.b());
        }
        f();
    }

    public long b(ca caVar) {
        long jLongValue;
        synchronized (this.f18399b) {
            try {
                Long l11 = (Long) this.f18399b.get(caVar.b());
                if (l11 == null) {
                    l11 = 0L;
                }
                jLongValue = l11.longValue();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return jLongValue;
    }

    public void b() {
        synchronized (this.f18399b) {
            try {
                Iterator it = ca.a().iterator();
                while (it.hasNext()) {
                    this.f18399b.remove(((ca) it.next()).b());
                }
                f();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void b(ca caVar, long j11) {
        synchronized (this.f18399b) {
            this.f18399b.put(caVar.b(), Long.valueOf(j11));
        }
        f();
    }

    public long c(ca caVar) {
        return a(caVar, 1L);
    }

    public JSONObject c() {
        JSONObject jSONObject;
        synchronized (this.f18399b) {
            try {
                jSONObject = new JSONObject();
                for (Map.Entry entry : this.f18399b.entrySet()) {
                    JsonUtils.putLong(jSONObject, (String) entry.getKey(), ((Long) entry.getValue()).longValue());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return jSONObject;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0038 */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e() {
        JSONObject jSONObject = new JSONObject((String) this.f18398a.a(uj.f23609z, "{}"));
        synchronized (this.f18399b) {
            try {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    try {
                        String next = itKeys.next();
                        this.f18399b.put(next, Long.valueOf(jSONObject.getLong(next)));
                    } catch (JSONException unused) {
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
