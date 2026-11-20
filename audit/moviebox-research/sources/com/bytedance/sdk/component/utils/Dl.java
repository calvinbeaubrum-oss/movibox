package com.bytedance.sdk.component.utils;

import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Dl {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static volatile String f27021sc;

    public static String sc() {
        if (!TextUtils.isEmpty(f27021sc)) {
            return f27021sc;
        }
        String str = Build.MODEL;
        f27021sc = str;
        return str;
    }
}
