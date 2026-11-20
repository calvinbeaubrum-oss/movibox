package com.cloud.tmc.miniutils.util;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class q {
    public static Locale a() {
        return b(e0.a());
    }

    public static Locale b(Context context) {
        return c(context.getResources().getConfiguration());
    }

    public static Locale c(Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? configuration.getLocales().get(0) : configuration.locale;
    }
}
