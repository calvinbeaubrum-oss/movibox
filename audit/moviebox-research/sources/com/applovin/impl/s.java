package com.applovin.impl;

import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f22205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f22206b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f22207c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f22208d;

    public s(String str, String str2) {
        this(str, str2, null, false);
    }

    public s(String str, String str2, Map map, boolean z11) {
        this.f22205a = str;
        this.f22206b = str2;
        this.f22207c = map;
        this.f22208d = z11;
    }

    public String a() {
        return this.f22206b;
    }

    public Map b() {
        return this.f22207c;
    }

    public String c() {
        return this.f22205a;
    }

    public boolean d() {
        return this.f22208d;
    }

    public String toString() {
        return "AdEventPostback{url='" + this.f22205a + "', backupUrl='" + this.f22206b + "', headers='" + this.f22207c + "', shouldFireInWebView='" + this.f22208d + "'}";
    }
}
