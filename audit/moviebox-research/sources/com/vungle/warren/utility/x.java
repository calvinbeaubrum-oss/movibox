package com.vungle.warren.utility;

import android.util.Log;
import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f62641a = "x";

    public static boolean a(String str) {
        try {
            return new URL(str).getHost().toLowerCase().contains(".vungle.com");
        } catch (MalformedURLException e11) {
            Log.e(f62641a, e11.getMessage());
            return false;
        }
    }
}
