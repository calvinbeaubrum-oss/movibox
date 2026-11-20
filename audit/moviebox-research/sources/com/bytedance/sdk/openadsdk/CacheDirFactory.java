package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import com.bykv.vk.openvk.sc.sc.pFF.sc.sc.sc;
import com.bytedance.sdk.component.utils.TRI;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.multipro.pFF;
import java.io.File;
import w8.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class CacheDirFactory {
    public static volatile a MEDIA_CACHE_DIR = null;
    public static String ROOT_DIR = null;
    public static final int SPLASH_USE_INTERNAL_STORAGE = 1;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static String f27064sc;

    public static int getCacheType() {
        return 1;
    }

    public static String getDiskCacheDirPath(String str) {
        return getRootDir() + File.separator + str;
    }

    public static a getICacheDir(int i11) {
        return sc();
    }

    public static String getImageCacheDir() {
        if (f27064sc == null) {
            f27064sc = getDiskCacheDirPath("image");
        }
        return f27064sc;
    }

    public static String getRootDir() {
        if (!TextUtils.isEmpty(ROOT_DIR)) {
            return ROOT_DIR;
        }
        File fileSc = TRI.sc(Xc.sc(), pFF.zY(), "tt_ad");
        if (fileSc.isFile()) {
            fileSc.delete();
        }
        if (!fileSc.exists()) {
            fileSc.mkdirs();
        }
        String absolutePath = fileSc.getAbsolutePath();
        ROOT_DIR = absolutePath;
        return absolutePath;
    }

    private static a sc() {
        if (MEDIA_CACHE_DIR == null) {
            synchronized (CacheDirFactory.class) {
                try {
                    if (MEDIA_CACHE_DIR == null) {
                        sc scVar = new sc();
                        MEDIA_CACHE_DIR = scVar;
                        scVar.sc(getRootDir());
                        MEDIA_CACHE_DIR.We();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return MEDIA_CACHE_DIR;
    }
}
