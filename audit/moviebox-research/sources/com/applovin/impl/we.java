package com.applovin.impl;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class we {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set f24087b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final we f24088c = a("ar");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final we f24089d = a("ttdasi_ms");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f24090a;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        Object a(Object obj);
    }

    private we(String str) {
        this.f24090a = str;
    }

    private static we a(String str) {
        Set set = f24087b;
        if (!set.contains(str)) {
            set.add(str);
            return new we(str);
        }
        throw new IllegalArgumentException("Key has already been used: " + str);
    }

    public String a() {
        return this.f24090a;
    }

    public boolean a(Object obj) {
        return obj instanceof we;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof we)) {
            return false;
        }
        we weVar = (we) obj;
        if (!weVar.a(this)) {
            return false;
        }
        String strA = a();
        String strA2 = weVar.a();
        return strA != null ? strA.equals(strA2) : strA2 == null;
    }

    public int hashCode() {
        String strA = a();
        return (strA == null ? 43 : strA.hashCode()) + 59;
    }

    public String toString() {
        return this.f24090a;
    }
}
