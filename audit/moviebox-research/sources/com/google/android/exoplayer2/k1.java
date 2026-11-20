package com.google.android.exoplayer2;

import java.util.HashSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashSet<String> f33401a = new HashSet<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f33402b = "goog.exo.core";

    public static synchronized void a(String str) {
        if (f33401a.add(str)) {
            f33402b += ", " + str;
        }
    }

    public static synchronized String b() {
        return f33402b;
    }
}
