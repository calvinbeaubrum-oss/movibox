package com.cloud.tmc.miniutils.util;

import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class j0 {
    public static boolean a() {
        return TextUtils.getLayoutDirectionFromLocale(Build.VERSION.SDK_INT >= 24 ? e0.a().getResources().getConfiguration().getLocales().get(0) : e0.a().getResources().getConfiguration().locale) == 1;
    }
}
