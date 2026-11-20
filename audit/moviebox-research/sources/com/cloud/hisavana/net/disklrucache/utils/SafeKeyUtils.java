package com.cloud.hisavana.net.disklrucache.utils;

import android.util.Log;
import android.util.LruCache;
import com.cloud.hisavana.net.disklrucache.ImageCacheURL;
import com.cloud.sdk.commonutil.util.c;
import com.transsion.api.gateway.utils.EncoderUtil;
import java.security.MessageDigest;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class SafeKeyUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LruCache<ImageCacheURL, String> f29017a = new LruCache<>(1000);

    public static String a(ImageCacheURL imageCacheURL) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(EncoderUtil.ALGORITHM_SHA_256);
            messageDigest.update(imageCacheURL.a());
            return DiskLruCacheUtil.j(messageDigest.digest());
        } catch (Exception e11) {
            c.netLog("calculateHexStringDigest: " + Log.getStackTraceString(e11));
            return "";
        }
    }

    public static String b(ImageCacheURL imageCacheURL) {
        String strA;
        LruCache<ImageCacheURL, String> lruCache = f29017a;
        synchronized (lruCache) {
            strA = lruCache.get(imageCacheURL);
        }
        if (strA == null) {
            strA = a(imageCacheURL);
        }
        synchronized (lruCache) {
            lruCache.put(imageCacheURL, strA);
        }
        return strA;
    }
}
