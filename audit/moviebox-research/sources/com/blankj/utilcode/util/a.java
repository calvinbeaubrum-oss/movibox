package com.blankj.utilcode.util;

import android.app.Activity;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static List<Activity> a() {
        return j0.h();
    }

    public static Activity b() {
        return j0.t();
    }

    public static boolean c(Activity activity) {
        return (activity == null || activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }
}
