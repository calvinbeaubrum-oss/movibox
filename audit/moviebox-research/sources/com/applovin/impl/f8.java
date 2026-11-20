package com.applovin.impl;

import android.os.Build;
import java.util.HashSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f18885a = "ExoPlayerLib/2.15.1 (Linux; Android " + Build.VERSION.RELEASE + ") ExoPlayerLib/2.15.1";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final HashSet f18886b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f18887c = "goog.exo.core";

    public static synchronized String a() {
        return f18887c;
    }

    public static synchronized void a(String str) {
        if (f18886b.add(str)) {
            f18887c += ", " + str;
        }
    }
}
