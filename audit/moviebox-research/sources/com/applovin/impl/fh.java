package com.applovin.impl;

import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class fh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f18998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map f18999b;

    private fh(String str, Map map) {
        this.f18998a = str;
        this.f18999b = map;
    }

    public static fh a(String str) {
        return a(str, null);
    }

    public static fh a(String str, Map map) {
        return new fh(str, map);
    }

    public Map a() {
        return this.f18999b;
    }

    public String b() {
        return this.f18998a;
    }

    public String toString() {
        return "PendingReward{result='" + this.f18998a + "'params='" + this.f18999b + "'}";
    }
}
