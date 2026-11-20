package com.applovin.impl;

import com.applovin.impl.sdk.utils.StringUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class jq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f20023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f20024b;

    private jq() {
    }

    public static jq a(es esVar, jq jqVar, com.applovin.impl.sdk.j jVar) {
        if (esVar == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        if (jqVar == null) {
            try {
                jqVar = new jq();
            } catch (Throwable th2) {
                jVar.J();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.J().a("VastSystemInfo", "Error occurred while initializing", th2);
                }
                jVar.E().a("VastSystemInfo", th2);
                return null;
            }
        }
        if (!StringUtils.isValidString(jqVar.f20023a)) {
            String strD = esVar.d();
            if (StringUtils.isValidString(strD)) {
                jqVar.f20023a = strD;
            }
        }
        if (!StringUtils.isValidString(jqVar.f20024b)) {
            String str = (String) esVar.a().get("version");
            if (StringUtils.isValidString(str)) {
                jqVar.f20024b = str;
            }
        }
        return jqVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof jq)) {
            return false;
        }
        jq jqVar = (jq) obj;
        String str = this.f20023a;
        if (str == null ? jqVar.f20023a != null : !str.equals(jqVar.f20023a)) {
            return false;
        }
        String str2 = this.f20024b;
        String str3 = jqVar.f20024b;
        if (str2 != null) {
            return str2.equals(str3);
        }
        return str3 == null;
    }

    public int hashCode() {
        String str = this.f20023a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f20024b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "VastSystemInfo{name='" + this.f20023a + "', version='" + this.f20024b + "'}";
    }
}
