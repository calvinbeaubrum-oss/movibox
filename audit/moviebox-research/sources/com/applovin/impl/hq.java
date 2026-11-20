package com.applovin.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class hq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f19530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19531b;

    private hq(String str, String str2) {
        this.f19530a = str;
        this.f19531b = str2;
    }

    public static hq a(es esVar, com.applovin.impl.sdk.j jVar) {
        if (esVar == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        try {
            return new hq((String) esVar.a().get("apiFramework"), esVar.d());
        } catch (Throwable th2) {
            jVar.J();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.J().a("VastJavaScriptResource", "Error occurred while initializing", th2);
            }
            jVar.E().a("VastJavaScriptResource", th2);
            return null;
        }
    }

    public String a() {
        return this.f19530a;
    }

    public String b() {
        return this.f19531b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        hq hqVar = (hq) obj;
        String str = this.f19530a;
        if (str == null ? hqVar.f19530a != null : !str.equals(hqVar.f19530a)) {
            return false;
        }
        String str2 = this.f19531b;
        String str3 = hqVar.f19531b;
        if (str2 != null) {
            return str2.equals(str3);
        }
        return str3 == null;
    }

    public int hashCode() {
        String str = this.f19530a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f19531b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "VastJavaScriptResource{apiFramework='" + this.f19530a + "', javascriptResourceUrl='" + this.f19531b + "'}";
    }
}
