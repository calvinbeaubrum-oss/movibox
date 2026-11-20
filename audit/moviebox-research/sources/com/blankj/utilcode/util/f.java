package com.blankj.utilcode.util;

import android.os.Environment;
import java.io.File;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public static boolean a() {
        return "mounted".equals(Environment.getExternalStorageState()) && j0.c(Utils.a().getExternalCacheDir());
    }

    public static boolean b() {
        return j0.c(Utils.a().getCacheDir());
    }

    public static boolean c() {
        return j0.c(new File(Utils.a().getFilesDir().getParent(), "databases"));
    }

    public static boolean d() {
        return j0.c(new File(Utils.a().getFilesDir().getParent(), "shared_prefs"));
    }
}
