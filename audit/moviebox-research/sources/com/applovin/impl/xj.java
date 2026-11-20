package com.applovin.impl;

import android.os.SystemClock;
import com.applovin.mediation.MaxAdFormat;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class xj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f24328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f24329b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f24330c = new Object();

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f24331a;

        static {
            int[] iArr = new int[b.values().length];
            f24331a = iArr;
            try {
                iArr[b.AD_FORMAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24331a[b.AD_UNIT_ID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f24331a[b.ALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum b {
        AD_FORMAT,
        AD_UNIT_ID,
        ALL
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final yj f24336a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f24337b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f24338c;

        private c(yj yjVar, long j11) {
            this.f24336a = yjVar;
            this.f24337b = j11;
            this.f24338c = SystemClock.elapsedRealtime();
        }

        public /* synthetic */ c(yj yjVar, long j11, a aVar) {
            this(yjVar, j11);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean d() {
            return SystemClock.elapsedRealtime() - this.f24338c > this.f24337b;
        }

        public long a() {
            return this.f24338c;
        }

        public boolean a(Object obj) {
            return obj instanceof c;
        }

        public long b() {
            return this.f24337b;
        }

        public yj c() {
            return this.f24336a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (!cVar.a((Object) this) || b() != cVar.b() || a() != cVar.a()) {
                return false;
            }
            yj yjVarC = c();
            yj yjVarC2 = cVar.c();
            return yjVarC != null ? yjVarC.equals(yjVarC2) : yjVarC2 == null;
        }

        public int hashCode() {
            long jB = b();
            long jA = a();
            int i11 = ((((int) (jB ^ (jB >>> 32))) + 59) * 59) + ((int) ((jA >>> 32) ^ jA));
            yj yjVarC = c();
            return (i11 * 59) + (yjVarC == null ? 43 : yjVarC.hashCode());
        }

        public String toString() {
            return "SignalCacheManager.SignalWrapper(signal=" + c() + ", expirationTimeMillis=" + b() + ", cacheTimestampMillis=" + a() + ")";
        }
    }

    public xj(com.applovin.impl.sdk.j jVar) {
        this.f24328a = jVar;
    }

    private String a(zj zjVar, String str, MaxAdFormat maxAdFormat) {
        String strC = zjVar.c();
        int i11 = a.f24331a[zjVar.u().ordinal()];
        if (i11 == 1) {
            return strC + "_" + maxAdFormat.getLabel();
        }
        if (i11 != 2) {
            return strC;
        }
        return strC + "_" + str;
    }

    public void a(yj yjVar, zj zjVar, String str, MaxAdFormat maxAdFormat) {
        if (yjVar == null) {
            return;
        }
        long jV = zjVar.v();
        if (jV <= 0) {
            return;
        }
        this.f24328a.J();
        if (com.applovin.impl.sdk.n.a()) {
            this.f24328a.J().a("SignalCacheManager", "Caching signal for: " + zjVar);
        }
        String strA = a(zjVar, str, maxAdFormat);
        c cVar = new c(yjVar, jV, null);
        synchronized (this.f24330c) {
            this.f24329b.put(strA, cVar);
        }
    }

    public yj b(zj zjVar, String str, MaxAdFormat maxAdFormat) {
        String strA = a(zjVar, str, maxAdFormat);
        synchronized (this.f24330c) {
            try {
                c cVar = (c) this.f24329b.get(strA);
                if (cVar == null) {
                    return null;
                }
                if (cVar.d()) {
                    this.f24329b.remove(strA);
                    return null;
                }
                this.f24328a.J();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f24328a.J().a("SignalCacheManager", "Returning cached signal for: " + zjVar);
                }
                return cVar.f24336a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
