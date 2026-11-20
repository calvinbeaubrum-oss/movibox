package com.cloud.tmc.miniutils.util;

import android.os.Environment;
import java.io.File;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char f32001a = File.separatorChar;

    public static String a(File file) {
        return file == null ? "" : file.getAbsolutePath();
    }

    public static String b() {
        return !h0.t() ? "" : a(e0.a().getExternalCacheDir());
    }

    public static String c() {
        File externalCacheDir;
        return (h0.t() && (externalCacheDir = e0.a().getExternalCacheDir()) != null) ? a(externalCacheDir.getParentFile()) : "";
    }

    public static String d() {
        return !h0.t() ? "" : a(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
    }

    public static String e() {
        return !h0.t() ? "" : a(Environment.getExternalStorageDirectory());
    }

    public static String f() {
        return a(e0.a().getFilesDir());
    }
}
