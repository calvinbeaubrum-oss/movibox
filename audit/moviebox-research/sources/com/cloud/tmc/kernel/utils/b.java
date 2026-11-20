package com.cloud.tmc.kernel.utils;

import com.cloud.tmc.kernel.api.classloader.ClassLoaderFactory;
import com.cloud.tmc.kernel.log.TmcLogger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class b {
    public static Class<? extends com.cloud.tmc.kernel.extension.c> a(String str, String str2) {
        try {
            return ((ClassLoaderFactory) tc.a.a(ClassLoaderFactory.class)).getClassLoader(str).loadClass(str2);
        } catch (Throwable th2) {
            TmcLogger.g("TmcKernel:ClassLoaderUtils", "failed to load class", th2);
            return null;
        }
    }
}
