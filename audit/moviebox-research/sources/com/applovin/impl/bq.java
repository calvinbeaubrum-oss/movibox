package com.applovin.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class bq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f18033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f18034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f18035c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set f18036d;

    private bq(String str, List list, String str2, Set set) {
        this.f18033a = str;
        this.f18034b = list;
        this.f18035c = str2;
        this.f18036d = set;
    }

    public static bq a(es esVar, eq eqVar, com.applovin.impl.sdk.j jVar) {
        try {
            String str = (String) esVar.a().get("vendor");
            es esVarB = esVar.b("VerificationParameters");
            String strD = esVarB != null ? esVarB.d() : null;
            List listA = esVar.a("JavaScriptResource");
            ArrayList arrayList = new ArrayList(listA.size());
            Iterator it = listA.iterator();
            while (it.hasNext()) {
                hq hqVarA = hq.a((es) it.next(), jVar);
                if (hqVarA != null) {
                    arrayList.add(hqVarA);
                }
            }
            HashMap map = new HashMap();
            mq.a(esVar, map, eqVar, jVar);
            return new bq(str, arrayList, strD, (Set) map.get("verificationNotExecuted"));
        } catch (Throwable th2) {
            jVar.J();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.J().a("VastAdVerification", "Error occurred while initializing", th2);
            }
            jVar.E().a("VastAdVerification", th2);
            return null;
        }
    }

    public Set a() {
        return this.f18036d;
    }

    public List b() {
        return this.f18034b;
    }

    public String c() {
        return this.f18033a;
    }

    public String d() {
        return this.f18035c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        bq bqVar = (bq) obj;
        String str = this.f18033a;
        if (str == null ? bqVar.f18033a != null : !str.equals(bqVar.f18033a)) {
            return false;
        }
        List list = this.f18034b;
        if (list == null ? bqVar.f18034b != null : !list.equals(bqVar.f18034b)) {
            return false;
        }
        String str2 = this.f18035c;
        if (str2 == null ? bqVar.f18035c != null : !str2.equals(bqVar.f18035c)) {
            return false;
        }
        Set set = this.f18036d;
        Set set2 = bqVar.f18036d;
        if (set != null) {
            return set.equals(set2);
        }
        return set2 == null;
    }

    public int hashCode() {
        String str = this.f18033a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List list = this.f18034b;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.f18035c;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Set set = this.f18036d;
        return iHashCode3 + (set != null ? set.hashCode() : 0);
    }

    public String toString() {
        return "VastAdVerification{vendorId='" + this.f18033a + "'javascriptResources='" + this.f18034b + "'verificationParameters='" + this.f18035c + "'errorEventTrackers='" + this.f18036d + "'}";
    }
}
