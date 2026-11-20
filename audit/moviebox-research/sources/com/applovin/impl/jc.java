package com.applovin.impl;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class jc implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f19935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f19937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ke f19938d;

    public jc(String str, String str2, boolean z11, ke keVar) {
        this.f19935a = str;
        this.f19936b = str2;
        this.f19937c = z11;
        this.f19938d = keVar;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(jc jcVar) {
        return this.f19936b.compareToIgnoreCase(jcVar.f19936b);
    }

    public String a() {
        return this.f19936b;
    }

    public List b() {
        List listL = this.f19938d.l();
        return (listL == null || listL.isEmpty()) ? Collections.singletonList(this.f19935a) : listL;
    }

    public String c() {
        return this.f19935a;
    }

    public ke d() {
        return this.f19938d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        jc jcVar = (jc) obj;
        String str = this.f19935a;
        if (str == null ? jcVar.f19935a != null : !str.equals(jcVar.f19935a)) {
            return false;
        }
        String str2 = this.f19936b;
        if (str2 == null ? jcVar.f19936b == null : str2.equals(jcVar.f19936b)) {
            return this.f19937c == jcVar.f19937c;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f19935a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f19936b;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + (this.f19937c ? 1 : 0);
    }
}
