package com.applovin.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class cq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f18301a;

    private cq(List list) {
        this.f18301a = list;
    }

    public static cq a(es esVar, cq cqVar, eq eqVar, com.applovin.impl.sdk.j jVar) {
        try {
            List listA = cqVar != null ? cqVar.a() : new ArrayList();
            Iterator it = esVar.a("Verification").iterator();
            while (it.hasNext()) {
                bq bqVarA = bq.a((es) it.next(), eqVar, jVar);
                if (bqVarA != null) {
                    listA.add(bqVarA);
                }
            }
            return new cq(listA);
        } catch (Throwable th2) {
            jVar.J();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.J().a("VastAdVerifications", "Error occurred while initializing", th2);
            }
            jVar.E().a("VastAdVerifications", th2);
            return null;
        }
    }

    public List a() {
        return this.f18301a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof cq) {
            return this.f18301a.equals(((cq) obj).f18301a);
        }
        return false;
    }

    public int hashCode() {
        return this.f18301a.hashCode();
    }

    public String toString() {
        return "VastAdVerification{verifications='" + this.f18301a + "'}";
    }
}
