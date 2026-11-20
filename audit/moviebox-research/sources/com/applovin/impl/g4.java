package com.applovin.impl;

import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g4 {
    public static List a(com.applovin.impl.sdk.j jVar) {
        Boolean boolB;
        if (!jVar.u().k()) {
            return null;
        }
        if (jVar.u().e() == i4.a.UNIFIED && (boolB = a4.c().b(com.applovin.impl.sdk.j.l())) != null && boolB.booleanValue()) {
            return null;
        }
        boolean zT0 = jVar.t0();
        Boolean bool = (Boolean) jVar.a(uj.f23598o, Boolean.FALSE);
        if (!zT0 || bool.booleanValue()) {
            return b(jVar);
        }
        return null;
    }

    private static List b(com.applovin.impl.sdk.j jVar) {
        return jVar.u().i() != null ? o4.b(jVar) : o4.a(jVar);
    }

    public static List c(com.applovin.impl.sdk.j jVar) {
        if (jVar.u().k()) {
            return o4.c(jVar);
        }
        return null;
    }
}
