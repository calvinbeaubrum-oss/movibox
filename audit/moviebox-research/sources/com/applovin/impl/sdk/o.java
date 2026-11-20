package com.applovin.impl.sdk;

import com.applovin.impl.ge;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n f22805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f22806b = new HashMap(5);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f22807c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f22808d = Collections.synchronizedMap(new HashMap(5));

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map f22809e = Collections.synchronizedMap(new HashMap(5));

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f22810a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f22811b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f22812c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f22813d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f22814e;

        public a(String str, String str2, String str3) {
            this.f22810a = str;
            this.f22811b = str2;
            this.f22812c = str3;
        }

        public String a() {
            return this.f22811b;
        }

        public boolean a(Object obj) {
            return obj instanceof a;
        }

        public String b() {
            return this.f22810a;
        }

        public String c() {
            return this.f22812c;
        }

        public String d() {
            return this.f22813d;
        }

        public String e() {
            return this.f22814e;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!aVar.a(this)) {
                return false;
            }
            String strB = b();
            String strB2 = aVar.b();
            if (strB != null ? !strB.equals(strB2) : strB2 != null) {
                return false;
            }
            String strA = a();
            String strA2 = aVar.a();
            if (strA != null ? !strA.equals(strA2) : strA2 != null) {
                return false;
            }
            String strC = c();
            String strC2 = aVar.c();
            if (strC != null ? !strC.equals(strC2) : strC2 != null) {
                return false;
            }
            String strD = d();
            String strD2 = aVar.d();
            if (strD != null ? !strD.equals(strD2) : strD2 != null) {
                return false;
            }
            String strE = e();
            String strE2 = aVar.e();
            return strE != null ? strE.equals(strE2) : strE2 == null;
        }

        public int hashCode() {
            String strB = b();
            int iHashCode = strB == null ? 43 : strB.hashCode();
            String strA = a();
            int iHashCode2 = ((iHashCode + 59) * 59) + (strA == null ? 43 : strA.hashCode());
            String strC = c();
            int iHashCode3 = (iHashCode2 * 59) + (strC == null ? 43 : strC.hashCode());
            String strD = d();
            int iHashCode4 = (iHashCode3 * 59) + (strD == null ? 43 : strD.hashCode());
            String strE = e();
            return (iHashCode4 * 59) + (strE != null ? strE.hashCode() : 43);
        }

        public String toString() {
            return "MediationWaterfallWinnerTracker.WinningAd(bCode=" + b() + ", adapterName=" + a() + ", networkName=" + c() + ", secondWinnerAdapterName=" + d() + ", secondWinnerNetworkName=" + e() + ")";
        }
    }

    public o(j jVar) {
        this.f22805a = jVar.J();
    }

    public String a(String str) {
        return (String) this.f22809e.get(str);
    }

    public void a(ge geVar) {
        synchronized (this.f22807c) {
            try {
                String adUnitId = geVar.getAdUnitId();
                a aVar = (a) this.f22806b.get(adUnitId);
                if (aVar == null) {
                    if (n.a()) {
                        this.f22805a.a("MediationWaterfallWinnerTracker", "No previous winner to clear.");
                    }
                    return;
                }
                if (geVar.C().equals(aVar.b())) {
                    if (n.a()) {
                        this.f22805a.a("MediationWaterfallWinnerTracker", "Clearing previous winning ad: " + aVar);
                    }
                    this.f22806b.remove(adUnitId);
                } else if (n.a()) {
                    this.f22805a.a("MediationWaterfallWinnerTracker", "Previous winner not cleared for ad: " + geVar + " , since it could have already been updated with a new ad: " + aVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void a(ge geVar, ge geVar2) {
        synchronized (this.f22807c) {
            try {
                if (n.a()) {
                    this.f22805a.a("MediationWaterfallWinnerTracker", "Tracking winning ad: " + geVar);
                }
                a aVar = new a(geVar.C(), geVar.c(), geVar.getNetworkName());
                if (geVar2 != null) {
                    aVar.f22813d = geVar2.c();
                    aVar.f22814e = geVar2.getNetworkName();
                }
                this.f22806b.put(geVar.getAdUnitId(), aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.f22809e.put(geVar.getAdUnitId(), geVar.T());
    }

    public String b(String str) {
        return (String) this.f22808d.get(str);
    }

    public void b(ge geVar) {
        this.f22808d.put(geVar.getAdUnitId(), geVar.T());
    }

    public a c(String str) {
        a aVar;
        synchronized (this.f22807c) {
            aVar = (a) this.f22806b.get(str);
        }
        return aVar;
    }

    public void c(ge geVar) {
        a(geVar, null);
    }
}
