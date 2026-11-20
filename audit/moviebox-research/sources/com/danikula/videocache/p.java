package com.danikula.videocache;

import android.content.Context;
import android.os.Environment;
import java.io.File;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class p {
    public static File a(Context context) {
        File externalCacheDir = "mounted".equals(Environment.getExternalStorageState()) ? context.getExternalCacheDir() : null;
        if (externalCacheDir == null) {
            externalCacheDir = context.getCacheDir();
        }
        if (externalCacheDir != null) {
            return externalCacheDir;
        }
        return new File("/data/data/" + context.getPackageName() + "/cache/");
    }

    public static File b(Context context) {
        return new File(a(context), "video-cache");
    }
}
