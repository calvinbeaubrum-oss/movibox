package com.amazonaws.regions;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Region {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f15899c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Boolean> f15900d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Boolean> f15901e = new HashMap();

    public Region(String str, String str2) {
        this.f15897a = str;
        if (str2 == null || str2.isEmpty()) {
            this.f15898b = "amazonaws.com";
        } else {
            this.f15898b = str2;
        }
    }

    public static Region e(Regions regions) {
        return RegionUtils.a(regions.getName());
    }

    public static Region f(String str) {
        return RegionUtils.a(str);
    }

    public String a() {
        return this.f15898b;
    }

    public Map<String, Boolean> b() {
        return this.f15900d;
    }

    public Map<String, Boolean> c() {
        return this.f15901e;
    }

    public String d() {
        return this.f15897a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Region) {
            return d().equals(((Region) obj).d());
        }
        return false;
    }

    public String g(String str) {
        return this.f15899c.get(str);
    }

    public Map<String, String> h() {
        return this.f15899c;
    }

    public int hashCode() {
        return d().hashCode();
    }

    public boolean i(String str) {
        return this.f15899c.containsKey(str);
    }

    public String toString() {
        return d();
    }
}
